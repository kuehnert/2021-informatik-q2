package queue;

public class Student {
    private int id;
    private String vorname;
    private String nachname;

    public Student(int id, String vorname, String nachname) {
        this.id = id;
        this.vorname = vorname;
        this.nachname = nachname;
    }

    public Student(String vorname, String nachname) {
        this.id = -1;
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

    @Override
    public String toString() {
        return String.format("%d. %s %s", id, vorname, nachname);
    }

    protected String searchString() {
        return nachname + "," + vorname;
    }

    @Override
    public boolean equals(Object other) {
        if (other.getClass() != Student.class) {
            return false;
        } else {
            return searchString().equals(((Student) other).searchString());
        }
    }
}
