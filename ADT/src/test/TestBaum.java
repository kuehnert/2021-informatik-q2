package test;

import Baeume.BinBaum;

public class TestBaum {
    public static void main(String[] args) {
        BinBaum baum = new BinBaum();
        System.out.println("Min: " + baum.findMin());
        System.out.println("Max: " + baum.findMax());
        baum.ausgeben();
    }
}
