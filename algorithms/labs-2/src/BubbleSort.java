import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.e-olymp.com/ru/problems/4741
public class BubbleSort {
    public static int getSwapNumber(int[] arr) {
        int swapCounter = 0;

        int j = 1;
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < arr.length - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    final int tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    swapped = true;
                    swapCounter++;
                }
            }
            j++;
        }

        return swapCounter;
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
        System.out.println(getSwapNumber(arr));
    }
}
