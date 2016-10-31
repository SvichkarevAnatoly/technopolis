package test.iterators;

import iterators.*;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class MergingPeekingIncreasingIteratorTest {
    @Test
    public void increasingIterator() {
        final IPeekingIterator<Integer> iterator = new PeekingIncreasingIterator(5, 2, 4, new Random(0));
        assertTrue(iterator.hasNext());
        final int[] expectedValues = {5, 5, 6, 7};
        for (int expectedValue : expectedValues) {
            assertEquals(expectedValue, iterator.peek().intValue());
            assertEquals(expectedValue, iterator.next().intValue());
        }
        assertFalse(iterator.hasNext());
    }

    @Test
    public void likeExample() {
        final MergingPeekingIncreasingIterator iterator = new MergingPeekingIncreasingIterator(
                new PeekingIncreasingIterator(0, 3, 5, new Random(0)),
                new PeekingIncreasingIterator(1, 3, 5, new Random(1)),
                new PeekingIncreasingIterator(2, 3, 5, new Random(2)));

        final int[] expectedValues = {0, 1, 2, 2, 3, 3, 4, 4, 5, 5, 5, 5, 7, 8, 8};
        for (int expectedValue : expectedValues) {
            assertTrue(iterator.hasNext());
            assertEquals(expectedValue, iterator.next().intValue());
        }
        assertFalse(iterator.hasNext());
    }
}
