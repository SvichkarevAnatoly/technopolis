import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class CheckSimplicityTest {
    @Test
    public void nEquals2() {
        assertTrue(CheckSimplicity.isPrime(2));
    }

    @Test
    public void nEquals3() {
        assertTrue(CheckSimplicity.isPrime(3));
    }

    @Test
    public void nEquals4() {
        assertFalse(CheckSimplicity.isPrime(4));
    }

    @Test
    public void nEquals5() {
        assertTrue(CheckSimplicity.isPrime(5));
    }

    @Test
    public void nEquals10power9() {
        final int n = (int) Math.pow(10, 9);
        assertFalse(CheckSimplicity.isPrime(n));
    }
}
