import java.util.*;

public class SklepKomputerowy {
    private Produkt[] produkty = new Produkt[100];
    private Klient[] klienci = new Klient[100];
    private Zamowienie[] zamowienia = new Zamowienie[100];
    private int liczbaProduktow = 0, liczbaKlientow = 0, liczbaZamowien = 0;

    public void dodajProdukt(Produkt produkt) {
        produkty[liczbaProduktow++] = produkt;
    }

    public void dodajKlienta(Klient klient) {
        klienci[liczbaKlientow++] = klient;
    }

    public Zamowienie utworzZamowienie(Klient klient, Produkt[] produktyZamowienia, int[] ilosci) {
        Zamowienie zamowienie = new Zamowienie(++liczbaZamowien, klient, produktyZamowienia, ilosci, new Date().toString(), "Nowe");
        if (klient.isCzyStaly()) {
            zastosujZnizke(zamowienie);
        }
        zamowienia[liczbaZamowien - 1] = zamowienie;
        aktualizujStanMagazynowy(zamowienie);
        return zamowienie;
    }

    public void zastosujZnizke(Zamowienie zamowienie) {
        Produkt[] produkty = zamowienie.getProdukty();
        for (Produkt p : produkty) {
            p.setCena(p.getCena() * 0.9);
        }
    }

    public void aktualizujStanMagazynowy(Zamowienie zamowienie) {
        Produkt[] produkty = zamowienie.getProdukty();
        int[] ilosci = zamowienie.getIlosci();
        for (int i = 0; i < produkty.length; i++) {
            int nowaIlosc = produkty[i].getIloscWMagazynie() - ilosci[i];
            produkty[i].setIloscWMagazynie(nowaIlosc);
        }
    }

    public void zmienStatusZamowienia(int idZamowienia, String nowyStatus) {
        for (int i = 0; i < liczbaZamowien; i++) {
            if (zamowienia[i].getId() == idZamowienia) {
                zamowienia[i].setStatus(nowyStatus);
                return;
            }
        }
    }

    public void wyswietlProduktyWKategorii(String kategoria) {
        for (int i = 0; i < liczbaProduktow; i++) {
            if (produkty[i].getKategoria().equalsIgnoreCase(kategoria)) {
                produkty[i].wyswietlInformacje();
            }
        }
    }

    public void wyswietlZamowieniaKlienta(int idKlienta) {
        for (int i = 0; i < liczbaZamowien; i++) {
            if (zamowienia[i].getKlient().getId() == idKlienta) {
                zamowienia[i].wyswietlSzczegoly();
            }
        }
    }
}