import java.util.Scanner;

// https://www.e-olymp.com/ru/problems/3917
public class CheckSimplicity {
    public static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final String answer = isPrime(n) ? "True" : "False";
        System.out.println(answer);
    }
}