public class Zamowienie {
    private int id;
    private Klient klient;
    private Produkt[] produkty;
    private int[] ilosci;
    private String dataZamowienia;
    private String status;

    public Zamowienie(int id, Klient klient, Produkt[] produkty, int[] ilosci, String dataZamowienia, String status) {
        this.id = id;
        this.klient = klient;
        this.produkty = produkty;
        this.ilosci = ilosci;
        this.dataZamowienia = dataZamowienia;
        this.status = status;
    }

    public int getId() { return id; }
    public Klient getKlient() { return klient; }
    public Produkt[] getProdukty() { return produkty; }
    public int[] getIlosci() { return ilosci; }
    public String getDataZamowienia() { return dataZamowienia; }
    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public double obliczWartoscZamowienia() {
        double suma = 0.0;
        for (int i = 0; i < produkty.length; i++) {
            suma += produkty[i].getCena() * ilosci[i];
        }
        return suma;
    }

    public void wyswietlSzczegoly() {
        System.out.println("Zamówienie ID: " + id + " | Klient: " + klient.getImie() + " " + klient.getNazwisko());
        for (int i = 0; i < produkty.length; i++) {
            System.out.println("- " + produkty[i].getNazwa() + " x" + ilosci[i]);
        }
        System.out.println("Data: " + dataZamowienia + " | Status: " + status);
        System.out.println("Wartość: " + obliczWartoscZamowienia() + " zł");
    }
}