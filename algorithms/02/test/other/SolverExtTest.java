package test.other;

import org.junit.Test;
import other.SolverExt;

import static org.junit.Assert.assertEquals;

public class SolverExtTest {
    @Test
    public void expression1() {
        final String[] expression = "1 + 100".split(" ");
        assertEquals(101, SolverExt.evaluate(expression), 0.01);
    }

    @Test
    public void expression2() {
        final String[] expression = "( 1 + 100 )".split(" ");
        assertEquals(101, SolverExt.evaluate(expression), 0.01);
    }

    @Test
    public void expression3() {
        final String[] expression = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )".split(" ");
        assertEquals(101, SolverExt.evaluate(expression), 0.01);
    }

    @Test
    public void expression4() {
        final String[] expression = "1 + ( 2 + 3 ) * 4 * 5".split(" ");
        assertEquals(101, SolverExt.evaluate(expression), 0.01);
    }

    @Test
    public void expression5() {
        final String[] expression = "20 / 4".split(" ");
        assertEquals(5, SolverExt.evaluate(expression), 0.01);
    }

    @Test
    public void expression6() {
        final String[] expression = "( 101 - 1 ) / 5".split(" ");
        assertEquals(20, SolverExt.evaluate(expression), 0.01);
    }

    @Test
    public void expression7() {
        final String[] expression = "( 1 + 5 * 4 / 5 + 1 )".split(" ");
        assertEquals(6, SolverExt.evaluate(expression), 0.01);
    }

    @Test
    public void expression8() {
        final String[] expression = "1 + 5 * 4 / 5 + 1".split(" ");
        assertEquals(6, SolverExt.evaluate(expression), 0.01);
    }

    @Test
    public void expression9() {
        final String[] expression = "101 - 1 - 5 / 5".split(" ");
        assertEquals(99, SolverExt.evaluate(expression), 0.01);
    }
}
