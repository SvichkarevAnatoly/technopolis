import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class QuickSortTest {
    @Test
    public void sample1() throws Exception {
        final int arr[] = new int[]{4, 1, 4, 8, 6, 6, 5};
        final int[] sortedArr = {1, 4, 4, 5, 6, 6, 8};

        QuickSort.sort(arr);

        assertThat(arr, is(sortedArr));
    }

    @Test
    public void sample2() throws Exception {
        final int arr[] = new int[]{4, 1, 4, 5};
        final int[] sortedArr = {1, 4, 4, 5};

        QuickSort.sort(arr);

        assertThat(arr, is(sortedArr));
    }
}
