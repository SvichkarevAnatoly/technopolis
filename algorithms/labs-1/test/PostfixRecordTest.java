import org.junit.Test;

import static org.testng.Assert.assertEquals;

public class PostfixRecordTest {
    @Test
    public void sample1() {
        final String record = "8 9 + 1 7 - *";
        assertEquals(-102, PostfixRecord.compute(record));
    }
}
