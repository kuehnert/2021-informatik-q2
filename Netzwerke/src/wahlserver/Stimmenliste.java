package wahlserver;

import java.util.ArrayList;
import java.util.List;

public class Stimmenliste {
    private List<Stimme> stimmen = new ArrayList<>();

    public boolean stimmeAbgeben(int id, int stufe, int wahl1, int wahl2) {
        // TODO: ist id gültig?

        // ist stufe ungültig?
        if (stufe < 5 || stufe > 12) {
            return false;
        }

        // ist wahl1 gültig?
        if (wahl1 < 0 || wahl1 >= Parteiliste.PARTEIEN.length ) {
            return false;
        }

        // TODO: ist wahl2 gültig?

        // stimme ist OK, füge sie liste hinzu
        Stimme neueStimme = new Stimme(id, stufe, wahl1, wahl2);
        stimmen.add(neueStimme);
        // TODO entferne ID aus Liste
        return true;
    }

    public int[] holeWahlergebnis() {
        // TODO: Ergebnis hübscher aufbereiten
        int[] stimmzahlen = new int[Parteiliste.PARTEIEN.length];

        for (Stimme stimme : stimmen) {
            stimmzahlen[stimme.getWahl1()] += 1;
        }

        return stimmzahlen;
    }
}
