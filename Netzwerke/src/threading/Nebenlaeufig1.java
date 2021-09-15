package threading;
// http://www.mathematische-basteleien.de/apfelmaennchen.htm
public class Nebenlaeufig1 {
    public static void main(String[] args) {
        System.out.println("Nebenlaeufig1 gestartet");

        Faden f1 = new Faden(1);
        Faden f2 = new Faden(2);
        f1.start();
        f2.start();

        System.out.println("Ergebnis Thread 1: " + f1.getResult());
        System.out.println("Ergebnis Thread 2: " + f2.getResult());

        try {
            f1.join();
            f2.join();
        } catch (InterruptedException e) {
        }

        System.out.println("Ergebnis Thread 1: " + f1.getResult());
        System.out.println("Ergebnis Thread 2: " + f2.getResult());

        System.out.println("Nebenlaeufig1 beendet");
    }
}

class Faden extends Thread {
    private final int number;

    public int getResult() {
        return result;
    }

    private int result = -1;

    public Faden(int number) {
        super();
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("Thread " + number + " gestartet");
        try {
            sleep(1000);
        } catch (InterruptedException e) {
        }

        result = (int) (Math.random() * 1000);
        System.out.println("Thread " + number + " beendet: " + result);
    }
}