package queue;

public class TestSchlange {

    private static void testEnqueue() {
        Schlange s = new Schlange();
        s.enqueue("Foo");
        s.enqueue("Bar");
        s.enqueue("Baz");
    }

    public static void main(String[] args) {
        testEnqueue();
    }
}
