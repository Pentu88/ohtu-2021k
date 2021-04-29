package ohtu.kivipaperisakset.pelaajat;

public class Tekoaly implements Pelaava{
    private String[] siirrot;
    private int siirtoLaskuri;

    public Tekoaly() {
        this.siirrot = new String[]{"k", "p", "s"};
        siirtoLaskuri = 0;
    }

    @Override
    public String suoritaSiirto() {
        siirtoLaskuri++;
        return siirrot[siirtoLaskuri % 3];
    }

    @Override
    public void vastustajanSiirto(String siirto) { } // ei tehdä mitään
}
