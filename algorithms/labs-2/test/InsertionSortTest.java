import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class InsertionSortTest {
    @Test
    public void sample1() throws Exception {
        int arr[] = new int[]{2, 1};
        int expectedArr[] = new int[]{1, 2};
        InsertionSort.insert(arr, 1);
        assertThat(expectedArr, is(arr));
    }

    @Test
    public void sample2() throws Exception {
        int arr[] = new int[]{2, 1, 5, 3};
        int expectedArrs[][] = new int[][]{
                {1, 2, 5, 3},
                {1, 2, 3, 5}};
        int j = 0;
        for (int i = 1; i < arr.length; i++) {
            final boolean wasSwap = InsertionSort.insert(arr, i);
            if (wasSwap) {
                assertThat("iteration " + i, expectedArrs[j++], is(arr));
            }
        }
    }
}
