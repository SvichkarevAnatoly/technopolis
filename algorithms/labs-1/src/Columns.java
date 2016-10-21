import java.util.Scanner;

// https://www.e-olymp.com/ru/problems/2322
public class Columns {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int x = scanner.nextInt();
        final int n = scanner.nextInt();
        final boolean[] isGood = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                isGood[j] = (scanner.nextInt() == x) || isGood[j];
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(isGood[i] ? "YES" : "NO");
        }
    }
}
