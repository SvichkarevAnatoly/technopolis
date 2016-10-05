package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// нужен принтврайтер

// https://www.e-olymp.com/ru/problems/3966
public class Main {
    public static void main(String[] args) {
        System.out.println("sdf");
    }
}

class Solver {
    private final Scanner in;
    private final int m;
    private List<Integer> collection;

    public Solver(List<Integer> collection, int m, Scanner in) {
        this.collection = collection;
        this.m = m;
        this.in = in;
    }

    public Answer solve() {
        for (int i = 0; i < m; i++) {
            final int ind = in.nextInt();

        }
        return new Answer();
    }
}

class InputReader {
    public int n;
    public List<Integer> collection = new ArrayList<>();
    public int m;

    public InputReader(Scanner in) {
        n = in.nextInt();
        for (int i = 0; i < n; i++) {
            collection.add(in.nextInt());
        }
        m = in.nextInt();
    }
}

class Answer {
    public List<String> yesnos = new ArrayList<>();
}
