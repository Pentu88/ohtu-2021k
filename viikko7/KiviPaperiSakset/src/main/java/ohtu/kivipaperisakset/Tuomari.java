package ohtu.kivipaperisakset;

public class Tuomari {
    private int pelaaja1Pisteet;
    private int pelaaja2Pisteet;
    private int tasapelit;

    public Tuomari() {
        this.pelaaja1Pisteet = 0;
        this.pelaaja2Pisteet = 0;
        this.tasapelit = 0;
    }

    public void kirjaaSiirto(String pelaaja1Siirto, String pelaaja2Siirto) {
        if (tasapeli(pelaaja1Siirto, pelaaja2Siirto)) {
            tasapelit++;
        } else if (ekaVoittaa(pelaaja1Siirto, pelaaja2Siirto)) {
            pelaaja1Pisteet++;
        } else {
            pelaaja2Pisteet++;
        }
    }

    private static boolean tasapeli(String eka, String toka) {
        return eka.equals(toka);
    }

    private static boolean ekaVoittaa(String eka, String toka) {
        if ("k".equals(eka) && "s".equals(toka)) {
            return true;
        } else if ("s".equals(eka) && "p".equals(toka)) {
            return true;
        } else if ("p".equals(eka) && "k".equals(toka)) {
            return true;
        }

        return false;
    }

    public String toString() {
        return "Pelitilanne: " + pelaaja1Pisteet + " - " + pelaaja2Pisteet + "\n"
                + "Tasapelit: " + tasapelit;
    }
}