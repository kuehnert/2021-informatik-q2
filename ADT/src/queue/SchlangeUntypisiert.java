package queue;

// Garbage Collector

public class SchlangeUntypisiert {
    private ItemUntypisiert head;

    public SchlangeUntypisiert() {
        clear();
    }

    public void clear() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        ItemUntypisiert runner = head;
        int size = 0;

        while (runner != null) {
            runner = runner.getNext();
            size += 1;
        }

        return size;
    }

    public void enqueue(String data) {
        ItemUntypisiert newItem = new ItemUntypisiert(data);

        if (head == null) {
            head = newItem;
        } else {
            ItemUntypisiert runner = head;

            while (runner.getNext() != null) {
                runner = runner.getNext();
            }

            runner.setNext(newItem);
        }
    }

    public String dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        } else {
            String data = head.getData();
            head = head.getNext();
            return data;
        }
    }

    public String head() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        } else {
            return head.getData();
        }
    }
}

class ItemUntypisiert {
    private String data;
    private ItemUntypisiert next;

    public ItemUntypisiert(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public ItemUntypisiert getNext() {
        return next;
    }

    public void setNext(ItemUntypisiert next) {
        this.next = next;
    }
}
