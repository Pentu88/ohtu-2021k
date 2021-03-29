package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Summa extends Komento{
    Summa(TextField tuloskentta, TextField syotekentta, Sovelluslogiikka sovellus){
        super(tuloskentta, syotekentta, sovellus);
    }

    @Override
    public void suorita() {
        memArvo();
        sovellus.plus(getArvo());
        setArvo();
    }
}
