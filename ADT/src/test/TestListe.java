package test;

import liste.Liste;
import queue.Student;

public class TestListe {
    private static void testDebug() {
        Liste<Student> meineListe = new Liste<>();
        meineListe.debug();
        meineListe.add(new Student(1, "1", "1"));
        meineListe.add(new Student(2, "2", "2"));
        meineListe.add(new Student(3, "3", "3"));
        meineListe.debug();
    }

    private static void testAddGet() {
        Liste<Student> meineListe = new Liste<>();
        meineListe.add(new Student(1, "Alisa", "Keys"));
        meineListe.add(new Student(2, "Alica", "Kays"));
        meineListe.add(new Student(3, "Alice", "Koys"));
        System.out.println(meineListe.first());
        System.out.println(meineListe.get(0));
        System.out.println(meineListe.get(1));
        System.out.println(meineListe.get(2));
        System.out.println(meineListe.get(3));
    }

    private static void testDeleteAt() {
        Liste<String> meineListe = new Liste<>();
        meineListe.debug();
        meineListe.add("1");
        meineListe.add("2");
        meineListe.add("3");
        meineListe.add("4");
        meineListe.add("5");
        meineListe.debug();

        String out = meineListe.deleteAt(2);
        System.out.println("Geloescht: " + out);
        meineListe.debug();

        out = meineListe.deleteAt(1);
        System.out.println("Geloescht: " + out);
        meineListe.debug();

        out = meineListe.deleteAt(2);
        System.out.println("Geloescht: " + out);
        meineListe.debug();

        out = meineListe.deleteAt(0);
        System.out.println("Geloescht: " + out);
        meineListe.debug();

        out = meineListe.deleteAt(0);
        System.out.println("Geloescht: " + out);
        meineListe.debug();
    }

    public static void testFind() {
        Liste<Student> meineListe = new Liste<>();
        Student student = new Student(1, "Hans", "Glock");
        meineListe.add(student);

        Student search = new Student("Hans", "Glock");
        Student gefunden = meineListe.find(search);
        System.out.println("Gefunden: " + gefunden);
    }

    public static void main(String[] args) {
        // testDebug();
        // testAddGet();
        // testDeleteAt();
        testFind();
    }
}
