import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class InsertionSort {
    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            final boolean wasSwap = insert(arr, i);
            if (wasSwap) {
                printArray(arr);
            }
        }
    }

    public static boolean insert(int[] arr, int i) {
        int j = i;
        boolean wasSwap = false;
        while (j > 0 && arr[j - 1] > arr[j]) {
            swap(arr, j, j - 1);
            j--;
            wasSwap = true;
        }
        return wasSwap;
    }

    private static void swap(int[] arr, int i, int j) {
        final int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    private static void printArray(int[] arr) {
        final StringBuilder sb = new StringBuilder(2 * arr.length);
        for (int anArr : arr) {
            sb.append(anArr).append(' ');
        }
        System.out.println(sb.toString().trim());
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
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
    }

    public static void main(String[] args) {
        final FastScanner scanner = new FastScanner();
        final int n = scanner.nextInt();
        final int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            final int x = scanner.nextInt();
            arr[i] = x;
        }
        sort(arr);
    }
}
