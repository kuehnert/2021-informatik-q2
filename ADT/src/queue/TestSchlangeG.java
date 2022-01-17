package queue;

public class TestSchlangeG {
    public static void main(String[] args) {
        Student st = new Student(1, "A", "B");
        ItemG<Student> i = new ItemG<Student>(st);
        System.out.println(i.getData());
        System.out.println(i.getData().getNachname());

    }
}
