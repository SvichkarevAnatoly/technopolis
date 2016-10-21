import org.junit.Test;

import static org.testng.Assert.assertEquals;

public class RopesTest {
    @Test
    public void sample1() {
        final int k = 11;
        final int[] ropeLengths = {802, 743, 457, 539};
        final int maxLength = Ropes.getMaxLength(ropeLengths, k);
        assertEquals(maxLength, 200);
    }

    @Test
    public void sample2() {
        final int k = 3;
        final int[] ropeLengths = {802, 743, 457, 539};
        final int maxLength = Ropes.getMaxLength(ropeLengths, k);
        assertEquals(maxLength, 539);
    }

    @Test
    public void sample3() {
        final int k = 2;
        final int[] ropeLengths = {400};
        final int maxLength = Ropes.getMaxLength(ropeLengths, k);
        assertEquals(maxLength, 200);
    }

    @Test
    public void sample4() {
        final int k = 200;
        final int[] ropeLengths = {100};
        final int maxLength = Ropes.getMaxLength(ropeLengths, k);
        assertEquals(maxLength, 0);
    }

    @Test
    public void sample5() {
        final int k = 2;
        final int[] ropeLengths = {2, 1, 1};
        final int maxLength = Ropes.getMaxLength(ropeLengths, k);
        assertEquals(maxLength, 1);
    }

    @Test
    public void sample6() {
        final int k = 1;
        final int[] ropeLengths = {400, 400};
        final int maxLength = Ropes.getMaxLength(ropeLengths, k);
        assertEquals(maxLength, 400);
    }

    @Test
    public void sample7() {
        final int k = 2;
        final int[] ropeLengths = {5, 1};
        final int maxLength = Ropes.getMaxLength(ropeLengths, k);
        assertEquals(maxLength, 2);
    }

    @Test
    public void sample8() {
        final int k = 2;
        final int[] ropeLengths = {2, 1};
        final int maxLength = Ropes.getMaxLength(ropeLengths, k);
        assertEquals(maxLength, 1);
    }

    @Test
    public void sample9() {
        final int k = 2;
        final int[] ropeLengths = {5};
        final int maxLength = Ropes.getMaxLength(ropeLengths, k);
        assertEquals(maxLength, 2);
    }

    @Test
    public void sample1MaxBound() {
        final int k = 11;
        final int[] ropeLengths = {802, 743, 457, 539};
        final int maxBound = Ropes.getMaxBound(ropeLengths, k);
        assertEquals(maxBound, 231);
    }

    @Test
    public void sample1CheckLength() {
        final int k = 11;
        final int[] ropeLengths = {802, 743, 457, 539};
        assertEquals(Ropes.checkLength(231, ropeLengths, k), -1);
        assertEquals(Ropes.checkLength(200, ropeLengths, k), 0);
        assertEquals(Ropes.checkLength(199, ropeLengths, k), 0);
        assertEquals(Ropes.checkLength(150, ropeLengths, k), 1);
    }
}
