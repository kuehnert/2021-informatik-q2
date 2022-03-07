package test;

import Baeume.BinBaum;

public class TestBaum {
    public static void main(String[] args) {
        BinBaum baum = new BinBaum();
        System.out.println("Min: " + baum.findMin());
        System.out.println("Max: " + baum.findMax());
        System.out.println(baum.ausgeben(BinBaum.NLR));
        // System.out.println(baum.ausgeben(BinBaum.LNR));
        // System.out.println(baum.ausgeben(BinBaum.RNL));
    }
}
