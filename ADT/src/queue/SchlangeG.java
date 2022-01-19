package queue;

// Garbage Collector

public class SchlangeG<T> {
    private ItemG<T> head;

    public SchlangeG() {
        clear();
    }

    public void clear() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        ItemG runner = head;
        int size = 0;

        while (runner != null) {
            runner = runner.getNext();
            size += 1;
        }

        return size;
    }

    public void enqueue(T data) {
        ItemG newItemG = new ItemG<T>(data);

        if (head == null) {
            head = newItemG;
        } else {
            ItemG runner = head;

            while (runner.getNext() != null) {
                runner = runner.getNext();
            }

            runner.setNext(newItemG);
        }
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        } else {
            var data = head.getData();
            head = head.getNext();
            return data;
        }
    }

    public T head() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        } else {
            return head.getData();
        }
    }
}

class ItemG<T> {
    private T data;
    private ItemG<T> next;

    public ItemG(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ItemG getNext() {
        return next;
    }

    public void setNext(ItemG next) {
        this.next = next;
    }
}
