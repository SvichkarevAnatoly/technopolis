import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuickSort {
    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        final int p = partition(arr, lo, hi);
        sort(arr, lo, p - 1);
        sort(arr, p + 1, hi);
    }

    private static int partition(int[] arr, int lo, int hi) {
        int pivotIndex = lo - (lo - hi) / 2;
        int i = lo;
        int j = hi;
        while (i < j) {
            while (i < pivotIndex && (arr[i] <= arr[pivotIndex])) i++;
            while (j > pivotIndex && (arr[pivotIndex] <= arr[j])) j--;
            if (i < j) {
                swap(arr, i, j);
                if (i == pivotIndex)
                    pivotIndex = j;
                else if (j == pivotIndex)
                    pivotIndex = i;
            }
        }
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        final int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        boolean hasNext() {
            return st.hasMoreTokens();
        }
    }

    public static void main(String[] args) {
        final int MAX_SIZE = 100000;

        final FastScanner scanner = new FastScanner();
        final int[] arr = new int[MAX_SIZE];

        int i = 0;
        while (scanner.hasNext()) {
            arr[i++] = scanner.nextInt();
        }

        sort(arr, 0, i - 1);

        printArray(arr, i);
    }

    private static void printArray(int[] arr, int size) {
        final StringBuilder sb = new StringBuilder(2 * size);
        for (int i = 0; i < size; i++) {
            sb.append(arr[i]).append(' ');
        }
        System.out.println(sb.toString().trim());
    }
}
