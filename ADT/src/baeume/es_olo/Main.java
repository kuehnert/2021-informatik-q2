package baeume.es_olo;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static final String SavePath = "baumSave2.data";
    public static Baum baum = new Baum();
    static Scanner keyboard = new Scanner(System.in);


    public static void save(Serializable data, String fileName) throws Exception {
        try (ObjectOutputStream os = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)))) {
            os.writeObject(data);
        }
    }

    public static Object load(String fileName) throws Exception {
        try (ObjectInputStream is = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))) {
            return is.readObject();
        }
    }
    public static void ausgeben(){
        System.out.println(baum.ausgeben());
    }


    public static void main(String[] args) {


        Starter();

        ausgeben();

        start();

    }

    public static void Starter() {


        Node n1 = new Node("Ist dein Tier ein Säugetier?");
        Node n2 = new Node("Lebt dein Tier im Wasser?");
        Node n3 = new Node("Lebt dein Tier im Wasser?");


        Node l1 = new Node("Orca");
        Node l2 = new Node("Affe");
        Node l3 = new Node("Lachs");
        Node l4 = new Node("Adler");

        baum.addRoot(n1);
        baum.addLeft(n1, n2);
        baum.addRight(n1, n3);

        baum.addLeft(n2, l4);
        baum.addRight(n2, l3);

        baum.addLeft(n3, l2);
        baum.addRight(n3, l1);

        try{
            baum = (Baum) load(SavePath);
        }catch (Exception any){
            System.out.println("load failed...");
        }
    }

    public static void start() {
        System.out.println("\n\n\n\n");

        Node runner = baum.getRoot();
        boolean LR = true;
        int questions = 0;

        while (!runner.isLeaf()) {

            System.out.println("\n" + runner.getData());
            System.out.println("[Ja]    [Nein]\n");

            if (userInput()) {
                runner = runner.getRight();
                LR = true;
            } else {
                runner = runner.getLeft();
                LR = false;
            }
            questions ++;
        }

        System.out.println("Ist dein Tier ein " + runner.getData() + "?");
        System.out.println("[Ja]    [Nein]\n");

        if (!userInput()) {
            setNext(LR, runner);
        } else {
            System.out.println("mit " + questions + " Fragen erraten");
            System.out.println("\n Wollen sie noch eine Runde Spielen?");
            System.out.println("[Ja]    [Nein]\n");
            if (userInput()) {
                start();
            }
        }
    }

    public static boolean userInput() {

        String userInput = keyboard.nextLine();

        if (userInput.toLowerCase().contains("ja")) {
            return true;
        } else if (userInput.toLowerCase().contains("nein")){
            return false;
        } else {

            System.out.println("Es darf nur mit 'Ja' oder 'nein' geantwortet werden.");
            return userInput();
        }
    }

    public static void setNext(boolean LR, Node node) {

        System.out.println("Schade");
        System.out.println("Willst du dein Tier der Datenbank hinzufügen?");

        if(!userInput()){
            System.out.println("Schade");
            System.out.println("\n Wollen sie noch eine Runde Spielen?");
            System.out.println("[Ja]    [Nein]\n");
            if (userInput()){
                start();
            }else{
                return;
            }
            return;
        }

        System.out.println("\n was war dein Tier?");
        String newData = keyboard.nextLine();
        if (checkTier(newData)) {

            System.out.println("Bitte geben sie eine Frage ein, die dein Tier vom " + node.getData() + " unterscheidet und mit ja beantwortet wird...");
            String newQuestion = keyboard.nextLine();

            newQuestion = checkQuestion(newQuestion);


            Node newNode = new Node(newQuestion);
            Node newLeaf = new Node(newData);


            if (LR) {
                node.getRoot().setRight(newNode);
            } else {
                node.getRoot().setLeft(newNode);
            }

            newNode.setRight(newLeaf);
            newLeaf.setRoot(newNode);

            newNode.setLeft(node);
            node.setRoot(newNode);

            newNode.setRoot(node.getRoot());

            try{
                save(baum, SavePath);
                System.out.println("Saved...");
            }catch (Exception any){
                System.out.println("Save failed...");
            }


        }

        System.out.println("\n Wollen sie noch eine Runde Spielen?");
        System.out.println("[Ja]    [Nein]\n");
        if (userInput()) {
            start();
        }

    }


    public static String checkQuestion(String q) {

        if (!q.substring(q.length() - 1).equals("?")) {
            q = q + "?";
        }

        return q;
    }

    public static boolean checkTier(String tier) {
        if (baum.ausgeben().contains(tier)) {
            System.out.println("Dieses Tier gibt es schon...");
            return true;
        }


        return true;
    }

}