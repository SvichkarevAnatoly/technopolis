import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BubbleSortTest {
    @Test
    public void sample1() throws Exception {
        int arr[] = new int[]{1, 3, 2};
        assertThat(1, is(BubbleSort.getSwapNumber(arr)));
    }

    @Test
    public void sample2() throws Exception {
        int arr[] = new int[]{2, 1};
        assertThat(1, is(BubbleSort.getSwapNumber(arr)));
    }

    @Test
    public void sample3() throws Exception {
        int arr[] = new int[]{4, 1, 5, 3};
        assertThat(3, is(BubbleSort.getSwapNumber(arr)));
    }
}
