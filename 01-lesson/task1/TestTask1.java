package task1;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class TestTask1 {
    @Test
    public void test1() {
        String input =
                "20\n" +
                        "30 37 31 25 32 29 35 40 28 25 30 34 26 23 20 22 21 30 38 33";
        Scanner in = new Scanner(input);

        final InputReader inputReader = new InputReader(in);

        final Solver solver = new Solver(inputReader.masses);
        final Answer a = solver.solve();

        assertEquals(2, a.milkPackages);
        assertEquals(9, a.pies);
    }
}