package ohtu.kivipaperisakset;

import ohtu.kivipaperisakset.io.*;
import ohtu.kivipaperisakset.pelaajat.*;

public abstract class KiviPaperiSakset {
    protected IO textIO;
    protected Pelaava pelaaja1;
    protected Pelaava pelaaja2;

    public static KiviPaperiSakset peliPelaajaaVastaan(IO io) {
            return new PeliPelaajaaVastaan(io, new Pelaaja(io, "1"), new Pelaaja(io, "2"));
    }

    public static KiviPaperiSakset peliHelppoAIVastaan(IO io) {
        return new PeliTietokonettaVastaan(io, new Pelaaja(io, "1"), new Tekoaly());
    }

    public static KiviPaperiSakset peliHaastavaAIVastaan(IO io) {
        return new PeliTietokonettaVastaan(io, new Pelaaja(io, "1"), new TekoalyHaastava(20));
    }

    protected KiviPaperiSakset(IO textIO, Pelaava pelaaja1, Pelaava pelaaja2) {
        this.textIO = textIO;
        this.pelaaja1 = pelaaja1;
        this.pelaaja2 = pelaaja2;
    }

    public void pelaa() {
        Tuomari tuomari = new Tuomari();

        while (true) {
            this.textIO.tulosta("Ensimmäisen pelaajan siirto: ");
            String pelaaja1siirto = this.pelaaja1.suoritaSiirto();

            String pelaaja2siirto = vastustajanSiirto(this.pelaaja2);

            if (!onkoSiirtoValidi(pelaaja1siirto ) || !onkoSiirtoValidi(pelaaja2siirto)) {
                break;
            }

            tuomari.kirjaaSiirto(pelaaja1siirto, pelaaja2siirto);
            this.textIO.tulosta(tuomari + "\n");

            this.pelaaja1.vastustajanSiirto(pelaaja2siirto);
            this.pelaaja2.vastustajanSiirto(pelaaja1siirto);
        }

        this.textIO.tulosta("\nKiitos!\n" + tuomari);
    }

    abstract protected String vastustajanSiirto(Pelaava p);

    protected static boolean onkoSiirtoValidi(String siirto) {
        return siirto.equals("k") || siirto.equals("p") ||siirto.equals("s");
    }
}
