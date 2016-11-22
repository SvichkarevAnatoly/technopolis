import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SelectionSortTest {
    @Test
    public void sample1() throws Exception {
        int arr[] = new int[]{1, 3, 2};
        assertThat(0, is(SelectionSort.getFirstElementSwapNumber(arr)));
    }

    @Test
    public void sample2() throws Exception {
        int arr[] = new int[]{2, 1};
        assertThat(1, is(SelectionSort.getFirstElementSwapNumber(arr)));
    }
}
