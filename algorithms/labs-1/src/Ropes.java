import java.util.Scanner;

// https://www.e-olymp.com/ru/problems/5333
public class Ropes {
    public static long getMaxLength(long[] ropeLengths, int k) {
        final long maxBound = getMaxBound(ropeLengths, k);
        if (maxBound == 0) {
            return 0;
        }
        final int checkMaxBound = checkLength(maxBound, ropeLengths, k);
        if (checkMaxBound >= 0) {
            return maxBound;
        }

        return binarySearch(ropeLengths, k, maxBound);
    }

    public static long binarySearch(long[] ropeLengths, int k, long maxBound) {
        long l = 1, r = maxBound;
        while (l < r - 1) {
            long checkedLength = (l + r) / 2;
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

    public static long getMaxBound(long[] ropeLengths, int k) {
        long maxBound = 0;
        for (long ropeLength : ropeLengths) {
            maxBound += ropeLength;
        }
        return maxBound / k;
    }

    public static int checkLength(long checkedLength, long[] ropeLengths, int k) {
        int partNumber = 0;
        for (long ropeLength : ropeLengths) {
            partNumber += ropeLength / checkedLength;
        }
        return Integer.compare(partNumber, k);
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final int k = scanner.nextInt();
        final long[] ropeLengths = new long[n];
        for (int i = 0; i < n; i++) {
            ropeLengths[i] = (int) scanner.nextLong();
        }
        final long maxLength = getMaxLength(ropeLengths, k);
        System.out.println(maxLength);
    }
}
