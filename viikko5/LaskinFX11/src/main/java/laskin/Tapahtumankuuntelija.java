package laskin;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.HashMap;

public class Tapahtumankuuntelija implements EventHandler {
    private HashMap<Button, Komento> komennot;
    private Komento edellinen = null;

    private Button undo;
    private Sovelluslogiikka sovellus;

    public Tapahtumankuuntelija(TextField tuloskentta, TextField syotekentta, Button plus, Button miinus, Button nollaa, Button undo) {
        this.undo = undo;
        this.sovellus = new Sovelluslogiikka();

        this.komennot = new HashMap<>();
        this.komennot.put(plus, new Summa(tuloskentta, syotekentta, sovellus));
        this.komennot.put(miinus, new Erotus(tuloskentta, syotekentta, sovellus));
        this.komennot.put(nollaa, new Nollaa(tuloskentta, syotekentta, sovellus));

    }

    @Override
    public void handle(Event event) {
        if ( event.getTarget() != undo ) {
            Komento komento = this.komennot.get((Button)event.getTarget());
            komento.suorita();
            this.edellinen = komento;
            undo.disableProperty().set(false);
        } else {
            this.edellinen.peru();
            this.edellinen = null;

            undo.disableProperty().set(true);
        }
    }

}
