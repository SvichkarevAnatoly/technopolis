import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.e-olymp.com/ru/problems/4039
public class Heap {
    private static final int DEFAULT_CAPACITY = 10;
    private int[] elementData;
    private int size;

    public Heap() {
        elementData = new int[DEFAULT_CAPACITY];
    }

    public void insert(int item) {
        grow();
        elementData[size++] = item;
        siftUp();
    }

    public int extract() {
        int max = elementData[0];
        elementData[0] = elementData[--size];
        siftDown();
        return max;
    }

    public void siftUp() {
        int curIndex = size - 1;
        if (curIndex != 0) {
            int parentIndex;
            do {
                parentIndex = (curIndex - 1) / 2;
                if (elementData[curIndex] > elementData[parentIndex]) {
                    int tmp = elementData[parentIndex];
                    elementData[parentIndex] = elementData[curIndex];
                    elementData[curIndex] = tmp;
                    curIndex = parentIndex;
                } else {
                    return;
                }
            } while (parentIndex != 0);
        }
    }

    public void siftDown() {
        int p = 0;
        while (p < size) {
            int maxChild = 2 * p + 1; // l
            if (maxChild >= size) {
                return;
            }
            int r = 2 * p + 2;
            if (r < size) {
                if (elementData[r] > elementData[maxChild]) {
                    maxChild = r;
                }
            }
            if (elementData[p] < elementData[maxChild]) {
                int tmp = elementData[maxChild];
                elementData[maxChild] = elementData[p];
                elementData[p] = tmp;
            }
            p = maxChild;
        }
    }

    private void grow() {
        if (size == elementData.length) {
            int oldCapacity = elementData.length;
            // <=> * 1.5
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            changeCapacity(newCapacity);
        }
    }

    @SuppressWarnings("unchecked")
    private void changeCapacity(int newCapacity) {
        int oldSize = elementData.length;
        final int[] newArray = new int[newCapacity];
        for (int i = 0; i < oldSize; i++) {
            newArray[i] = elementData[i];
        }
        elementData = newArray;
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
        final Heap heap = new Heap();
        for (int i = 0; i < n; i++) {
            final String command = scanner.next();
            if ("0".equals(command)) {
                final int item = scanner.nextInt();
                heap.insert(item);
            } else {
                System.out.println(heap.extract());
            }
        }
    }
}
