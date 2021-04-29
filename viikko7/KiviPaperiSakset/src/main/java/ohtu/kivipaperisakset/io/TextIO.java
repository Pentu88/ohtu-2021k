package ohtu.kivipaperisakset.io;

import java.util.Scanner;

public class TextIO implements IO{
    private Scanner lukija;

    public TextIO(Scanner scanner) {
        this.lukija = scanner;
    }

    @Override
    public void tulosta(String viesti) {
        System.out.println(viesti);
    }

    @Override
    public String lueRivi(String viesti) {
        if (viesti.length() > 0) {
            this.tulosta(viesti);
        }
        return lukija.nextLine().trim();
    }
    
    @Override
    public void virhe(String msg) {
        this.tulosta("VIRHE: " + msg);
    }
}
