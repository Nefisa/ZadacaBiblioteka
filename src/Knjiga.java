import java.util.ArrayList;

public class Knjiga {

	private int brojKnjige;
	private String nazivKnjige;
	private boolean statusKnjige;  
	
	protected static ArrayList<Knjiga> listaKnjiga = new ArrayList<>(); // pohranjuje sve kreirane knjige

	public Knjiga() {

	}

	protected Knjiga(int brojKnjige, String nazivKnjige) {
		this.brojKnjige = brojKnjige;
		this.nazivKnjige = nazivKnjige;
		this.statusKnjige = true;
		listaKnjiga.add(this);
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
