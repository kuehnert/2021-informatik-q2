package baeume.es_olo;

import java.io.Serializable;

public class Baum implements Serializable {
    public static final int NLR = 0;
    public static final int LNR = 1;
    public static final int RNL = 2;

    private Node root;

    public Baum() {
        // top-down
        // root = new Node(23);
        // root.left = new Node(5);
        // root.left.left = new Node(2);
        // root.left.left.left = new Node(1);
        // root.left.left.right = new Node(3);

        // bottom-up

    }


    private void checkRoot() {
        if (root == null) {
            throw new IllegalStateException("Kein Root-Element vorhanden");
        }
    }

    public void addRoot(Node root){ this.root = root; }

    public Node getRoot() { return this.root; }


    public void addLeft(Node root, Node node){

        root.setLeft(node);
        node.setRoot(root);
    }

    public void addRight(Node root, Node node){

        root.setRight(node);
        node.setRoot(root);
    }

    public int zähler() { return root.zähler(); }

    public String ausgeben() {
        return ausgeben(LNR);
    }

/*
    public String ausgeben(int order) {
        checkRoot();
        return switch (order) {
            case NLR -> root.nlr();
            case LNR -> root.lnr();
            case RNL -> root.rnl();
            default -> throw new IllegalStateException("Unexpected value: " + order);
        };
    }

*/

    public String ausgeben(int order) {
        return root.nlr();
    }






}

class Node implements Serializable{
    private String data;
    private Node left;
    private Node right;
    private Node root;

    public int zähler() {
        // Gibt Wert vom aktuellen Knoten aus
        int s = 1;

        // Gib linken Teilbaum aus
        if (left != null) {
            s += 1;
        }

        // Gib rechten Teilbaum aus
        if (right != null) {
            s += 1;
        }

        return s;
    }

    public String nlr() {
        // Gibt Wert vom aktuellen Knoten aus
        String s = getData() + " ";

        // Gib linken Teilbaum aus
        if (left != null) {
            s += left.nlr();
        }

        // Gib rechten Teilbaum aus
        if (right != null) {
            s+= right.nlr();
        }

        return s;
    }

    public String lnr() {
        // Gib linken Teilbaum aus
        if (left != null) {
            left.lnr();
        }

        // Gibt Wert vom aktuellen Knoten aus
        System.out.print(getData() + " ");

        // Gib rechten Teilbaum aus
        if (right != null) {
            right.lnr();
        }

        return "blub";
    }

    public String rnl() {
        // Gib rechten Teilbaum aus
        if (right != null) {
            right.rnl();
        }

        // Gibt Wert vom aktuellen Knoten aus
        System.out.print(getData() + " ");

        // Gib linken Teilbaum aus
        if (left != null) {
            left.rnl();
        }

        return "bla";
    }

    public boolean isLeaf(){

        if(left == null && right == null){
            return true;
        }else{
            return false;
        }
    }


    // Konstruktoren
    public Node(String data) {
        this.data = data;
    }

    public Node(String data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public Node(String data, Node left, Node right, Node root) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.root = root;
    }

    // Getter und Setter
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getRoot() { return root; }

    public void setRoot(Node root) { this.root = root; }
}