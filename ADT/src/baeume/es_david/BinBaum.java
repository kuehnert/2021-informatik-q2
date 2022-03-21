package baeume.es_david;

import java.util.ArrayList;
import java.util.List;

public class BinBaum<T> {

    protected Node<T> root;

    public BinBaum(Node<T> root) {
        this.root = root;
    }

    public BinBaum() {
        this(null);
    }

    public int amount() {
        return this.amount(this.root);
    }

    public int amount(Node<T> node) {
        if (node == null) {
            return 0;
        }

        return 1 + this.amount(node.getLeft()) + this.amount(node.getRight());
    }

    public int depth() {
        return this.depth(this.root);
    }

    public int depth(Node<T> node) {
        if (node == null) {
            return 0;
        }

        return 1 + Math.max(this.depth(node.getLeft()), this.depth(node.getRight()));
    }

    public boolean isBalanced() {
        return this.isBalanced(this.root);
    }

    private boolean isBalanced(Node<T> node) {
        if (node == null) {
            return true;
        }

        int leftDepth = this.depth(node.getLeft());
        int rightDepth = this.depth(node.getRight());

        return Math.abs(leftDepth - rightDepth) < 2
                && this.isBalanced(node.getLeft())
                && this.isBalanced(node.getRight());
    }

    public List<T> lnr() {
        List<T> list = new ArrayList<>();
        this.lnr(this.root, list);
        return list;
    }

    private void lnr(Node<T> node, List<T> list) {
        if (node == null) {
            return;
        }

        this.lnr(node.getLeft(), list);
        list.add(node.getValue());
        this.lnr(node.getRight(), list);
    }

    public List<T> rnl() {
        List<T> list = new ArrayList<>();
        this.rnl(this.root, list);
        return list;
    }

    private void rnl(Node<T> node, List<T> list) {
        if (node == null) {
            return;
        }

        this.rnl(node.getRight(), list);
        list.add(node.getValue());
        this.rnl(node.getLeft(), list);
    }

    public Node<T> getRoot() {
        return this.root;
    }

    public static class Node<T> {

        private T value;
        private Node<T> left;
        private Node<T> right;

        public Node(T value) {
            this(value, null, null);
        }

        public Node(T value, Node<T> left, Node<T> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public T getValue() {
            return this.value;
        }

        public Node<T> setValue(T value) {
            this.value = value;
            return this;
        }

        public Node<T> getLeft() {
            return this.left;
        }

        public Node<T> setLeft(Node<T> left) {
            this.left = left;
            return this;
        }

        public Node<T> getRight() {
            return this.right;
        }

        public Node<T> setRight(Node<T> right) {
            this.right = right;
            return this;
        }

        public boolean isLeaf() {
            return this.left == null && this.right == null;
        }
    }
}