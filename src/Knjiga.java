import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Knjiga {

	private int brojKnjige;
	private String nazivKnjige;
	private boolean statusKnjige;  
	
	protected static ArrayList<Knjiga> listaKnjiga = new ArrayList<>(); // pohranjuje sve kreirane knjige

	public Knjiga() {

	}

	protected Knjiga(int brojKnjige, String nazivKnjige) throws IOException {
		this.brojKnjige = brojKnjige;
		this.nazivKnjige = nazivKnjige;
		this.statusKnjige = true;
		listaKnjiga.add(this); // nakon kreiranja nova knjiga se dodaje u array list
		upisiUFile(this.brojKnjige, this.nazivKnjige); // nakon kreiranja nova knjiga se dodaje u tekstualni file
	}
	
	
	// metoda kreirajKnjigu() provjerava da li su ispunjeni svi uslovi za kreiranje knjige, i tek ako jesu 
	// poziva konstruktor i kreira novu knjigu
	public static void kreirajKnjigu(int brojKnjige, String naziv) throws IOException {
		if (validacijaBrojaKnjige(brojKnjige)) {
			Knjiga knjiga = new Knjiga(brojKnjige,naziv);
			System.out.println("Knjiga dodana u bazu i dostupna za preuzimanje.");
		} else
			System.out.println("Nemoguce dodati knjigu u bazu.");
	}
	
	public static boolean validacijaBrojaKnjige(int brojKnjige) {
		for ( Knjiga knjiga : listaKnjiga) {
			if ( knjiga.getBrojKnjige() == brojKnjige) {
				System.out.println("Broj knjige vec u upotrebi.");
				return false;
			}
		}
		if ( brojKnjige < 0) {
			System.out.println("Broj knjige ne smije biti negativan broj.");
			return false;
		}
		
		return true;
		
	}

	public static boolean provjeriDostupnostKnjige(int brojKnjige) { // provjerava da li je knjiga dostupna
		for (Knjiga knjiga : listaKnjiga) {
			if (knjiga.getBrojKnjige() == brojKnjige)
				if (knjiga.isStatusKnjige() == true)
					return true;
		}
		System.out.println("Knjiga nije dostupna.");
		return false;
	}
	
	public static boolean provjeriKnjigu(int brojKnjige) { // provjerava da li knjiga pod datim brojem postoji u sistemu
		for (Knjiga knjiga : listaKnjiga) {
			if (knjiga.getBrojKnjige() == brojKnjige)
					return true;
		}
		System.out.println("Knjiga pod datim brojem ne postoji u sistemu.");
		return false;

	}

	public static void preuzetaKnjiga(int brojKnjige) { 
		for (Knjiga knjiga : listaKnjiga) {
			if (knjiga.getBrojKnjige() == brojKnjige) {
				knjiga.setStatusKnjige(false);
				System.out.println("Knjiga broj: " + knjiga.brojKnjige + " je preuzeta.");
			}
		}
	}

	public static void vracenaKnjiga(int brojKnjige) {
		for (Knjiga knjiga : listaKnjiga) {
			if (knjiga.getBrojKnjige() == brojKnjige) {
				knjiga.setStatusKnjige(true);
				System.out.println("Knjiga broj: " + knjiga.brojKnjige + " je sada dostupna.");
			}
		}
	}
	
	// kreira file u koji ce upisati sve knjige dodane u biblioteku
	public static void kreirajFile() {
		
		java.io.File file = new java.io.File("ListaKnjiga.txt");
	}
	
	
	// upisuje u file dodanu knjigu
	public void upisiUFile(int brojKnjige, String nazivKnjige) throws IOException {
		
		try(FileWriter fw = new FileWriter("ListaKnjiga.txt", true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
			{
			out.println(brojKnjige + " " + nazivKnjige);
			out.close();
			bw.close();
			fw.close();
			}
		
			  
	}
	
	// prilikom svakog izlaska iz aplikacije poziva se ova metoda, koja brise file u koji su pohranjene knjige
	public static void izbrisiFile() throws IOException {
		
		Files.deleteIfExists(Paths.get("ListaKnjiga.txt"));
	}
	

	public boolean isStatusKnjige() {
		return statusKnjige;
	}

	public void setStatusKnjige(boolean statusKnjige) {
		this.statusKnjige = statusKnjige;
	}

	public int getBrojKnjige() {
		return brojKnjige;
	}

	public String getNazivKnjige() {
		return nazivKnjige;
	}

}
