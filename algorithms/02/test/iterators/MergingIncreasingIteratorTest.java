package test.iterators;

import iterators.IncreasingIterator;
import iterators.MergingIncreasingIterator;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MergingIncreasingIteratorTest {
    @Test
    public void increasingIterator() {
        final IncreasingIterator iterator = new IncreasingIterator(5, 2, 4, new Random(0));
        assertTrue(iterator.hasNext());
        final int[] expectedValues = {5, 5, 6, 7};
        for (int expectedValue : expectedValues) {
            assertEquals(expectedValue, iterator.next().intValue());
        }
        assertFalse(iterator.hasNext());
    }

    @Test
    public void likeExample() {
        final MergingIncreasingIterator mergingIterator = new MergingIncreasingIterator(
                new IncreasingIterator(1, 3, 5, new Random(0)),
                new IncreasingIterator(0, 3, 5, new Random(0))
        );

        final int[] expectedValues = {0, 1, 2, 3, 5, 5, 6, 6, 7, 8};
        for (int expectedValue : expectedValues) {
            assertEquals(expectedValue, mergingIterator.next().intValue());
        }
    }
}
