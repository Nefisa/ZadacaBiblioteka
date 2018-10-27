
public class KreirajRacun extends Racun {
	
	// kreira racun samo ako su svi uslovi ispunjeni
	
	public void kreirajRacun(int brojRacuna, String imeKorisnika) {
		if ( validacijaBrojaRacuna(brojRacuna)) {
			Racun racun = new Racun(brojRacuna, imeKorisnika);
			System.out.println("Racun je kreiran.");
		}
		else 
			System.out.println("Racun nije moguce kreirati.");
	}
	
	// provjerava da li je broj racun ispravan unos
	
	public boolean validacijaBrojaRacuna(int brojRacuna) {
		if ( brojRacuna < 0) {
			System.out.println("Broj racuna ne smije biti negativan broj.");
			return false;
		}
		for ( Racun racun : racuni ) {
			if ( racun.getBrojRacuna() == brojRacuna) {
				System.out.println("Racun pod tim brojem vec postoji.");
				return false;
			}
		}
		return true;
	}
	
	

}
