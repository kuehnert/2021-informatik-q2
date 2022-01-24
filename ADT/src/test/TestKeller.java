package test;

import stack.Keller;

public class TestKeller {
    public static void main(String[] args) {
        Keller<String> k = new Keller<String>();
        k.push("Foo");
        k.push("Bar");
        k.push("Baz");
        System.out.println(k.size());
        System.out.println(k.pop());
        System.out.println(k.size());
        System.out.println(k.pop());
        System.out.println(k.size());
        System.out.println(k.pop());
        System.out.println(k.size());
        System.out.println(k.pop());
        System.out.println(k.size());
    }
}
