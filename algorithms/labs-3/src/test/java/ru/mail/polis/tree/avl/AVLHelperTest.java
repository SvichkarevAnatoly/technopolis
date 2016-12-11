package ru.mail.polis.tree.avl;

import org.junit.Test;
import ru.mail.polis.tree.avl.AVL;
import ru.mail.polis.tree.avl.AVLHelper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AVLHelperTest {
    @Test
    public void serializeOneNode() throws Exception {
        final AVL.Node node = new AVL.Node(5);
        final String serialize = AVLHelper.serialize(node);

        assertThat(serialize, is("5 -1 -1"));
    }

    @Test
    public void deserializeOneNode() throws Exception {
        final String tree = "5 -1 -1 ";
        final AVL.Node root = AVLHelper.deserialize(tree);
        assertThat(root, is(new AVL.Node(5)));
    }

    /* Input:
     *      12
     *     /
     *   13
     *
     * */
    @Test
    public void serializeTwoNodes() throws Exception {
        final AVL.Node n13 = new AVL.Node(13);
        final AVL.Node n12 = new AVL.Node(12, n13, null);

        final String serialize = AVLHelper.serialize(n12);
        assertThat(serialize, is("12 13 -1 -1 -1"));
    }

    @Test
    public void deserializeTwoNodes() throws Exception {
        final String tree = "12 13 -1 -1 -1 ";
        final AVL.Node root = AVLHelper.deserialize(tree);

        final AVL.Node n13 = new AVL.Node(13);
        final AVL.Node n12 = new AVL.Node(12, n13, null);

        assertThat(root, is(n12));
    }

    /*
    * Input:
    *         20
    *       /
    *      8
    *     / \
    *    4  12
    *      /  \
    *     10  14
    *
    * */

    @Test
    public void serializeTree() throws Exception {
        final AVL.Node n10 = new AVL.Node(10);
        final AVL.Node n14 = new AVL.Node(14);
        final AVL.Node n12 = new AVL.Node(12, n10, n14);
        final AVL.Node n4 = new AVL.Node(4);
        final AVL.Node n8 = new AVL.Node(8, n4, n12);
        final AVL.Node n20 = new AVL.Node(20, n8, null);

        final String serialize = AVLHelper.serialize(n20);
        assertThat(serialize, is("20 8 4 -1 -1 12 10 -1 -1 14 -1 -1 -1"));
    }

    @Test
    public void deserializeTree() throws Exception {
        final String tree = "20 8 4 -1 -1 12 10 -1 -1 14 -1 -1 -1 ";
        final AVL.Node root = AVLHelper.deserialize(tree);

        final AVL.Node n10 = new AVL.Node(10);
        final AVL.Node n14 = new AVL.Node(14);
        final AVL.Node n12 = new AVL.Node(12, n10, n14);
        final AVL.Node n4 = new AVL.Node(4);
        final AVL.Node n8 = new AVL.Node(8, n4, n12);
        final AVL.Node n20 = new AVL.Node(20, n8, null);

        assertThat(root, is(n20));
    }
}
