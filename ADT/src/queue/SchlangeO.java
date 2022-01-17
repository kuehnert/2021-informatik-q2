package queue;

// Garbage Collector

public class SchlangeO {
    private ItemO head;

    public SchlangeO() {
        clear();
    }

    public void clear() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        ItemO runner = head;
        int size = 0;

        while (runner != null) {
            runner = runner.getNext();
            size += 1;
        }

        return size;
    }

    public void enqueue(String data) {
        ItemO newItemO = new ItemO(data);

        if (head == null) {
            head = newItemO;
        } else {
            ItemO runner = head;

            while (runner.getNext() != null) {
                runner = runner.getNext();
            }

            runner.setNext(newItemO);
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

class ItemO {
    private String data;
    private ItemO next;

    public ItemO(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public ItemO getNext() {
        return next;
    }

    public void setNext(ItemO next) {
        this.next = next;
    }
}

class Student {
    private int id;
    private String vorname;
    private String nachname;

    public Student(int id, String vorname, String nachname) {
        this.id = id;
        this.vorname = vorname;
        this.nachname = nachname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }
}