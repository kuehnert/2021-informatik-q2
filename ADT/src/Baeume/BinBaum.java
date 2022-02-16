package Baeume;

public class BinBaum {
    Node root;

    public BinBaum() {
        root = new Node(50);
        root.left = new Node(69);
        root.left.left = new Node(187);
    }
}

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}