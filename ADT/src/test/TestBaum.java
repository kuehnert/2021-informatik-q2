package test;

import Baeume.BinBaum;

public class TestBaum {
    public static void main(String[] args) {
        BinBaum baum = new BinBaum();
        System.out.println("Min: " + baum.findMin());
        System.out.println("Max: " + baum.findMax());
        System.out.println(baum.ausgeben(BinBaum.NLR));
        System.out.println("Anzahl: " + baum.anzahl());
        System.out.println("Tiefe: " + baum.tiefe());
        // System.out.println(baum.ausgeben(BinBaum.LNR));
        // System.out.println(baum.ausgeben(BinBaum.RNL));

        int zahl = 24;
        baum.add(zahl);
        System.out.println(baum.ausgebenJ(1));
        System.out.println("Anzahl: " + baum.anzahl());
        System.out.println("Tiefe: " + baum.tiefe());

        baum.add(zahl);
        System.out.println(baum.ausgebenJ(1));
        System.out.println("Anzahl: " + baum.anzahl());
        System.out.println("Tiefe: " + baum.tiefe());

        baum.add(zahl);
        System.out.println(baum.ausgebenJ(1));
        System.out.println("Anzahl: " + baum.anzahl());
        System.out.println("Tiefe: " + baum.tiefe());

        baum.add(zahl);
        System.out.println(baum.ausgebenJ(1));
        System.out.println("Anzahl: " + baum.anzahl());
        System.out.println("Tiefe: " + baum.tiefe());

    }
}
