import java.util.Scanner;

public class PostfixRecord {
    public static int compute(String record) {
        final MyStack<Integer> stack = new MyStack<>();
        for (int i = 0; i < record.length(); i += 2) {
            if ('0' <= record.charAt(i) && record.charAt(i) <= '9') {
                stack.push(record.charAt(i) - '0');
            } else {
                switch (record.charAt(i)) {
                    case '+':
                        final int add = stack.pop() + stack.pop();
                        stack.push(add);
                        break;
                    case '-':
                        final int b = stack.pop();
                        final int a = stack.pop();
                        stack.push(a - b);
                        break;
                    case '*':
                        final int mult = stack.pop() * stack.pop();
                        stack.push(mult);
                        break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String record = scanner.nextLine();
        final int result = compute(record);
        System.out.println(result);
    }
}

class MyStack<Item> {
    private static final int DEFAULT_CAPACITY = 10;

    private Item[] elementData;
    private int size;

    @SuppressWarnings("unchecked")
    public MyStack() {
        this.elementData = (Item[]) new Object[DEFAULT_CAPACITY];
    }

    public void push(Item item) {
        grow();
        elementData[size++] = item;
    }

    public Item pop() {
        return elementData[--size];
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
