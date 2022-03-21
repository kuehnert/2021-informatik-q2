package baeume.es_eric;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tierspiel extends JFrame{
    private JPanel pMain;
    private JLabel lFrage;
    private JButton bJa;
    private JButton bNein;
    private JTextField tfNewQuestion;
    private JLabel lNew;
    private JTextField tfName;
    private JButton bOk;
    private JButton bReset;
    private JLabel lHead;
    private JPanel pAll;
    private Knoten<String> wurzel;
    Knoten<String> runner = null;
    private int anzahl = 0;
    public Tierspiel(){
        add(pMain);
        setSize(500, 600);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        lNew.hide();
        tfNewQuestion.hide();
        tfName.hide();
        bOk.hide();
        bReset.hide();
        Tierbaum<String> baum = new Tierbaum<String>();
        baum.add("Ist Dein Tier ein Säugetier?", baum.wurzel, null);
        lFrage.setText(baum.wurzel.getData());
        wurzel = baum.wurzel;
        runner = wurzel;
        runner.setLinks(new Knoten<String>("Lebt Dein Tier im Wasser?"));
        runner.setRechts(new Knoten<String>("Lebt Dein Tier im Wasser?"));
        runner.getLinks().setLinks(new Knoten<String>("Dein Tier ist ein Wal."));
        runner.getRechts().setLinks(new Knoten<String>("Dein Tier ist ein Fisch."));

        bJa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (runner.getLinks() == null){
                    bJa.hide();
                    bNein.hide();
                    lFrage.setText("Super, Dein Tier wurde gefunden! Es wurden " + anzahl + " Versuche benötig, um dieses spezielle Tier zu finden!");
                    bReset.setVisible(true);
                    reset();
                }
                else {
                    runner = runner.getLinks();
                    lFrage.setText(runner.getData());
                    System.out.println(runner.getData());
                    anzahl++;
                }
            }
        });
        bNein.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (runner.getRechts() == null){
                    bJa.hide();
                    bNein.hide();
                    lFrage.setVisible(false);
                    lNew.setVisible(true);
                    tfNewQuestion.setVisible(true);
                    tfName.setVisible(true);
                    bOk.setVisible(true);
                    newQuestion();
                }
                else {
                    runner = runner.getRechts();
                    lFrage.setText(runner.getData());
                    anzahl++;
                }
            }

        });
    }
    private void newQuestion(){
            bOk.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    runner.setRechts(new Knoten<String>(tfNewQuestion.getText()));
                    runner = runner.getRechts();
                    runner.setLinks(new Knoten<String>(tfName.getText()));
                    bOk.hide();
                    tfName.hide();
                    tfNewQuestion.hide();
                    lNew.hide();
                    lFrage.setVisible(true);
                    //lFrage.setFont(new Font("Algerian", Font.PLAIN, 30));
                    lFrage.setForeground(Color.MAGENTA);
                    lFrage.setText("Vielen Dank für die Eingabe!");
                    bReset.setVisible(true);
                    reset();

                }

            });
    }
    private void reset() {
        bReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runner = wurzel;
                bReset.hide();
                lFrage.setForeground(Color.BLACK);
                lFrage.setText(runner.getData());
                bJa.setVisible(true);
                bNein.setVisible(true);
                anzahl = 0;
            }
        });
    }
    public static void main(String[] args) {
        Tierspiel game = new Tierspiel();
    }
}
