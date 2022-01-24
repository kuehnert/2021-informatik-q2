package stack;

import queue.Item;

// stack = Stapel = FILO Speicher
public class Keller<T> {
    // head == unterstes Element
    Item<T> top;
    int size;

    public Keller() {
        clear();
    }

    private void clear() {
        top = null;
        size = 0;
    }

    // peek() == reingucken => oberstes Element
    public T peek() {
        if (top == null) {
            return null;
        } else {
            return top.getData();
        }
    }

    public void push(T data) {
        top = new Item<>(data, top);
        size++;
    }

    public T pop() {
        if (top == null) {
            throw new RuntimeException("Stack empty");
        } else {
            T data = top.getData();
            top = top.getNext();
            size--;
            return data;
        }
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }
}
