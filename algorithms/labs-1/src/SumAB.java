import java.util.Scanner;

// https://www.e-olymp.com/ru/problems/518
public class SumAB {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            final int A = scanner.nextInt();
            final int B = scanner.nextInt();
            System.out.println(A + B);
        }
    }
}
