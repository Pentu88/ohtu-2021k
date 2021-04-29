package ohtu.kivipaperisakset;

import ohtu.kivipaperisakset.io.IO;
import ohtu.kivipaperisakset.pelaajat.Pelaava;

public class PeliTietokonettaVastaan extends KiviPaperiSakset{
    protected PeliTietokonettaVastaan(IO io, Pelaava pelaaja1, Pelaava pelaaja2) {
        super(io, pelaaja1, pelaaja2);
    }

    @Override
    protected String vastustajanSiirto(Pelaava p) {
        String siirto = p.suoritaSiirto();
        super.textIO.tulosta("Tietokone valitsi: " + siirto);
        return siirto;
    }
}
