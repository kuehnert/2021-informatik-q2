package queue;

// Garbage Collector

public class SchlangeG {
    private ItemG head;

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

    public void enqueue(Object data) {
        ItemG newItemG = new ItemG(data);

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

    public Object dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        } else {
            Object data = head.getData();
            head = head.getNext();
            return data;
        }
    }

    public Object head() {
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
