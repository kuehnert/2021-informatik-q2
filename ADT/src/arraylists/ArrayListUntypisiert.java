package arraylists;

import java.util.ArrayList;

public class ArrayListUntypisiert {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        // list.add("Daniel");
        list.add(7);
        // list.add(new Date(2004, 9, 1));
        list.add(3.141);
        // list.set(0, "Superdaniel");

        int summe = 0; // int <-> Integer: autoboxing

        for (Object element : list) {
            if (element instanceof Integer) {
                summe = summe + (Integer) element;
                System.out.println(element);
            }
        }
        System.out.println("Summe: " + summe);
    }
}
