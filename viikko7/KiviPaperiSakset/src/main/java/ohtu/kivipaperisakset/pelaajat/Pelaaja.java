package ohtu.kivipaperisakset.pelaajat;

import ohtu.kivipaperisakset.io.IO;

public class Pelaaja implements Pelaava{
    IO io;
    String nimi;

    public Pelaaja(IO io, String nimi) {
        this.io = io;
        this.nimi = nimi;
    }

    @Override
    public String suoritaSiirto() {
        return io.lueRivi("");
    }

    @Override
    public void vastustajanSiirto(String siirto) { } // ei tehdä mitään
}
