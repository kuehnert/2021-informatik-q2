/*
 * Challenge 1: Abstrakte Datentypen => Nur Schnittstelle (die öffentlichen Methoden, die er bietet) muss bekannt sein,
 * nicht die
 * Implementation (wie es programmiert
 * ist)
 *    (Verkettete Liste vs. Array)
 *
 * Challenge 2: Haben Sie eine Idee, wie Sie auf die Überprüfungen auf head == null verzichten können?
 *
 * Challenge 3: DVK
 */

/*
 * Desiderata:
 * 1) concat(Liste<T> otherList) => void | Mehrere Elemente gleichzeitig anhängen
 * 2) get(int index) => T | Element an einer bestimmten Stelle zurückgeben
 * 3) deleteAt(int index) => T | void
 *    // T data = list.deleteAt(5)
 *    // list.deleteAt(5) => Rückgabewert wird verworfen
 * 4) move(int from, int to)
 * 5) set(int index, T data) überschreiben
 * 6) insert(int index, T data)
 * 7) size() => Größe der Liste
 * 8) filter() => Auswählen nach Kriterien
 * 9) get(T data) => Suche nach Daten
 * 10) indexOf(T data) => Suche nach Index von Daten
 *
 * Nice to have:
 * 1) maxSize()
 */
public class Liste {

}
