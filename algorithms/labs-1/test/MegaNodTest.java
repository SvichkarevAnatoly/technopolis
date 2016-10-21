import org.junit.Test;

import static org.testng.Assert.assertEquals;

public class MegaNodTest {
    @Test
    public void example18_30_21return3() {
        final MyArrayList<Integer> numbers = new MyArrayList<>();
        numbers.add(18);
        numbers.add(30);
        numbers.add(21);
        assertEquals(3, MegaNod.getMaxNod(numbers));
    }

    @Test
    public void getDividers4() {
        final MyArrayList<Integer> dividers = MegaNod.getDividers(4);
        assertEquals(2, dividers.size());
        assertEquals(2, dividers.get(0).intValue());
        assertEquals(2, dividers.get(1).intValue());
    }

    @Test
    public void getDividers21() {
        final MyArrayList<Integer> dividers = MegaNod.getDividers(21);
        assertEquals(2, dividers.size());
        assertEquals(3, dividers.get(0).intValue());
        assertEquals(7, dividers.get(1).intValue());
    }

    @Test
    public void getNod6() {
        final MyArrayList<Integer> dividers = MegaNod.getDividers(4);
        final MyArrayList<Integer> nod = MegaNod.getNod(6, dividers);
        assertEquals(1, nod.size());
        assertEquals(2, nod.get(0).intValue());
    }
}
