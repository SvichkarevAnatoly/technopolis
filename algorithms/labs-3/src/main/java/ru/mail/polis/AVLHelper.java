package ru.mail.polis;

import java.util.Scanner;

public class AVLHelper {
    private static final int EMPTY_MARKER = -1;

    public static String serialize(AVL tree) {
        final AVL.Node root = tree.getRoot();
        return serialize(root);
    }

    public static String serialize(AVL.Node root) {
        final StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString().trim();
    }

    private static void serialize(AVL.Node node, StringBuilder sb) {
        if (node == null) {
            sb.append(EMPTY_MARKER).append(' ');
        } else {
            sb.append(node.getKey()).append(' ');
            serialize(node.getLeft(), sb);
            serialize(node.getRight(), sb);
        }
    }

    public static AVL.Node deserialize(String tree) {
        final Scanner scanner = new Scanner(tree);
        return deserialize(scanner);
    }

    private static AVL.Node deserialize(Scanner scanner) {
        if (scanner.hasNextInt()) {
            final int key = scanner.nextInt();
            if (key == EMPTY_MARKER){
                return null;
            } else {
                return new AVL.Node(key,
                        deserialize(scanner),
                        deserialize(scanner));
            }
        }
        return null;
    }
}
