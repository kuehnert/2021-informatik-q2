package queue;

// Garbage Collector

public class Schlange {
    private Item head;

    public Schlange() {
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



    public void enqueue(String data) {
        Item newItem = new Item(data);

        if (head == null) {
            head = newItem;
        } else {
            Item runner = head;

            while (runner.getNext() != null) {
                runner = runner.getNext();
            }

            runner.setNext(newItem);
        }
    }
}

class Item {
    private String data;
    private Item next;

    public Item(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Item getNext() {
        return next;
    }

    public void setNext(Item next) {
        this.next = next;
    }
}
