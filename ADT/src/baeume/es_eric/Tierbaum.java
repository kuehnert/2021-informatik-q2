package baeume.es_eric;

public class Tierbaum<T> {
    Knoten<T> wurzel;
    String ausgabe = "";
    public Tierbaum() {
        clear();
    }

    public void clear() {
        wurzel = null;
    }
    public Knoten<T> getWurzel(){
        return wurzel;
    }
    public void add(T data, Knoten<T> current, Boolean direction){
        if (wurzel == null){
            wurzel = new Knoten<T>(data);
        }
        else {
            if (direction){
                current.setLinks(new Knoten<T>(data));
            }
            else {
                current.setRechts(new Knoten<T>(data));
            }
        }
    }
}
