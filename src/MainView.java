import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

public class MainView extends JFrame {

    private static int i = 0;
    private static boolean flipped;
    private static DeckModel myDeck;
    private static Card curr;

    public JPanel panelMain;
    private JButton restudyButton;
    private JButton discardButton;
    private JScrollPane notesListScroll;
    private JTextArea notesTextArea;
    private JButton cardFlipButton;
    private JButton addNoteButton;
    private JTextField notesTextField;

    public MainView(DeckModel deck) {



        this.myDeck = deck;
        newCard();

        /*
        while (!myDeck.cards.isEmpty()) {
            for (int i = 0; i < myDeck.cards.size(); i++) {

                boolean keepStudying = true;



                System.out.println(curr.getSide1());

                while (keepStudying) {


                    /*

                    System.out.println("Flip card: F, Discard: D, Restudy: R, New note: N");

                    switch (Character.toUpperCase(input)) {
                        case 'F':

                            break;
                        case 'D':

                        case 'R':
                            keepStudying = false;
                            break;
                        case 'N':
                            curr.printNotes();
                            scan.nextLine();
                            curr.newNote(scan.nextLine());
                            break;
                    }*/

        cardFlipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flipped = (!flipped);
                String text = (flipped) ? curr.getSide2() : curr.getSide1();
                cardFlipButton.setText(text);
            }
        });

        discardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                myDeck.discardedCards.add(curr);
                myDeck.cards.remove(0);

                if (myDeck.cards.isEmpty()) {
                    nextView();
                }
                newCard();
            }
        });

        restudyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myDeck.cards.add(curr);
                myDeck.cards.remove(0);
                newCard();
            }
        });

        notesTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        notesTextArea.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
            }
        });

        addNoteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }

    public void newCard() {
        flipped = false;
        i++;
        curr = myDeck.cards.get(0);
        this.cardFlipButton.setText(curr.getSide1());
        this.notesTextArea.setText("Text testing card " + i);
    }

    public void nextView() {
        EndView view = new EndView();
        view.setContentPane(view.panelMain2);
        view.setTitle("Finished");
        view.setSize(600, 400);
        view.setVisible(true);
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }
}
