import java.util.ArrayList;

public class Racun {

	private int brojRacuna;
	private String imeKorisnika;
	private int brojPosudjenihKnjiga = 0;

	protected static ArrayList<Racun> racuni = new ArrayList<>(); // pohranjuje sve racune koji su kreirani

	public Racun() {

	}

	private Racun(int brojRacuna, String ime) {
		this.brojRacuna = brojRacuna;
		this.imeKorisnika = ime;
		racuni.add(this);
	}

	// kreira racun samo ako su svi uslovi ispunjeni
	public static void kreirajRacun(int brojRacuna, String imeKorisnika) {
		if (validacijaBrojaRacuna(brojRacuna)) {
			Racun racun = new Racun(brojRacuna, imeKorisnika);
			System.out.println("Racun je kreiran.");
		} else
			System.out.println("Racun nije moguce kreirati.");
	}

	// provjerava da li je broj racuna ispravan unos
	public static boolean validacijaBrojaRacuna(int brojRacuna) {
		if (brojRacuna < 0) {
			System.out.println("Broj racuna ne smije biti negativan broj.");
			return false;
		}
		for (Racun racun : racuni) {
			if (racun.getBrojRacuna() == brojRacuna) {
				System.out.println("Racun pod tim brojem vec postoji.");
				return false;
			}
		}
		return true;
	}

	public static boolean provjeriRacun(int brojRacuna) { // provjerava da li racun postoji u sistemu
		for (Racun racun : racuni) {
			if (racun.getBrojRacuna() == brojRacuna)
				return true;

		}
		System.out.println("Nije pronadjen dati broj racuna.");
		return false;
	}

	public static void povecajBrojPosudjenihKnjiga(int brojRacuna) { // povecava broj posudjenih knjiga za 1
		for (Racun racun : racuni) {
			if (racun.getBrojRacuna() == brojRacuna) {
				racun.setBrojPosudjenihKnjiga(racun.getBrojPosudjenihKnjiga() + 1);
				System.out.println("Racun broj: " + racun.getBrojPosudjenihKnjiga());
				System.out.println("Broj posudjenih knjiga: " + racun.getBrojPosudjenihKnjiga());
			}
		}
	}

	public static boolean provjeriBrojKnjiga(int brojRacuna) { // provjerava broj posudjenih knjiga
		for (Racun racun : racuni) {
			if (racun.getBrojRacuna() == brojRacuna)
				if (racun.getBrojPosudjenihKnjiga() < 3)
					return true;
				else
					System.out.println("Presli ste limit za podizanje knjiga.");
		}
		return false;
	}

	public static void smanjiBrojPosudjenihKnjiga(int brojRacuna) { // smanjuje broj posudjenih knjiga za 1
		for (Racun racun : racuni) {
			if (racun.getBrojRacuna() == brojRacuna) {
				racun.setBrojPosudjenihKnjiga(racun.getBrojPosudjenihKnjiga() - 1);
				System.out.println("Racun broj: " + racun.getBrojPosudjenihKnjiga());
				System.out.println("Broj posudjenih knjiga: " + racun.getBrojPosudjenihKnjiga());
			}
		}
	}

	public String getImeKorisnika() {
		return imeKorisnika;
	}

	public void setImeKorisnika(String imeKorisnika) {
		this.imeKorisnika = imeKorisnika;
	}

	public int getBrojPosudjenihKnjiga() {
		return brojPosudjenihKnjiga;
	}

	public void setBrojPosudjenihKnjiga(int brojPosudjenihKnjiga) {
		this.brojPosudjenihKnjiga = brojPosudjenihKnjiga;
	}

	public int getBrojRacuna() {
		return brojRacuna;
	}

}
