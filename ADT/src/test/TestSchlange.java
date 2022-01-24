package test;

import queue.SchlangeUntypisiert;

public class TestSchlange {

    private static void testEnqueue() {
        SchlangeUntypisiert s = new SchlangeUntypisiert();
        System.out.println(s.size());
        System.out.println(s.isEmpty());

        s.enqueue("Foo");
        s.enqueue("Bar");
        s.enqueue("Baz");

        System.out.println(s.size());
        System.out.println(s.isEmpty());

        String data = s.dequeue();
        System.out.println(data);

        System.out.println(s.size());
        System.out.println(s.isEmpty());
        data = s.dequeue();
        System.out.println(data);

        System.out.println(s.size());
        System.out.println(s.isEmpty());
        data = s.dequeue();
        System.out.println(data);

        System.out.println(s.size());
        System.out.println(s.isEmpty());
    }

    public static void main(String[] args) {
        testEnqueue();
    }
}
