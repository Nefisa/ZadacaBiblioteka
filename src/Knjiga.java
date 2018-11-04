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
		listaKnjiga.add(this);
		upisiUFile(this.brojKnjige, this.nazivKnjige);
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
	
	public static void kreirajFile() {
		
		java.io.File file = new java.io.File("ListaKnjiga.txt");
	}
	
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
	
	public static void izbrisiFile() throws IOException {
		
		Files.deleteIfExists(Paths.get("C:\\Users\\Nefisa\\eclipse-workspace\\ZadacaBiblioteka\\ListaKnjiga.txt"));
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
