package collections;

/**
 * LIFO — Last In First Out
 */
public interface IStack<Item> extends Iterable<Item> {

    void push(Item item);

    Item pop();

    Item peek();

    boolean isEmpty();

    int size();
}
