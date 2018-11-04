import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BibliotekaTest {
	
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		
		Knjiga.kreirajFile();
		
		bibliotekaTest();
	}
	
	public static void bibliotekaTest() throws IOException {
		
		System.out.println("Dobrodosli u Biblioteku, izaberite jednu od opcija:");
		System.out.println("1. Novi korisnik - kreiranje racuna ");
		System.out.println("2. Nova knjiga - dodavanje u bazu ");
		System.out.println("3. Podizanje knjige - postojeci korisnik ");
		System.out.println("4. Vracanje knjige - postojeci korisnik ");
		System.out.println("5. Ispis liste posudjenih i vracenih knjiga");
		System.out.println("6. Izlazak iz aplikacije");
		
		int izbor = 0;
		try {
		izbor = input.nextInt();
		
		while (izbor < 1 || izbor >6 ){
			System.out.println("Pogresan unos. Pokusajte ponovo.");
			izbor = input.nextInt();
		}
		}
		catch (InputMismatchException e) {
			System.out.println("Potrebno unijeti cjelobrojnu numerièku vrijednost.");
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
			Knjiga.izbrisiFile();
			break;
		}
		
	
	}
	
	public static void noviKorisnik() throws IOException {
		
		System.out.println("Unesite broj racuna: ");
		int brojRacuna = input.nextInt();
		
		System.out.println("Unesite ime i prezime(koristite donju crtu za space): ");
		String ime = input.next();
		
		KreirajRacun racun = new KreirajRacun();
		racun.kreirajRacun(brojRacuna, ime);
		
		bibliotekaTest();
	}
	
	public static void novaKnjiga() throws IOException {
		
		System.out.println("Unesite broj knjige: ");
		int brojKnjige = input.nextInt();
		
		System.out.println("Unesite naziv knjige(koristite donju crtu za space): ");
		String naziv = input.next();
		
		
		KreirajKnjigu knjiga = new KreirajKnjigu();
		knjiga.kreirajKnjigu(brojKnjige, naziv);
		
		bibliotekaTest();
		
		
	}
	
	public static void podizanjeKnjige() throws IOException {
		
		System.out.println("Unesite broj racuna: ");
		int brojRacuna = input.nextInt();
		
		System.out.println("Unesite broj knjige: ");
		int brojKnjige = input.nextInt();
		
		Biblioteka.podigniKnjigu(brojRacuna, brojKnjige);
		
		bibliotekaTest();
	}

	
	public static void vracanjeKnjige() throws IOException {
		
		System.out.println("Unesite broj racuna: ");
		int brojRacuna = input.nextInt();
		
		System.out.println("Unesite broj knjige: ");
		int brojKnjige = input.nextInt();
		
		Biblioteka.vratiKnjigu(brojRacuna, brojKnjige);
		
		bibliotekaTest();
	}
}
