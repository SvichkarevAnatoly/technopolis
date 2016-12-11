package ru.mail.polis.tree.avl;

import ru.mail.polis.tree.Tree;

import java.util.Objects;

// https://habrahabr.ru/post/150732/
public class AVL implements Tree {
    private Node root;

    public AVL() {
    }

    public AVL(Node root) {
        this.root = root;
    }

    @Override
    public boolean add(int key) {
        if (root == null) {
            root = new Node(key);
            return true;
        }
        boolean isInserted = insert(root, key);
        root = balance(root);
        return isInserted;
    }

    @Override
    public void delete(int key) {
        root = remove(root, key);
    }

    @Override
    public boolean find(int key) {
        Node cur = this.root;
        while (cur != null) {
            if (key == cur.key) {
                return true;
            } else if (key < cur.key) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return false;
    }

    Node findMin(Node p) {
        if (p.left != null) {
            return findMin(p.left);
        }
        return p;
    }

    Node removeMin(Node p) {
        if (p.left == null) {
            return p.right;
        }
        p.left = removeMin(p.left);
        return balance(p);
    }

    Node remove(Node p, int key) {
        if (p == null) {
            return null;
        }

        if (key < p.getKey()) {
            p.left = remove(p.left, key);
        } else if (key > p.getKey()) {
            p.right = remove(p.right, key);
        } else {
            Node q = p.left;
            Node r = p.right;
            if (r == null) {
                return q;
            }
            Node min = findMin(r);
            min.right = removeMin(r);
            min.left = q;
            return balance(min);
        }
        return balance(p);
    }

    private boolean insert(Node node, int key) {
        boolean isInserted;
        if (key == node.key) {
            return false;
        } else if (key < node.key) {
            if (node.left != null) {
                isInserted = insert(node.left, key);
                node.left = balance(node.left);
            } else {
                node.left = new Node(key);
                return true;
            }
        } else {
            if (node.right != null) {
                isInserted = insert(node.right, key);
                node.right = balance(node.right);
            } else {
                node.right = new Node(key);
                return true;
            }
        }
        return isInserted;
    }

    static Node balance(Node p) {
        p.fixHeight();
        if (p.balanceFactor() == 2) {
            if (p.right.balanceFactor() < 0) {
                p.right = rotateRight(p.right);
            }
            return rotateLeft(p);
        }
        if (p.balanceFactor() == -2) {
            if (p.left.balanceFactor() > 0) {
                p.left = rotateLeft(p.left);
            }
            return rotateRight(p);
        }
        return p;
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

    public Node getRoot() {
        return root;
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
