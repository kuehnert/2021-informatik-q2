package queue;

// Garbage Collector

public class SchlangeG<T> {
    private Item<T> head;

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
        Item runner = head;
        int size = 0;

        while (runner != null) {
            runner = runner.getNext();
            size += 1;
        }

        return size;
    }

    public void enqueue(T data) {
        Item newItemG = new Item<T>(data);

        if (head == null) {
            head = newItemG;
        } else {
            Item runner = head;

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

