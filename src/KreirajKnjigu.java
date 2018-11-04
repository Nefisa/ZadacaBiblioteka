import java.io.IOException;

public class KreirajKnjigu extends Knjiga{
	
	// kreira knjigu samo ako broj knjige ispunjava uslove
	
	public void kreirajKnjigu(int brojKnjige, String naziv) throws IOException {
		if (validacijaBrojaKnjige(brojKnjige)) {
			Knjiga knjiga = new Knjiga(brojKnjige,naziv);
			System.out.println("Knjiga dodana u bazu i dostupna za preuzimanje.");
		} else
			System.out.println("Nemoguce dodati knjigu u bazu.");
	}
	
	public boolean validacijaBrojaKnjige(int brojKnjige) {
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

}
