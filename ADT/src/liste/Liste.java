package liste;/*
 * Challenge 1: Abstrakte Datentypen => Nur Schnittstelle (die öffentlichen Methoden, die er bietet) muss bekannt sein,
 * nicht die
 * Implementation (wie es programmiert
 * ist)
 *    (Verkettete liste.Liste vs. Array)
 *
 * Challenge 2: Haben Sie eine Idee, wie Sie auf die Überprüfungen auf head == null verzichten können?
 *
 * Challenge 3: DVK
 */

import queue.Item;

/*
 * Desiderata:
 * ✓) get(int index) => T | Element an einer bestimmten Stelle zurückgeben
 * ✓) deleteAt(int index) => T
 * ✓) size() => Größe der liste.Liste
 * 5) insert(int index, T data)
 * 4) set(int index, T data) überschreiben
 * 3) swap(int from, int to)
 * 7) filter() => Auswählen nach Kriterien
 * 9) indexOf(T data) => Suche nach Index von Daten
 * ------------------
 * 8) find(T data) => Suche nach Daten
 * Comperator
 * ------------------
 *
 * 10) debug() => Zeige alle gespeicherten Elemente mit Index an:
 *     0: Anna
 *     1: Peter
 *     2: Willi
 *
 * Nice to have:
 * B) move(int from, int to)
 * 1) maxSize()
 * 2) concat(liste.Liste<T> otherList) => void | Mehrere Elemente gleichzeitig anhängen
 */
public class Liste<T> {
    private Item<T> first;

    public Liste() {
        clear();
    }

    public void clear() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        Item<T> runner = first;
        int size = 0;

        while (runner != null) {
            runner = runner.getNext();
            size += 1;
        }

        return size;
    }

    public void add(T data) {
        push(data);
    }

    public void push(T data) {
        Item newItem = new Item<T>(data);

        if (first == null) {
            first = newItem;
        } else {
            Item<T> runner = first;

            while (runner.getNext() != null) {
                runner = runner.getNext();
            }

            runner.setNext(newItem);
        }
    }

    /**
     * Entfernt das erste (vorderste) Element und gibt es zurück
     *
     * @return Das ehemals vorderste Element
     */
    public T shift() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        } else {
            var data = first.getData();
            first = first.getNext();
            return data;
        }
    }

    public T first() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        } else {
            return first.getData();
        }
    }

    public T get(int index) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Liste ist leer.");
        }

        if (index >= size()) {
            throw new IndexOutOfBoundsException(String.format("Index %d ist ungueltig (max. %d)", index, size() - 1));
        }

        Item<T> runner = first;

        for (int i = 0; i < index; i++) {
            runner = runner.getNext();
        }

        return runner.getData();
    }

    public T deleteAt(int index) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Liste ist leer.");
        }

        if (index >= size()) {
            throw new IndexOutOfBoundsException(String.format("Index %d ist ungueltig (max. %d)", index, size() - 1));
        }

        if (index == 0) {
            T data = first.getData();
            first = first.getNext();
            return data;
        } else {
            Item<T> runner = first;

            for (int i = 0; i < index-1; i++) {
                runner = runner.getNext();
            }

            T data = runner.getNext().getData();
            runner.setNext(runner.getNext().getNext());

            return data;
        }
    }
    
    public void debug() {
        System.out.format("Enthalten: %d Elemente%n", size());
        Item<T> runner = first;
        int index = 0;

        while (runner != null) {
            System.out.format("%2d: %s%n", index, runner.getData());
            runner = runner.getNext();
            index++;
        }

        // Katastrophal viel schlechter durch dauerndes Durchlaufen
        // durch size() und get()
        // for (int i = 0; i < size(); i++) {
        //     System.out.format("%2d: %s%n", i, get(i));
        // }
    }

    public T find(T search) {
        return null;
    }
}





