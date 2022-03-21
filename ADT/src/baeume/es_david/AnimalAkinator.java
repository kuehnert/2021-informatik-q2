package baeume.es_david;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import baeume.es_david.BinBaum.Node;

public class AnimalAkinator {

    public static void main(String[] args) {
        System.out.println("Willkommen beim Tier-Akinator! Denk an ein Tier, ich werde es erraten!");
        BinBaum<String> baum = new BinBaum<>(new Node<>("Ist dein Tier ein Säugetier?", new Node<>("Huhn"),
                new Node<>("Katze")));

        Node<String> previousNode = baum.getRoot();
        Node<String> currentNode = baum.getRoot();

        boolean isRight = false;

        while (true) {
            if (currentNode.isLeaf()) {
                String animalName = currentNode.getValue();

                if (askYesNo("Ist das Tier '" + animalName + "' das richtige Tier?")) {
                    System.out.println("Ich habe das Tier erraten, es ist '" + animalName + "'!");

                    if (askYesNo("Willst du nochmal spielen?")) {
                        System.out.println("Denk an ein neues Tier, auch das werde ich erraten!");
                        previousNode = baum.getRoot();
                        currentNode = baum.getRoot();
                        continue;
                    }

                    System.out.println("Bis zum nächsten Mal!");
                    break;
                }

                String correctAnimalName = getInput("Ich bin mir nicht sicher. Welches Tier meinst du?");
                String question = getInput("Bitte gib nun eine Frage an, welche für '" + correctAnimalName + "' mit " +
                        "ja, aber für '" + animalName + "' mit nein beantwortet werden kann.");

                Node<String> questionNode = new Node<>(question, currentNode, new Node<>(correctAnimalName));
                if (isRight) {
                    previousNode.setRight(questionNode);
                } else {
                    previousNode.setLeft(questionNode);
                }

                System.out.println("Du hast mich geschlagen! Respekt!");
                if (askYesNo("Willst du nochmal spielen?")) {
                    System.out.println("Denk an ein neues Tier, dieses mal errate ich es!");
                    previousNode = baum.getRoot();
                    currentNode = baum.getRoot();
                    continue;
                }

                System.out.println("Bis zum nächsten Mal!");
                break;
            }

            previousNode = currentNode;
            if (askYesNo(currentNode.getValue())) {
                currentNode = currentNode.getRight();
                isRight = true;
            } else {
                currentNode = currentNode.getLeft();
                isRight = false;
            }
        }
    }

    private static boolean askYesNo(String question) {
        while (true) {
            String input = getInput(question + " (ja/nein)");

            if (input.equals("ja")) {
                return true;
            }
            if (input.equals("nein")) {
                return false;
            }

            System.out.println("Bitte beantworte die Frage mit 'ja' oder 'nein'!");
        }
    }

    private static String getInput(String title) {
        System.out.println(title);

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            return reader.readLine();
        } catch (IOException exception) {
            throw new IllegalStateException(exception);
        }
    }
}
