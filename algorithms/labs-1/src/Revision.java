import java.util.Scanner;

// https://www.e-olymp.com/ru/problems/1459
public class Revision {
    public static TwoMin searchTwoMin(int[] numbers) {
        final TwoMin ans = new TwoMin();
        ans.min1 = numbers[0];
        ans.min2 = numbers[1];
        if (ans.min1 > ans.min2) {
            ans.min1 = numbers[1];
            ans.min2 = numbers[0];
        }

        for (int i = 2; i < numbers.length; i++) {
            if (numbers[i] <= ans.min1) {
                ans.min2 = ans.min1;
                ans.min1 = numbers[i];
            } else if (numbers[i] < ans.min2) {
                ans.min2 = numbers[i];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final int[] serialNumbers = new int[n];
        for (int i = 0; i < n; i++) {
            serialNumbers[i] = scanner.nextInt();
        }
        final TwoMin ans = searchTwoMin(serialNumbers);
        System.out.println(ans.min1 + " " + ans.min2);
    }

    static class TwoMin{
        public int min1, min2;
    }
}
