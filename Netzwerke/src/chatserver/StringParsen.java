package net.misterk;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParsen {
    public static void obBefehl() {
        String eingabe = "!nick tom";
        if (eingabe.startsWith("!")) {
            // Befehl
            // ...
            System.out.println("Befehl erkannt");

        } else {
            // Sende eingabe an alle
            // TODO: außer sich selbst
            // server.sendToAll(eingabe)
            System.out.println("Kein Befehl erkannt");
        }
    }

    public static void welcherBefehl() {
        // Reguläre Ausdrücke (Regular Expressions, RegEx)
        String eingabe = "!sendTo David Hallo, wie geht's?";

        String patternSendTo = "^!sendTo ([A-Za-z]+) (.*)";
        String patternNick   = "^!nick ([A-Za-z]+)";
        String patternColour = "^!colour ([A-Za-z]+)";

        if (eingabe.matches(patternSendTo)) {
            // führe auf dem Server sendTo(user, message);
            System.out.println("sendTo");
        } else if (eingabe.matches(patternNick)) {
            // führe auf dem Server renameUser(user, newName);
            System.out.println("nickname");
        } else if (eingabe.matches(patternColour)) {
            // ändere im Client die Farbe auf "colour"
            System.out.println("Farbe");
        } else {
            // sende die Eingabe an alle
            System.out.println("Nur Nachricht");
        }

    }

    public static void parsenKomplett() {
        // Reguläre Ausdrücke (Regular Expressions, RegEx)
        // String eingabe = "!sendTo David Hallo, wie geht's?";
        // String eingabe = "!nick Goliath";
        String eingabe = "!colour cyan";

        Pattern patternSendTo = Pattern.compile("^!sendTo ([A-Za-z]+) (.*)");
        Pattern patternNick   = Pattern.compile("^!nick ([A-Za-z]+)");
        Pattern patternColour = Pattern.compile("^!colour ([A-Za-z]+)");

        Matcher matcherSendTo = patternSendTo.matcher(eingabe);
        Matcher matcherNick =   patternNick.matcher(eingabe);
        Matcher matcherColour = patternColour.matcher(eingabe);

        if (matcherSendTo.find()) {
            // führe auf dem Server sendTo(user, message);
            String userName = matcherSendTo.group(1);
            String message = matcherSendTo.group(2);
            System.out.println("sendTo " + userName + ", message: " + message);
        } else if (matcherNick.find()) {
            // führe auf dem Server renameUser(user, newName);
            String newName = matcherNick.group(1);
            System.out.println("rename user to " + newName);
        } else if (matcherColour.find()) {
            // ändere im Client die Farbe auf "colour"
            String colour = matcherColour.group(1);
            System.out.println("change colour to " + colour);
        } else {
            // sende die Eingabe an alle
            System.out.println("Nur Nachricht");
        }
    }

    public static void main(String[] args) {
        // obBefehl();
        // welcherBefehl();
        parsenKomplett();
    }

}
