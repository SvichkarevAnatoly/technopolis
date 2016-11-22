import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Random;
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

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int leftCursor = left - 1;
        int rightCursor = right;
        while (leftCursor < rightCursor) {
            while (arr[++leftCursor] < pivot) ;
            while (rightCursor > 0 && arr[--rightCursor] > pivot) ;
            if (leftCursor >= rightCursor) {
                break;
            } else {
                swap(arr, leftCursor, rightCursor);
            }
        }
        swap(arr, leftCursor, right);
        return leftCursor;
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

        shuffle(arr, i);
        sort(arr, 0, i - 1);

        printArray(arr, i);
    }

    private static void shuffle(int[] arr, int size) {
        final Random random = new Random(0);
        for (int i = 0; i < size / 2; i++) {
            final int j = random.nextInt(size);
            final int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

    private static void printArray(int[] arr, int size) {
        final PrintWriter printWriter = new PrintWriter(System.out);
        for (int i = 0; i < size; i++) {
            printWriter.print(arr[i]);
            printWriter.print(' ');
        }
        printWriter.close();
    }
}
