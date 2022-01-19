package queue;

public class TestSchlangeG {
    private static void testItemG() {
        Student st = new Student(1, "A", "B");
        ItemG<Student> i = new ItemG<Student>(st);
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
