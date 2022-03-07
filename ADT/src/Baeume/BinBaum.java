package Baeume;

public class BinBaum {
    public static final int NLR = 0;
    public static final int LNR = 1;
    public static final int RNL = 2;

    private Node root;

    public BinBaum() {
        // top-down
        // root = new Node(23);
        // root.left = new Node(5);
        // root.left.left = new Node(2);
        // root.left.left.left = new Node(1);
        // root.left.left.right = new Node(3);

        // bottom-up
        Node n2 = new Node(2, new Node(1), new Node(3));
        Node n20 = new Node(20, new Node(10), new Node(21));
        Node n5 = new Node(5, n2, n20);

        Node n30 = new Node(30, new Node(25), new Node(47));
        Node n50 = new Node(50, n30, null);

        root = new Node(23, n5, n50);
    }

    public int findMin() {
        checkRoot();
        Node runner = root;

        // gehe immer weiter nach links, bis ...
        while (runner.getLeft() != null){
            runner = runner.getLeft();
        }

        return runner.getData();
    }

    private void checkRoot() {
        if (root == null) {
            throw new IllegalStateException("Kein Root-Element vorhanden");
        }
    }

    public int findMax() {
        checkRoot();
        Node runner = root;

        while (runner.getRight() != null){
            runner = runner.getRight();
        }

        return runner.getData();
    }

    public String ausgeben() {
        return ausgeben(LNR);
    }

    public String ausgeben(int order) {
        checkRoot();
        return switch (order) {
            case NLR -> root.nlr();
            case LNR -> root.lnr();
            case RNL -> root.rnl();
            default -> throw new IllegalStateException("Unexpected value: " + order);
        };
    }
}

class Node {
    private int data;
    private Node left;
    private Node right;

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

    // Konstruktoren
    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    // Getter und Setter
    public int getData() {
        return data;
    }

    public void setData(int data) {
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
}