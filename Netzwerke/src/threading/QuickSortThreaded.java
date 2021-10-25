package threading;

import java.util.ArrayList;
import java.util.List;

public class QuickSortThreaded {
    private int[] array;
    private List<QuickSortThread> threads = new ArrayList<>();

    public QuickSortThreaded() {
        array = new int[10_000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 1_000_000);
        }
        var thread = new QuickSortThread(this, 0, array.length-1);
        threads.add(thread);
        thread.start();


    }

    public static void main(String[] args) {
        new QuickSortThreaded();
    }

    public int getValue(int i) {
        return array[i];
    }

    public void setValue(int i, int v) {
        array[i] = v;
    }

    public void swapValues(int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    public synchronized void addThread(QuickSortThread t) {
        threads.add(t);
    }
}

class QuickSortThread extends Thread {
    QuickSortThreaded main;
    int left, right, pivotValue, pivotIndex;

    public QuickSortThread(QuickSortThreaded main, int left, int right) {
        this.main = main;
        this.left = left;
        this.right = right;
    }

    private int partition(int l, int r) {
        int oLeft = left = l;
        int oRight = right = r;
        pivotValue = main.getValue(pivotIndex);

        // Pivot-Element ans Ende verschieben
        main.swapValues(pivotIndex, right);

        for (int i = oLeft; i < oRight; i++) {
            if (main.getValue(i) <= pivotValue) {
                main.swapValues(left, i);
                left++;
            }
        }

        // Pivot-Element an die richtige Position kopieren
        main.swapValues(oRight, left);

        // neue Pivot-Position zurückgeben
        return left;
    }

    @Override
    public void run() {
        pivotIndex = (left + right) / 2;

        if (right > left) {
            int pivot = partition(left, right);
            var t1 = new QuickSortThread(main, left, pivot - 1);
            main.addThread(t1);
            t1.run();

            var t2 = new QuickSortThread(main, pivot + 1, right);
            main.addThread(t2);
            t2.run();
        }
    }
}
