import java.util.Scanner;

// https://www.e-olymp.com/ru/problems/3970
public class Mutants {
    public static int binarySearchLeft(int[] a, int key) {
        int l = -1;
        int r = a.length;
        while (l < r - 1) {
            int m = (l + r) / 2;
            if (a[m] < key) {
                l = m;
            } else {
                r = m;
            }
        }
        return r;
    }

    public static int binarySearchRight(int[] a, int key) {
        int l = -1;
        int r = a.length;
        while (l < r - 1) {
            int m = (l + r) / 2;
            if (a[m] <= key) {
                l = m;
            } else {
                r = m;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final int[] animals = new int[n];
        for (int i = 0; i < n; i++) {
            animals[i] = scanner.nextInt();
        }
        final int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            final int key = scanner.nextInt();
            int counter = 1;
            counter += binarySearchRight(animals, key);
            counter -= binarySearchLeft(animals, key);
            System.out.println(counter);
        }
    }
}
