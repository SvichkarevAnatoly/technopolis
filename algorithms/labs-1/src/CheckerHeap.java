import java.util.Scanner;

public class CheckerHeap {
    public static boolean isHeap(long[] heap) {
        final int n = heap.length;
        for (int i = 0; i < (n + 2) / 2; i++) {
            if ((2 * i + 1) < n) {
                if (heap[2 * i + 1] < heap[i]) {
                    return false;
                }
            }
            if ((2 * i + 2) < n) {
                if (heap[2 * i + 2] < heap[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final long[] heap = new long[n];
        for (int i = 0; i < n; i++) {
            heap[i] = scanner.nextInt();
        }

        System.out.println(isHeap(heap) ? "YES" : "NO");
    }
}
