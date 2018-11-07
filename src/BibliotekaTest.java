import java.io.IOException;
import java.util.ArrayList;
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
		System.out.println("6. Motivaciona poruka");
		System.out.println("7. Izlazak iz aplikacije");

		int izbor = 0;
		try {
			izbor = input.nextInt();

			while (izbor < 1 || izbor > 7) {
				System.out.println("Pogresan unos. Pokusajte ponovo.");
				izbor = input.nextInt();
			}
		} catch (InputMismatchException e) {
			System.out.println("Unesena vrijednost ne odgovara trazenom formatu.");
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
			motivacionaPoruka();
			break;
		case 7:
			Knjiga.izbrisiFile();
			break;
		}

	}

	public static void noviKorisnik() throws IOException, InputMismatchException {

		System.out.println("Unesite broj racuna: ");
		int brojRacuna = input.nextInt();

		System.out.println("Unesite ime i prezime(koristite donju crtu za space): ");
		String ime = input.next();

		Racun.kreirajRacun(brojRacuna, ime);

		bibliotekaTest();
	}

	public static void novaKnjiga() throws IOException, InputMismatchException {

		System.out.println("Unesite broj knjige: ");
		int brojKnjige = input.nextInt();

		System.out.println("Unesite naziv knjige(koristite donju crtu za space): ");
		String naziv = input.next();

		Knjiga.kreirajKnjigu(brojKnjige, naziv);

		bibliotekaTest();

	}

	public static void podizanjeKnjige() throws IOException, InputMismatchException {

		System.out.println("Unesite broj racuna: ");
		int brojRacuna = input.nextInt();

		System.out.println("Unesite broj knjige: ");
		int brojKnjige = input.nextInt();

		Biblioteka.podigniKnjigu(brojRacuna, brojKnjige);

		bibliotekaTest();
	}

	public static void vracanjeKnjige() throws IOException, InputMismatchException {

		System.out.println("Unesite broj racuna: ");
		int brojRacuna = input.nextInt();

		System.out.println("Unesite broj knjige: ");
		int brojKnjige = input.nextInt();

		Biblioteka.vratiKnjigu(brojRacuna, brojKnjige);

		bibliotekaTest();
	}

	
	// metoda motivacionaPoruka() bas i nema veze sa zadatkom, osim sto implementira citanje iz file-a
	// u file pod nazivom Poruke je moguce dodavati motivacione poruke, i onda prilikom pozivanja metode
	// sve poruke se spreme u Array listu, i korisniku se izbacuje jedna random motivaciona poruka :)
	public static void motivacionaPoruka() throws IOException {

		java.io.File poruke = new java.io.File("Poruke.txt");
		
		ArrayList<String> listaPoruka = new ArrayList<>();

		try {
			
			Scanner citac = new Scanner(poruke);

			while (citac.hasNext()) {
				listaPoruka.add(citac.nextLine());
			}
			
			citac.close();
			
			System.out.println(listaPoruka.get((int) (Math.random() * listaPoruka.size())));
			
		} catch (IOException e) {
			
			System.out.println("Motivacioni file vise ne postoji.");
		}

	bibliotekaTest();

}}
