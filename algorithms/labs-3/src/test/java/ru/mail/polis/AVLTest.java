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
    public void add4NodesAndRotate() throws Exception {
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

    @Test
    public void add4andFind() throws Exception {
        final AVL tree = new AVL();
        tree.add(4);
        tree.add(3);
        tree.add(2);
        tree.add(1);

        for (int i = 1; i <= 4; i++) {
            assertThat(tree.find(i), is(true));
        }
        assertThat(tree.find(0), is(false));
        assertThat(tree.find(5), is(false));
    }

    @Test
    public void deleteOneNodeTree() throws Exception {
        Tree tree = new AVL();
        tree.add(1);
        assertThat(tree.find(1), is(true));
        tree.delete(1);
        assertThat(tree.find(1), is(false));
    }

    @Test
    public void deleteTwoNodeTree() throws Exception {
        String treeString = "2 -1 1 -1 -1";
        AVL.Node root = AVLHelper.deserialize(treeString);
        Tree tree = new AVL(root);

        assertThat(tree.find(2), is(true));
        tree.delete(2);
        assertThat(tree.find(2), is(false));
        assertThat(tree.find(1), is(true));
    }

    @Test
    public void deleteRootInBigTree() throws Exception {
        final String treeString = "10 5 3 -1 -1 7 -1 -1 20 15 12 -1 -1 17 -1 -1 25 -1 -1";
        final AVL.Node root = AVLHelper.deserialize(treeString);
        final AVL tree = new AVL(root);

        tree.delete(10);

        final String expectedTreeString= "12 5 3 -1 -1 7 -1 -1 20 15 -1 17 -1 -1 25 -1 -1 ";
        assertThat(AVLHelper.serialize(tree), is(expectedTreeString));
    }

    @Test
    public void deleteRootLeftChildInBigTree() throws Exception {
        final AVL tree = new AVL();
        for (int i = 2; i <= 10; i++) {
            tree.add(i);
        }

        assertThat(tree.find(7), is(true));
        tree.delete(7);
        assertThat(tree.find(7), is(false));

        assertThat(AVLHelper.serialize(tree), is("5 3 2 -1 -1 4 -1 -1 8 6 -1 -1 9 -1 10 -1 -1 "));
    }

    @Test
    public void add10Delete10() throws Exception {
        final AVL tree = new AVL();
        for (int i = 1; i <= 10; i++) {
            tree.add(i);
        }

        for (int i = 1; i <= 10; i++) {
            assertThat(tree.find(i), is(true));
        }

        for (int i = 1; i <= 10; i++) {
            tree.delete(i);
            assertThat(tree.find(i), is(false));
        }

        assertThat(AVLHelper.serialize(tree), is("-1 "));
    }
}
