import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class HeapSort {
    final int MAX_SIZE = 100000;

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
        final FastScanner scanner = new FastScanner();
        final Integer[] arr = new Integer[MAX_SIZE];

        int i = 0;
        while (scanner.hasNext()) {
            arr[i++] = scanner.nextInt();
        }

//        arr = sort(arr, i);

        printArray(arr, i);
    }

    private static Integer[] sort(Integer[] arr, int size) {
        final ArrayPriorityQueue<Integer> heap = new ArrayPriorityQueue<>(arr, size);
        final Integer[] arrr = new Integer[MAX_SIZE];
        for (int i = 0; i < size; i++) {
//            arrr[]
        }
        return arrr;
    }

    private static void printArray(Integer[] arr, int size) {
        final PrintWriter printWriter = new PrintWriter(System.out);
        for (int i = 0; i < size; i++) {
            printWriter.print(arr[i]);
            printWriter.print(' ');
        }
        printWriter.close();
    }
}
