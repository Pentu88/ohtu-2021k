package ohtu.kivipaperisakset;

import ohtu.kivipaperisakset.io.*;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class KiviPaperiSaksetPeli {
    private static final IO textIO = new TextIO(new Scanner(System.in));
    public static void suoritaKPSPeli() {
        KiviPaperiSaksetPeli peli = new KiviPaperiSaksetPeli();
        peli.suorita();
    }

    Map<String, String> peliTyypit;

    public KiviPaperiSaksetPeli() {
        this.peliTyypit = new HashMap<>();
        this.peliTyypit.put("a", "peliPelaajaaVastaan");
        this.peliTyypit.put("b", "peliHelppoAIVastaan");
        this.peliTyypit.put("c", "peliHaastavaAIVastaan");
    }

    private void suorita() {
        String vastaus = kysyKayttajaltaPelityyppi();

        if (this.peliTyypit.containsKey(vastaus)) {
            textIO.tulosta("Vastasit: " + vastaus);
            try {
                Class kps = Class.forName("KiviPaperiSakset");
                // Method peliTehdas = kps.getMethod("peliHaastavaAIVastaan", IO.class);
                // KiviPaperiSakset peli = (KiviPaperiSakset) peliTehdas.invoke(textIO);
                // pelaa(peli);
            } catch (Throwable e) { e.printStackTrace();}
        }
    }

    private void suoritaOld(){
        KiviPaperiSakset peli = null;

        while (true) {
            String vastaus = kysyKayttajaltaPelityyppi();

            if (vastaus.endsWith("a")) {
                //KPSPelaajaVsPelaaja kaksinpeli = new KPSPelaajaVsPelaaja();
                peli = KiviPaperiSakset.peliPelaajaaVastaan(textIO);
            } else if (vastaus.endsWith("b")) {
                // KPSTekoaly yksinpeli = new KPSTekoaly();
                peli = KiviPaperiSakset.peliHelppoAIVastaan(textIO);
            } else if (vastaus.endsWith("c")) {
                //KPSParempiTekoaly pahaYksinpeli = new KPSParempiTekoaly();
                peli = KiviPaperiSakset.peliHaastavaAIVastaan(textIO);
            } else {
                break;
            }
            pelaa(peli);
        }
    }

    private String kysyKayttajaltaPelityyppi() {
        return textIO.lueRivi("\nValitse pelataanko"
                + "\n (a) ihmistä vastaan "
                + "\n (b) tekoälyä vastaan"
                + "\n (c) parannettua tekoälyä vastaan"
                + "\nmuilla valinnoilla lopetataan");
    }

    private void pelaa(KiviPaperiSakset peli) {
        textIO.tulosta("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
        peli.pelaa();
    }
}
