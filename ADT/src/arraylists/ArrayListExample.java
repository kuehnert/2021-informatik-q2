package arraylists;

import java.util.ArrayList;

public class ArrayListExample {
    String[] sArray;
    ArrayList sList;

    public ArrayListExample() {
        // Array
        sArray = new String[10];
        sArray[0] = "Daniel";
        sArray[1] = "Julius";
        sArray[2] = "Leon";
        for (String student: sArray) {
            System.out.println("Schüler " + student);
        }

        // ArrayList
        sList = new ArrayList();
        sList.add("Daniel");
        sList.add("Julius");
        sList.add("Leon");
        sList.add("Frikadelle");
        sList.add("Isabel");
        sList.add("Jonas");
        sList.add("Frikadelle");
        sList.add("Fabian");
        for (Object student : sList) {
            System.out.println("Schüler aus liste.Liste: " + student);
        }

        sList.remove("Frikadelle");
        for (Object student : sList) {
            System.out.println("Schüler aus liste.Liste: " + student);
        }

        sList.remove("Frikadelle");
        for (Object student : sList) {
            System.out.println("Schüler aus liste.Liste: " + student);
        }
    }

    public static void main(String[] args) {
        new ArrayListExample();
    }
}
