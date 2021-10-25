package wahlserver;

public class Stimme {
    public int getStufe() {
        return stufe;
    }

    public int getWahl1() {
        return wahl1;
    }

    public int getWahl2() {
        return wahl2;
    }

    private int id;
    private int stufe;
    private int wahl1;
    private int wahl2;

    // new Stimme(382763, 12, 3, 4)
    public Stimme(int id, int stufe, int wahl1, int wahl2) {
        this.id = id;
        this.stufe = stufe;
        this.wahl1 = wahl1;
        this.wahl2 = wahl2;
    }
}
