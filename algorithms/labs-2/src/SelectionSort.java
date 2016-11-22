import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.e-olymp.com/ru/problems/2662
public class SelectionSort {
    public static int getFirstElementSwapNumber(int[] arr) {
        int swapCounter = 0;
        int firstElementIndex = 0;
        for (int j = 0; j < arr.length - 1; j++) {
            int iMin = j;
            for (int i = j + 1; i < arr.length; i++) {
                if (arr[i] < arr[iMin]) {
                    iMin = i;
                }
            }
            if (iMin != j) {
                final int tmp = arr[iMin];
                arr[iMin] = arr[j];
                arr[j] = tmp;

                if (iMin == firstElementIndex) {
                    firstElementIndex = j;
                    swapCounter++;
                } else if (j == firstElementIndex) {
                    firstElementIndex = iMin;
                    swapCounter++;
                }
            }
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
        System.out.println(getFirstElementSwapNumber(arr));
    }
}
