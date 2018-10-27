import java.util.Scanner;

public class BibliotekaTest {
	
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		
		bibliotekaTest();
	}
	
	public static void bibliotekaTest() {
		
		System.out.println("Dobrodosli u Biblioteku, izaberite jednu od opcija:");
		System.out.println("1. Novi korisnik - kreiranje racuna ");
		System.out.println("2. Nova knjiga - dodavanje u bazu ");
		System.out.println("3. Podizanje knjige - postojeci korisnik ");
		System.out.println("4. Vracanje knjige - postojeci korisnik ");
		System.out.println("5. Ispis liste posudjenih i vracenih knjiga");
		System.out.println("6. Izlazak iz aplikacije");
		
		int izbor = input.nextInt();
		
		while (izbor < 1 || izbor >6 ){
			System.out.println("Pogresan unos. Pokusajte ponovo.");
			izbor = input.nextInt();
		}

		switch (izbor) {
		case 1:
			noviKorisnik();
			break;
		case 2:
			novaKnjiga();
			break;
		case 3:
			podizanjeKnjige();
			break;
		case 4:
			vracanjeKnjige();
			break;
		case 5:
			Biblioteka.ispisiListe();
			break;
		case 6:
			break;
			
		}
		

	}
	
	public static void noviKorisnik() {
		
		System.out.println("Unesite broj racuna: ");
		int brojRacuna = input.nextInt();
		
		System.out.println("Unesite ime i prezime(koristite donju crtu za space): ");
		String ime = input.next();
		
		KreirajRacun racun = new KreirajRacun();
		racun.kreirajRacun(brojRacuna, ime);
		
		bibliotekaTest();
	}
	
	public static void novaKnjiga() {
		
		System.out.println("Unesite broj knjige: ");
		int brojKnjige = input.nextInt();
		
		System.out.println("Unesite naziv knjige(koristite donju crtu za space): ");
		String naziv = input.next();
		
		
		KreirajKnjigu knjiga = new KreirajKnjigu();
		knjiga.kreirajKnjigu(brojKnjige, naziv);
		
		bibliotekaTest();
		
		
	}
	
	public static void podizanjeKnjige() {
		
		System.out.println("Unesite broj racuna: ");
		int brojRacuna = input.nextInt();
		
		System.out.println("Unesite broj knjige: ");
		int brojKnjige = input.nextInt();
		
		Biblioteka.podigniKnjigu(brojRacuna, brojKnjige);
		
		bibliotekaTest();
	}

	
	public static void vracanjeKnjige() {
		
		System.out.println("Unesite broj racuna: ");
		int brojRacuna = input.nextInt();
		
		System.out.println("Unesite broj knjige: ");
		int brojKnjige = input.nextInt();
		
		Biblioteka.vratiKnjigu(brojRacuna, brojKnjige);
		
		bibliotekaTest();
	}
}
