package test;

import queue.Item;
import queue.SchlangeG;
import queue.Student;

public class TestSchlangeG {
    private static void testItemG() {
        Student st = new Student(1, "A", "B");
        Item<Student> i = new Item<Student>(st);
        System.out.println(i.getData());
        System.out.println(i.getData().getNachname());
    }

    private static void testSchlangeG() {
        SchlangeG<Student> sl = new SchlangeG<>();
        sl.enqueue(new Student(1, "Alisa", "Keys"));
        sl.enqueue(new Student(2, "Alica", "Kays"));
        sl.enqueue(new Student(3, "Alice", "Koys"));
        System.out.println(sl.head().getNachname());

        SchlangeG<String> sls = new SchlangeG<>();
        sls.enqueue("Hallo");
        sls.enqueue("Welt");
        System.out.println(sls.head().toString());
    }

    public static void main(String[] args) {
        // testItemG();
        testSchlangeG();
    }
}
