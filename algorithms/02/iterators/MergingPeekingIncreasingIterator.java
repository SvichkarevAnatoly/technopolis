package iterators;

import java.util.Comparator;
import java.util.Iterator;

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
    private final Comparator<IPeekingIterator<Integer>> comparator = (p1, p2) -> p1.peek().compareTo(p2.peek());
    private final IPeekingIterator<Integer>[] iterators;

    @SafeVarargs
    public MergingPeekingIncreasingIterator(IPeekingIterator<Integer> ... peekingIterators) {
        this.iterators = peekingIterators;
    }

    @Override
    public boolean hasNext() {
        for (IPeekingIterator iterator : iterators) {
            if (iterator.hasNext()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer next() {
        IPeekingIterator<Integer> minElementIterator = null;
        for (IPeekingIterator<Integer> iterator : iterators) {
            if (iterator.hasNext()) {
                minElementIterator = iterator;
                break;
            }
        }

        for (IPeekingIterator<Integer> iterator : iterators) {
            if (iterator.hasNext()) {
                if(comparator.compare(iterator, minElementIterator) < 0){
                    minElementIterator = iterator;
                }
            }
        }
        return minElementIterator.next();
    }
}
