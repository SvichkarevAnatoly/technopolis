import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.e-olymp.com/ru/problems/6125
public class Queue {
    private static final int DEFAULT_CAPACITY = 101;
    private int[] elementData;
    private int head, tail;

    public Queue() {
        elementData = new int[DEFAULT_CAPACITY];
        head = 0;
        tail = 0;
    }

    public void push(int item) {
        elementData[tail] = item;
        tail = (tail + 1) % DEFAULT_CAPACITY;
    }

    public int pop() {
        final int item = elementData[head];
        // for debug
        elementData[head] = 0;
        head = (head + 1) % DEFAULT_CAPACITY;
        return item;
    }

    public int front() {
        return elementData[head];
    }

    public void clear() {
        head = tail = 0;
    }

    public int size() {
        if (tail >= head) {
            return tail - head;
        } else {
            return (DEFAULT_CAPACITY - head) + tail;
        }
    }

    public static void main(String[] args) {
        final FastScanner fs = new FastScanner();
        final Queue q = new Queue();
        String command;
        do {
            command = fs.next();
            switch (command) {
                case "push":
                    q.push(fs.nextInt());
                    System.out.println("ok");
                    break;
                case "pop":
                    System.out.println(q.pop());
                    break;
                case "front":
                    System.out.println(q.front());
                    break;
                case "size":
                    System.out.println(q.size());
                    break;
                case "clear":
                    q.clear();
                    System.out.println("ok");
                    break;
                case "exit":
                    System.out.println("bye");
                    break;
            }
        } while (!command.equals("exit"));
    }
}

class FastScanner {
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
