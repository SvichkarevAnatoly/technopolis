import java.util.Scanner;

// https://www.e-olymp.com/ru/problems/5333
public class Ropes {
    public static int getMaxLength(int[] ropeLengths, int k) {
        final int maxBound = getMaxBound(ropeLengths, k);
        if (maxBound == 0) {
            return 0;
        }
        final int checkMaxBound = checkLength(maxBound, ropeLengths, k);
        if (checkMaxBound == 0) {
            return maxBound;
        }

        return binarySearch(ropeLengths, k, maxBound);
    }

    public static int binarySearch(int[] ropeLengths, int k, int maxBound) {
        int l = 1, r = maxBound;
        while (l < r - 1) {
            int checkedLength = (l + r) / 2;
            switch (checkLength(checkedLength, ropeLengths, k)) {
                case -1:
                    r = checkedLength;
                    break;
                case 0:
                case 1:
                    l = checkedLength;
                    break;
            }
        }
        return l;
    }

    public static int getMaxBound(int[] ropeLengths, int k) {
        int maxBound = 0;
        for (int ropeLength : ropeLengths) {
            maxBound += ropeLength;
        }
        return maxBound / k;
    }

    public static int checkLength(int checkedLength, int[] ropeLengths, int k) {
        int partNumber = 0;
        for (int ropeLength : ropeLengths) {
            partNumber += ropeLength / checkedLength;
        }
        return Integer.compare(partNumber, k);
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final int k = scanner.nextInt();
        final int[] ropeLengths = new int[n];
        for (int i = 0; i < n; i++) {
            ropeLengths[i] = scanner.nextInt();
        }
        final int maxLength = getMaxLength(ropeLengths, k);
        System.out.println(maxLength);
    }
}
