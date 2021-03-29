package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Erotus extends Komento{
    Erotus(TextField tuloskentta, TextField syotekentta, Sovelluslogiikka sovellus){
        super(tuloskentta, syotekentta, sovellus);
    }

    @Override
    public void suorita() {
        memArvo();
        sovellus.miinus(getArvo());
        setArvo();
    }
}
