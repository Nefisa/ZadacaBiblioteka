import java.util.ArrayList;
import java.util.Date;

public class Biblioteka {
	
	private int brojRacuna;
	private int brojKnjige;
	private Date datum;
	
	// pohranjuje podatke o preuzetim knjigama
	
	private static ArrayList<Biblioteka> listaPosudjivanja = new ArrayList<>();
	
	// pohranjuje podatke o vracenim knjigama 
	
	private static ArrayList<Biblioteka> listaVracanja = new ArrayList<>();
	
	public Biblioteka() {
		
	}
	
	public Biblioteka(int brojRacuna, int brojKnjige, Date datum) {
		this.brojRacuna = brojRacuna;
		this.brojKnjige = brojKnjige;
		this.datum = datum;
	}
	
	// ako su ispunjeni uslovi za preuzimanje knjige, poziva odgovarajuce metode i dodaje unos u list posudjivanja

	public static void podigniKnjigu(int brojRacuna, int brojKnjige) {
		if (Racun.provjeriRacun(brojRacuna) && Knjiga.provjeriDostupnostKnjige(brojKnjige)
				&& Racun.provjeriBrojKnjiga(brojRacuna)) {
			Racun.povecajBrojPosudjenihKnjiga(brojRacuna);
			Knjiga.preuzetaKnjiga(brojKnjige);
			Date datum = new Date();
			System.out.println("Knjiga preuzeta na dan: " + datum);
			Biblioteka biblioteka = new Biblioteka(brojRacuna, brojKnjige, datum);
			listaPosudjivanja.add(biblioteka);
		} else
			System.out.println("Nemoguce izdati knjigu.");
	}
	
	// ukoliko su ispunjeni uslovi za vracanje knjige, poziva odgovarajuce metode i dodaje unos u listu vracanja

	public static void vratiKnjigu(int brojRacuna, int brojKnjige) {
		if (Racun.provjeriRacun(brojRacuna) && Knjiga.provjeriKnjigu(brojKnjige)) {
			Racun.smanjiBrojPosudjenihKnjiga(brojRacuna);
			Knjiga.vracenaKnjiga(brojKnjige);
			Date datum = new Date();
			System.out.println("Knjiga vracena na dan: " + datum);
			Biblioteka biblioteka = new Biblioteka(brojRacuna, brojKnjige, datum);
			listaVracanja.add(biblioteka);
		}
	}

	public static void ispisiListe() {
		System.out.println("Lista posudjenih knjiga:");
		System.out.println("-------------------------");
		for ( Biblioteka unos : listaPosudjivanja)
			System.out.println("Broj racuna: " + unos.brojRacuna + ", broj knjige: " + unos.brojKnjige + " preuzeta na dan " + unos.datum);
	
		
		System.out.println("\nLista vracenih knjiga:");
		System.out.println("-------------------------");
		for ( Biblioteka unos : listaVracanja)
			System.out.println("Broj racuna: " + unos.brojRacuna + ", broj knjige: " + unos.brojKnjige + " vracena na dan " + unos.datum);
	}
	
	

}
