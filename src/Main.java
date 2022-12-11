import javax.swing.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Create deck with a specified csv file
        Deck deck = new Deck("rizeCards.csv");

        // Create and specify settings for GUI view
        MainView view = new MainView(deck);
        view.setContentPane(view.panelMain);
        view.setTitle("Rize App");
        view.setSize(600, 400);
        view.setVisible(true);
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}