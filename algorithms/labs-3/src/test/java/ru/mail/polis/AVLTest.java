package ru.mail.polis;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AVLTest {
    @Test
    public void emptyTree() throws Exception {
        final Tree avl = new AVL();
        assertThat(avl.find(0), is(false));
    }

    @Test
    public void getHeightNode() throws Exception {
        final AVL.Node node = new AVL.Node(5);
        assertThat(node.getHeight(), is(1));
    }

    @Test
    public void balanceFactorNode() throws Exception {
        final AVL.Node node = new AVL.Node(5);
        assertThat(node.balanceFactor(), is(0));
    }

    @Test
    public void fixHeightNode() throws Exception {
        final AVL.Node node = new AVL.Node(5);
        node.fixHeight();
        assertThat(node.getHeight(), is(1));
    }

    @Test
    public void fixHeightFor2BoundNodes() throws Exception {
        final AVL.Node b = new AVL.Node(2);
        final AVL.Node a = new AVL.Node(1, b, null);
        assertThat(a.getHeight(), is(2));
    }

    @Test
    public void fixHeightFor4BoundNodes() throws Exception {
        final String treeString = "2 1 -1 -1 3 -1 4 -1 -1";
        final AVL.Node root = AVLHelper.deserialize(treeString);

        assertThat(root.getHeight(), is(3));
    }

    @Test
    public void rotateRight() throws Exception {
        // p q a -1 -1 b -1 -1 c -1 -1
        final String treeString = "4 2 1 -1 -1 3 -1 -1 5 -1 -1";
        final AVL.Node tree = AVLHelper.deserialize(treeString);

        final AVL.Node rotatedTree = AVL.rotateRight(tree);

        // q a -1 -1 p b -1 -1 c -1 -1
        final String expectedTreeString = "2 1 -1 -1 4 3 -1 -1 5 -1 -1";
        final AVL.Node expectedTree = AVLHelper.deserialize(expectedTreeString);

        assertThat(rotatedTree, is(expectedTree));
    }

    @Test
    public void rotateLeft() throws Exception {
        // q a -1 -1 p b -1 -1 c -1 -1
        final String treeString = "2 1 -1 -1 4 3 -1 -1 5 -1 -1";
        final AVL.Node tree = AVLHelper.deserialize(treeString);

        final AVL.Node rotatedTree = AVL.rotateLeft(tree);

        // p q a -1 -1 b -1 -1 c -1 -1
        final String expectedTreeString = "4 2 1 -1 -1 3 -1 -1 5 -1 -1";
        final AVL.Node expectedTree = AVLHelper.deserialize(expectedTreeString);

        assertThat(rotatedTree, is(expectedTree));
    }

    @Test
    public void balance() throws Exception {
        // p a -1 -1 q s b -1 -1 c -1 -1 d -1 -1
        final String treeString = "5 2 -1 -1 10 4 3 -1 -1 6 -1 -1 12 -1 -1";
        final AVL.Node tree = AVLHelper.deserialize(treeString);

        final AVL.Node balancedTree = AVL.balance(tree);

        // s p a -1 -1 b -1 -1 q c -1 -1 d -1 -1
        final String expectedTreeString = "4 5 2 -1 -1 3 -1 -1 10 6 -1 -1 12 -1 -1";
        final AVL.Node expectedTree = AVLHelper.deserialize(expectedTreeString);

        assertThat(balancedTree, is(expectedTree));
    }

    @Test
    public void addOne() throws Exception {
        final Tree avl = new AVL();
        final boolean wasAdded = avl.add(5);

        assertThat(wasAdded, is(true));
    }

    @Test
    public void addTwo() throws Exception {
        final Tree avl = new AVL();
        boolean wasAdded = avl.add(5);
        wasAdded &= avl.add(3);

        assertThat(wasAdded, is(true));
    }

    @Test
    public void add3AndRotate() throws Exception {
        final AVL tree = new AVL();
        boolean wasAdded = tree.add(3);
        wasAdded &= tree.add(2);
        wasAdded &= tree.add(1);

        assertThat(wasAdded, is(true));

        final String treeString = AVLHelper.serialize(tree);
        final String expectedTree = "2 1 -1 -1 3 -1 -1 ";
        assertThat(treeString, is(expectedTree));
    }

    @Test
    public void add5NodesAndRotate() throws Exception {
        final AVL tree = new AVL();
        boolean wasAdded = tree.add(4);
        wasAdded &= tree.add(3);
        wasAdded &= tree.add(2);
        wasAdded &= tree.add(1);

        assertThat(wasAdded, is(true));

        final String treeString = AVLHelper.serialize(tree);
        final String expectedTree = "3 2 1 -1 -1 -1 4 -1 -1 ";
        assertThat(treeString, is(expectedTree));
    }
}
