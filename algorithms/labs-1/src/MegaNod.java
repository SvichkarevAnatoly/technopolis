import java.util.Scanner;

// https://www.e-olymp.com/ru/problems/3920
public class MegaNod {
    public static int getMaxNod(MyArrayList<Integer> numbers) {
        MyArrayList<Integer> commonDividers = getDividers(numbers.get(0));
        for (int i = 1; i < numbers.size(); i++) {
            commonDividers = getNod(numbers.get(i), commonDividers);
        }
        int productCommonDividers = 1;
        for (int i = 0; i < commonDividers.size(); i++) {
            productCommonDividers *= commonDividers.get(i);
        }
        return productCommonDividers;
    }

    public static MyArrayList<Integer> getDividers(int number) {
        final MyArrayList<Integer> dividers = new MyArrayList<>();
        for (int i = 2; i <= number; i++) {
            while (number % i == 0) {
                dividers.add(i);
                number /= i;
            }
        }
        return dividers;
    }

    public static MyArrayList<Integer> getNod(int n, MyArrayList<Integer> dividers) {
        final MyArrayList<Integer> commonDividers = new MyArrayList<>();
        for (int i = 0; i < dividers.size(); i++) {
            final int curDivider = dividers.get(i);
            if (n % curDivider == 0) {
                commonDividers.add(curDivider);
                n /= curDivider;
            }
        }
        return commonDividers;
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final MyArrayList<Integer> numbers = new MyArrayList<>();
        while (scanner.hasNextInt()) {
            numbers.add(scanner.nextInt());
        }

        final int maxNod = getMaxNod(numbers);

        System.out.println(maxNod);
    }
}

class MyArrayList<Item> {
    private static final int DEFAULT_CAPACITY = 10;

    private Item[] elementData;
    private int size;

    @SuppressWarnings("unchecked")
    public MyArrayList() {
        this.elementData = (Item[]) new Object[DEFAULT_CAPACITY];
    }

    public void add(Item item) {
        grow();
        elementData[size++] = item;
    }

    public Item get(int i) {
        return elementData[i];
    }

    public int size() {
        return size;
    }

    private void grow() {
        if (size == elementData.length) {
            int oldCapacity = elementData.length;
            // <=> * 1.5
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            changeCapacity(newCapacity);
        }
    }

    @SuppressWarnings("unchecked")
    private void changeCapacity(int newCapacity) {
        int oldSize = elementData.length;
        final Item[] newArray = (Item[]) new Object[newCapacity];
        for (int i = 0; i < oldSize; i++) {
            newArray[i] = elementData[i];
        }
        elementData = newArray;
    }
}