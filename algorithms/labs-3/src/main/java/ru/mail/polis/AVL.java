package ru.mail.polis;

import java.util.Objects;

// https://habrahabr.ru/post/150732/
public class AVL implements Tree {
    private Node root;

    public AVL() {
    }

    @Override
    public boolean add(int key) {
        return false;
    }

    @Override
    public void delete(int key) {

    }

    @Override
    public boolean find(int key) {
        return false;
    }

    Node getRoot() {
        return root;
    }

    static Node rotateRight(Node p) {
        final Node q = p.left;
        p.left = q.right;
        q.right = p;
        p.fixHeight();
        q.fixHeight();
        return q;
    }

    static Node rotateLeft(Node q) {
        final Node p = q.right;
        q.right = p.left;
        p.left = q;
        q.fixHeight();
        p.fixHeight();
        return p;
    }

    static class Node {
        private int key;
        private int height;
        private Node left, right;

        Node(int key) {
            this.key = key;
            height = 1;
        }

        Node(int key, Node left, Node right) {
            this.key = key;
            this.left = left;
            this.right = right;
            fixHeight();
        }

        int getKey() {
            return key;
        }

        Node getLeft() {
            return left;
        }

        Node getRight() {
            return right;
        }

        int getHeight() {
            return height;
        }

        int balanceFactor() {
            final int hl = left != null? left.getHeight() : 0;
            final int hr = right != null? right.getHeight() : 0;
            return hr - hl;
        }

        void fixHeight() {
            final int hl = left != null? left.getHeight() : 0;
            final int hr = right != null? right.getHeight() : 0;
            height = Math.max(hl, hr) + 1;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return key == node.key &&
                    height == node.height &&
                    Objects.equals(left, node.left) &&
                    Objects.equals(right, node.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, height, left, right);
        }
    }
}
