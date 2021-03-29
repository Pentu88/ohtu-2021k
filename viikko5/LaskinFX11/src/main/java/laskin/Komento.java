package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public abstract class Komento {
    protected TextField tuloskentta;
    protected TextField syotekentta;
    protected Sovelluslogiikka sovellus;

    protected int edellinen;

    Komento(TextField tuloskentta, TextField syotekentta, Sovelluslogiikka sovellus){
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.sovellus = sovellus;
    }

    protected int getArvo() {
        int arvo = 0;

        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }

        return arvo;
    }

    protected void setArvo() {
        int laskunTulos = sovellus.tulos();

        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);
    }

    protected void memArvo() {
        this.edellinen = Integer.parseInt(tuloskentta.getText());
    }

    public void peru() {
        tuloskentta.setText("" + this.edellinen);
    }

    public abstract void suorita();
}
