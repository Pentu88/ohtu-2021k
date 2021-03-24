
package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int OLETUS_KAPASITEETTI = 5,
                            OLETUSKASVATUS = 5;
    private int kasvatusAskel;
    private int[] lukuJono;
    private int alkioidenMaara;

    private void alustaLukuJono(int kapasiteetti){
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasiteetti ei voi olla negatiivinen!");
        }

        lukuJono = new int[kapasiteetti];

        // asetetaan jokaiseen paikkaan 0
        for (int i = 0; i < lukuJono.length; i++) {
            lukuJono[i] = 0;
        }

        alkioidenMaara = 0;
    }

    private void alustaKasvatusAskel(int kasvatusAskel){
        if (kasvatusAskel < 0) {
            throw new IndexOutOfBoundsException("Taulukon kokoa ei voi kasvattaa negatiivisella luvulla!");
        }

        this.kasvatusAskel = kasvatusAskel;
    }

    public IntJoukko() {
        alustaLukuJono(OLETUS_KAPASITEETTI);
        alustaKasvatusAskel(OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        alustaLukuJono(kapasiteetti);
        alustaKasvatusAskel(OLETUSKASVATUS);
    }
    
    
    public IntJoukko(int kapasiteetti, int kasvatusAskel) {
        alustaLukuJono(kapasiteetti);
        alustaKasvatusAskel(kasvatusAskel);
    }

    public boolean lisaa(int luku) {

        int eiOle = 0;
        if (alkioidenMaara == 0) {
            lukuJono[0] = luku;
            alkioidenMaara++;
            return true;
        } else {
        }
        if (!kuuluuJoukkoon(luku)) {
            lukuJono[alkioidenMaara] = luku;
            alkioidenMaara++;
            if (alkioidenMaara % lukuJono.length == 0) {
                int[] taulukkoOld = new int[lukuJono.length];
                taulukkoOld = lukuJono;
                kopioiTaulukko(lukuJono, taulukkoOld);
                lukuJono = new int[alkioidenMaara + kasvatusAskel];
                kopioiTaulukko(taulukkoOld, lukuJono);
            }
            return true;
        }
        return false;
    }

    public boolean kuuluuJoukkoon(int luku) {
        for (int i = 0; i < alkioidenMaara; i++) {
            if (luku == lukuJono[i]) {
                return true;
            }
        }

        return false;
    }

    public boolean poista(int luku) {
        int kohta = -1;
        int apu;
        for (int i = 0; i < alkioidenMaara; i++) {
            if (luku == lukuJono[i]) {
                kohta = i; //siis luku löytyy tuosta kohdasta :D
                lukuJono[kohta] = 0;
                break;
            }
        }
        if (kohta != -1) {
            for (int j = kohta; j < alkioidenMaara - 1; j++) {
                apu = lukuJono[j];
                lukuJono[j] = lukuJono[j + 1];
                lukuJono[j + 1] = apu;
            }
            alkioidenMaara--;
            return true;
        }


        return false;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }
    }

    public int koko() {
        return alkioidenMaara;
    }


    @Override
    public String toString() {
        String tuotos = "{";

        for (int i = 0; i < alkioidenMaara; i++) {
            tuotos += (i  !=  alkioidenMaara - 1) ? lukuJono[i] + ", " : lukuJono[i];
        }

        tuotos += "}";
        return tuotos;
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenMaara];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = lukuJono[i];
        }
        return taulu;
    }
   

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko palautettavaJoukko = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();

        for (int i = 0; i < aTaulu.length; i++) {
            palautettavaJoukko.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            palautettavaJoukko.lisaa(bTaulu[i]);
        }

        return palautettavaJoukko;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko palautettavaJoukko = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();

        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    palautettavaJoukko.lisaa(bTaulu[j]);
                }
            }
        }
        return palautettavaJoukko;

    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko palautettavaJoukko = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();

        for (int i = 0; i < aTaulu.length; i++) {
            palautettavaJoukko.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            palautettavaJoukko.poista(bTaulu[i]);
        }
 
        return palautettavaJoukko;
    }
        
}
