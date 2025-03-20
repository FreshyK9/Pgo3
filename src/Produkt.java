public class Produkt {

    public int id;
    public String nazwa;
    public String kategoria;
    public double cena;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getIloscWMagazynie() {
        return iloscWMagazynie;
    }

    public void setIloscWMagazynie(int iloscWMagazynie) {
        this.iloscWMagazynie = iloscWMagazynie;
    }

    public int iloscWMagazynie;

    public void wyswietlInformacje() {

        System.out.println("id: ", id, " Nazwa: ", nazwa);
    }
}
