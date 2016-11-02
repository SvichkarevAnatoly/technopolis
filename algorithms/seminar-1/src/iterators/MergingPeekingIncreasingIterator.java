package iterators;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * Итератор возвращающий последовательность из N возрастающих итераторов в порядке возрастания
 * first = 1,3,4,5,7
 * second = 0,2,4,6,8
 * result = 0,1,2,3,4,4,5,6,7,8
 *
 * Time = O(n + k * log n),
 *  n — количество итераторов
 *  k — суммарное количество элементов
 */
public class MergingPeekingIncreasingIterator implements Iterator<Integer> {
    private final PriorityQueue<IPeekingIterator<Integer>> heap;

    @SafeVarargs
    public MergingPeekingIncreasingIterator(IPeekingIterator<Integer> ... peekingIterators) {
        Comparator<IPeekingIterator<Integer>> comparator = (p1, p2) -> p1.peek().compareTo(p2.peek());
        this.heap = new PriorityQueue<>(peekingIterators.length, comparator);
        for (IPeekingIterator<Integer> iterator : peekingIterators) {
            if (iterator.hasNext()) {
                heap.add(iterator);
            }
        }
    }

    @Override
    public boolean hasNext() {
        return !heap.isEmpty();
    }

    @Override
    public Integer next() {
        final IPeekingIterator<Integer> min = heap.remove();
        final Integer nextValue = min.next();
        if (min.hasNext()) {
            heap.add(min);
        }
        return nextValue;
    }
}
