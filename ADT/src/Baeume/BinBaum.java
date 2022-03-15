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
        // Node n2 = new Node(2, new Node(1), new Node(3));
        // Node n20 = new Node(20, new Node(10), new Node(21, null, new Node(22)));
        // Node n5 = new Node(5, n2, n20);
        //
        // Node n30 = new Node(30, new Node(25), new Node(47));
        // Node n50 = new Node(50, n30, new Node(55));
        // root = new Node(23, n5, n50);
        root = null;
    }

    public BinBaum(int... zahlen) {
        addAll(zahlen);
    }

    public void addAll(int[] zahlen) {
        for (int i = 0; i < zahlen.length; i++) {
            add(zahlen[i]);
        }
    }

    public void add(int zahl) {
        Node newNode = new Node(zahl);

        if (root == null) {
            root = newNode;
        } else {
            Node runner = root;
            while (true) {
                // if (zahl == runner.getData()) {
                //     throw new IllegalArgumentException("Zahl "+zahl+" gibt es schon.");
                // }

                if (zahl < runner.getData()) {
                    // muss nach links
                    if (runner.getLeft() == null) {
                        runner.setLeft(newNode);
                        break;
                    } else {
                        runner = runner.getLeft();
                    }
                } else {
                    // muss nach rechts
                    if (runner.getRight() == null) {
                        runner.setRight(newNode);
                        break;
                    } else {
                        runner = runner.getRight();
                    }
                }
            }
        }
    }

    public int findMin() {
        checkRoot();
        Node runner = root;

        // gehe immer weiter nach links, bis ...
        while (runner.getLeft() != null) {
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

        while (runner.getRight() != null) {
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

    public String ausgebenJ(int order) {
        checkRoot();
        StringBuilder sb = new StringBuilder();
        root.lnrJ(sb);
        return sb.toString();
    }

    public int anzahl() {
        checkRoot();
        return root.anzahl();
    }

    public int tiefe() {
        checkRoot();
        return root.tiefe();
    }

    public boolean istAusgeglichen() {
        checkRoot();
        int tiefeL = root.getLeft() == null ? 0 : root.getLeft().tiefe();
        int tiefeR = root.getRight() == null ? 0 : root.getRight().tiefe();
        return Math.abs(tiefeL - tiefeR) <= 1;
    }

    public boolean istVollstaendig() {
        checkRoot();
        return root.istVollstaendig();
    }
}

class Node {
    private int data;
    private Node left;
    private Node right;

    // Konstruktoren
    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public int tiefe() {
        int tiefeL = left == null ? 0 : 1 + left.tiefe();
        int tiefeR = right == null ? 0 : 1 + right.tiefe();

        return Math.max(tiefeL, tiefeR);
    }

    public int anzahl() {
        int anzahl = 1;

        if (left != null) {
            anzahl += left.anzahl();
        }

        if (right != null) {
            anzahl += right.anzahl();
        }

        return anzahl;
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
            s += right.nlr();
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

    public void lnrJ(StringBuilder sb) {
        // Gib linken Teilbaum aus

        if (left != null) {
            left.lnrJ(sb);
        }

        // Gibt Wert vom aktuellen Knoten aus
        sb.append(getData()).append(" ");

        // Gib rechten Teilbaum aus
        if (right != null) {
            right.lnrJ(sb);
        }
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

    public boolean istVollstaendig() {
        if (left == null && right != null || left != null && right == null) {
            return false;
        } else {
            boolean vollstaendigL = left == null ? true : left.istVollstaendig();
            boolean vollstaendigR = right == null ? true : right.istVollstaendig();
            return vollstaendigL && vollstaendigR;
        }
    }
}