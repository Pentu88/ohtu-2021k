package ohtu.kivipaperisakset;

import ohtu.kivipaperisakset.io.IO;
import ohtu.kivipaperisakset.pelaajat.*;

public class PeliPelaajaaVastaan extends KiviPaperiSakset{
    protected PeliPelaajaaVastaan(IO io, Pelaava pelaaja1, Pelaava pelaaja2) {
        super(io, pelaaja1, pelaaja2);
    }

    @Override
    protected String vastustajanSiirto(Pelaava p) {
        super.textIO.tulosta("Toisen pelaajan siirto: ");
        return p.suoritaSiirto();
    }
}
