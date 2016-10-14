package task2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// https://www.e-olymp.com/ru/problems/3966
public class Task2 {
    FastScanner in;
    PrintWriter out;

    public void run() {
        in = new FastScanner();
        out = new PrintWriter(System.out);

        final Parser parser = new Parser(in);
        new Solver(parser, out).solve();

        out.close();
    }

    class FastScanner implements NextReader {
        BufferedReader br;

        StringTokenizer st;

        FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        @Override
        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        @Override
        public int nextInt() {
            return Integer.parseInt(next());
        }

    }

    public static void main(String[] arg) {
        new Task2().run();
    }
}

class Solver {
    private final Parser parser;
    private final PrintWriter out;

    public Solver(Parser parser, PrintWriter out) {
        this.parser = parser;
        this.out = out;
    }

    public void solve() {
        for (int i = 0; i < parser.M; i++) {
            int butterflyId = parser.nextInt();
            int position = binarySearch(butterflyId);
            out.println(position > -1 ? "YES" : "NO");
        }
    }

    private int binarySearch(int key) {
        final List<Integer> A = parser.collection;
        int l = 0, r = A.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (key > A.get(mid)) {
                l = mid + 1;
            } else if (key < A.get(mid)) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}

interface NextReader {
    String next();

    int nextInt();
}

class Parser {
    private NextReader reader;
    public List<Integer> collection;
    public int M;

    public Parser(NextReader in) {
        reader = in;
        parse();
    }

    public void parse() {
        int N = reader.nextInt();
        collection = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            collection.add(reader.nextInt());
        }
        M = reader.nextInt();
    }

    public int nextInt() {
        return reader.nextInt();
    }
}
