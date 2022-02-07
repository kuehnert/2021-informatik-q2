package arraylists;

import java.util.ArrayList;

public class ArrayListTypisiert {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<String> list2 = new ArrayList<>();

        // ArrayList<Student> list2 = new ArrayList<>();
        // list2.get(2).getVorname();

        list.add(5);
        // list.add("David"); geht nicht, da Java weiß, dass nur Integer in der liste.Liste sind
        // list.add(3.6);
        int summe = 0;
        for (Integer n : list) {
            summe = summe + n;
        }
        System.out.println();
    }
}
