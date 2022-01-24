package test;

import queue.SchlangeO;
import queue.Student;

public class TestSchlangeO {
    private static void testSchlangeO() {
        Student s0 = new Student(1, "Alisa", "Roeller");
        Student s1 = new Student(2, "David", "Doeller");
        Student s2 = new Student(3, "Jens", "Joeller");
        Student s3 = new Student(4, "Ben", "Boeller");

        SchlangeO sl = new SchlangeO();
        sl.enqueue(s0);
        sl.enqueue(s1);
        sl.enqueue(s2);
        sl.enqueue(s3);

        Object o = sl.head();
        Student sNeu = (Student) o;
        sNeu.setNachname("Roepper");
        System.out.println(sNeu);
        System.out.println(sNeu.getId());
    }

    public static void main(String[] args) {
        testSchlangeO();
    }
}
