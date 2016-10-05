package task1;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// https://www.e-olymp.com/ru/problems/7365
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        final InputReader inReader = new InputReader(in);

        final Solver solver = new Solver(inReader.masses);
        final Answer answer = solver.solve();

        out.println(answer.milkPackages + " " + answer.pies);
        out.flush();
    }
}

class InputReader {
    public int n;
    public List<Double> masses = new ArrayList<>();

    public InputReader(Scanner in) {
        n = in.nextInt();
        for (int i = 0; i < n; i++) {
            masses.add(in.nextDouble());
        }
    }
}

class Solver {
    private final int MIN_MASS = 30;
    private final double MILLILITERS_IN_GLASS = 0.2;
    private final double MILLILITERS_IN_PACKAGE = 0.9;

    private List<Double> masses;

    public Solver(List<Double> masses) {
        this.masses = masses;
    }

    public Answer solve() {
        final Answer answer = new Answer();
        for (Double mass : masses) {
            if (mass < MIN_MASS) {
                answer.pies++;
            }
        }

        answer.milkPackages = (int) Math.ceil((answer.pies * MILLILITERS_IN_GLASS) / MILLILITERS_IN_PACKAGE);
        return answer;
    }
}

class Answer {
    public int milkPackages;
    public int pies;
}