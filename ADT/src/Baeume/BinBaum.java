package Baeume;

public class BinBaum {
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

    public void ausgebenNLR() {
        checkRoot();
        ausgebenNLR(root);
    }

    private void ausgebenNLR(Node node) {
        // Gibt Wert vom aktuellen Knoten aus
        System.out.println(node.getData());

        // Gib linken Teilbaum aus
        if (node.getLeft() != null) {
            ausgebenNLR(node.getLeft());
        }

        // Gib rechten Teilbaum aus
        if (node.getRight() != null) {
            ausgebenNLR(node.getRight());
        }
    }
}

class Node {
    private int data;
    private Node left;
    private Node right;

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

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