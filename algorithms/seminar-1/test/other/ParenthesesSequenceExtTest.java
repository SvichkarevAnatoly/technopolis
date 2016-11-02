package other;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static other.ParenthesesSequenceExt.isBalanced;

public class ParenthesesSequenceExtTest {
    @Test
    public void isBalanced1() {
        final String sequence = "()()";
        assertTrue(isBalanced(sequence));
    }

    @Test
    public void isBalanced2() {
        final String sequence = "(({}[]))[[[";
        assertFalse(isBalanced(sequence));
    }

    @Test
    public void isBalanced3() {
        final String sequence = "{}";
        assertTrue(isBalanced(sequence));
    }
}
