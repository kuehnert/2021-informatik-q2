package baeume.es_eric;


public class Knoten<T> {
    private T data;
    private Knoten<T> links;
    private Knoten<T> rechts;
    public Knoten(T data) {
        this.data = data;
    }



    public Knoten(T data, Knoten<T> next, Knoten<T> prev) {
        this.data = data;
        this.links = next;
        this.rechts = prev;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Knoten<T> getLinks() {
        return links;
    }

    public void setLinks(Knoten<T> links) {
        this.links = links;
    }
    public Knoten<T> getRechts() {
        return rechts;
    }

    public void setRechts(Knoten<T> rechts) {
        this.rechts = rechts;
    }

}
