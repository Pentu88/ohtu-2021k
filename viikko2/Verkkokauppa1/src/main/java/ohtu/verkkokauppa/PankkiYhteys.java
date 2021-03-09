package ohtu.verkkokauppa;

public interface PankkiYhteys {
    public boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa);
}
