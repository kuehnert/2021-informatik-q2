package queue;

public class Item<T> {
    private T data;
    private Item<T> next;

    public Item(T data) {
        this.data = data;
    }

    public Item(T data, Item<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Item getNext() {
        return next;
    }

    public void setNext(Item next) {
        this.next = next;
    }
}
