package wahlserver;

import java.util.Arrays;

public class TestStimmenliste {
    public static void main(String[] args) {
        Stimmenliste liste = new Stimmenliste();

        boolean erfolg = liste.stimmeAbgeben(1, 12, 0, 1);
        System.out.println("Erfolg? " + erfolg);

         erfolg = liste.stimmeAbgeben(1, 12, 1, 1);
        System.out.println("Erfolg? " + erfolg);
         erfolg = liste.stimmeAbgeben(1, 12, 1, 1);
        System.out.println("Erfolg? " + erfolg);
         erfolg = liste.stimmeAbgeben(1, 12, 4, 1);
        System.out.println("Erfolg? " + erfolg);
         erfolg = liste.stimmeAbgeben(1, 12, 3, 1);
        System.out.println("Erfolg? " + erfolg);
         erfolg = liste.stimmeAbgeben(1, 12, 3, 1);
        System.out.println("Erfolg? " + erfolg);



        erfolg = liste.stimmeAbgeben(1, 13, 0, 1);
        System.out.println("Erfolg? " + erfolg);

        erfolg = liste.stimmeAbgeben(1, 5, 100, 1);
        System.out.println("Erfolg? " + erfolg);

        int[] ergebnis = liste.holeWahlergebnis();
        System.out.println(Arrays.toString(ergebnis));
    }
}
