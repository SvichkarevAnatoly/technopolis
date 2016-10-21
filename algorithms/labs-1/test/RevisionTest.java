import org.junit.Test;

import static org.testng.Assert.assertEquals;

public class RevisionTest {
    @Test
    public void sample1() {
        final int[] serialNumbers = {49, 100, 23, -100, 157};
        final Revision.TwoMin ans = Revision.searchTwoMin(serialNumbers);
        assertEquals(-100, ans.min1);
        assertEquals(23, ans.min2);
    }

    @Test
    public void sample2() {
        final int[] serialNumbers = {1, 2149, 1};
        final Revision.TwoMin ans = Revision.searchTwoMin(serialNumbers);
        assertEquals(1, ans.min1);
        assertEquals(1, ans.min2);
    }

    @Test
    public void sampleReverseInit() {
        final int[] serialNumbers = {2, 1, 999};
        final Revision.TwoMin ans = Revision.searchTwoMin(serialNumbers);
        assertEquals(1, ans.min1);
        assertEquals(2, ans.min2);
    }
}
