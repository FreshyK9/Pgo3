public class Main {
    public static void main(String[] args) {
        // Tworzymy instancję sklepu komputerowego
        SklepKomputerowy sklep = new SklepKomputerowy();

        // Dodajemy produkty
        Produkt produkt1 = new Produkt(1, "Laptop Dell XPS 13", "Laptop", 4999.99, 10);
        Produkt produkt2 = new Produkt(2, "Mysz Logitech MX Master 3", "Mysz", 349.99, 30);
        Produkt produkt3 = new Produkt(3, "Monitor Samsung 27\"", "Monitor", 1299.99, 15);

        sklep.dodajProdukt(produkt1);
        sklep.dodajProdukt(produkt2);
        sklep.dodajProdukt(produkt3);

        // Dodajemy klientów
        Klient klient1 = new Klient(1, "Jan", "Kowalski", "jan.kowalski@example.com", true);
        Klient klient2 = new Klient(2, "Anna", "Nowak", "anna.nowak@example.com", false);

        sklep.dodajKlienta(klient1);
        sklep.dodajKlienta(klient2);

        // Tworzymy zamówienie dla klienta 1
        Produkt[] produktyZamowienia1 = { produkt1, produkt2 };
        int[] ilosciZamowienia1 = { 1, 1 };
        Zamowienie zamowienie1 = sklep.utworzZamowienie(klient1, produktyZamowienia1, ilosciZamowienia1);

        // Wyświetlamy informacje
        System.out.println("Informacje o zamówieniu:");
        zamowienie1.wyswietlSzczegoly();

        System.out.println("\nStan magazynowy po zamówieniu:");
        sklep.wyswietlProduktyWKategorii("Laptop");
        sklep.wyswietlProduktyWKategorii("Mysz");

        // Zmiana statusu zamówienia
        sklep.zmienStatusZamowienia(zamowienie1.getId(), "Zrealizowane");

        System.out.println("\nStatus zamówienia po aktualizacji:");
        zamowienie1.wyswietlSzczegoly();

        // Dodanie kolejnego zamówienia
        Produkt[] produktyZamowienia2 = { produkt3, produkt2 };
        int[] ilosciZamowienia2 = { 2, 1 };
        Zamowienie zamowienie2 = sklep.utworzZamowienie(klient2, produktyZamowienia2, ilosciZamowienia2);

        // Wyświetlanie zamówień klienta
        System.out.println("\nZamówienia klienta Jan Kowalski:");
        sklep.wyswietlZamowieniaKlienta(1);
    }
}
