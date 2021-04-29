package ohtu.kivipaperisakset;

import ohtu.kivipaperisakset.io.IO;
import ohtu.kivipaperisakset.io.TextIO;

import java.util.Scanner;

public class Peli {
    private static final IO textIO = new TextIO(new Scanner(System.in));
    public static void peliKPS() {
        Peli peli = new Peli();
        peli.suorita();
    }

    private void suorita(){
        KiviPaperiSakset peli = null;

        while (true) {
            textIO.tulosta("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String vastaus = textIO.lueRivi("");
            if (vastaus.endsWith("a")) {
                //KPSPelaajaVsPelaaja kaksinpeli = new KPSPelaajaVsPelaaja();
                peli = KiviPaperiSakset.peliPelaajaaVastaan(textIO);
                pelaa(peli);
            } else if (vastaus.endsWith("b")) {
                // KPSTekoaly yksinpeli = new KPSTekoaly();
                peli = KiviPaperiSakset.peliHelppoAIVastaan(textIO);
                pelaa(peli);
            } else if (vastaus.endsWith("c")) {
                //KPSParempiTekoaly pahaYksinpeli = new KPSParempiTekoaly();
                peli = KiviPaperiSakset.peliHaastavaAIVastaan(textIO);
                pelaa(peli);
            } else {
                break;
            }
        }
    }

    private void pelaa(KiviPaperiSakset peli) {
        textIO.tulosta("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
        peli.pelaa();
    }
}
