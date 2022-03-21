package test;

import baeume.es_eric.BinBaum;

public class TestBaum {
    private static void testTree(BinBaum baum) {
        System.out.println(baum.ausgebenJ(1));
        System.out.println("Min: " + baum.findMin());
        System.out.println("Max: " + baum.findMax());
        System.out.println("Anzahl: " + baum.anzahl());
        System.out.println("Tiefe: " + baum.tiefe());
        System.out.println("istAusgeglichen: " + baum.istAusgeglichen());
        System.out.println("istVollstaendig: " + baum.istVollstaendig());
        System.out.println("------------------------------------------------------");
    }

    public static void main(String[] args) {
        BinBaum baum;
        baum = new BinBaum(16);
        testTree(baum);

        baum = new BinBaum(16, 8, 24);
        testTree(baum);

        baum = new BinBaum(16, 8, 24, 4, 12, 20);
        testTree(baum);

        baum = new BinBaum(16, 8, 24, 4, 12, 20, 28);
        testTree(baum);

        baum = new BinBaum(1, 2, 3, 4, 5, 6, 7);
        testTree(baum);

        baum = new BinBaum(23, 5, 50, 30, 20, 25, 10, 17, 2, 47);
        testTree(baum);
    }
}
