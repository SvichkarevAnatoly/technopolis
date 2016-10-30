package test.other;

import org.junit.Test;
import other.Solver;

import static org.junit.Assert.assertEquals;

public class SolverTest {
    @Test
    public void expression1() {
        final String[] expression = "( 1 + 100 )".split(" ");
        assertEquals(101, Solver.evaluate(expression), 0.01);
    }

    @Test
    public void expression2() {
        final String[] expression = "( 1 + ( 5 * ( 4 * 5 ) ) ) ( 1 + ( 5 * 20 ) )".split(" ");
        assertEquals(101, Solver.evaluate(expression), 0.01);
    }

    @Test
    public void expression3() {
        final String[] expression = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )".split(" ");
        assertEquals(101, Solver.evaluate(expression), 0.01);
    }
}
