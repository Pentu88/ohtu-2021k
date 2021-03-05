package ohtu.verkkokauppa;

import java.util.*;

/**
 *
 * @author pentu
 */
public interface KirjanpitoYhteys {
    ArrayList<String> getTapahtumat();
    void lisaaTapahtuma(String tapahtuma);
}
