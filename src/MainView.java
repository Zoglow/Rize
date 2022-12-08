import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class MainView extends JFrame {

    private static int i = 0;
    private static Deck myDeck;

    public JPanel panelMain;
    private JButton restudyButton;
    private JButton discardButton;
    private JScrollPane notesListScroll;
    private JTextArea notesTextArea;
    private JButton cardFlipButton;
    private JButton addNoteButton;
    private JTextField notesTextField;

    public MainView(Deck deck) {

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
                cardFlipButton.setText(myDeck.getCurr().flipCard());
            }
        });

        discardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                myDeck.discardCard();

                if (myDeck.getCards().isEmpty()) {
                    nextView();
                }
                newCard();
            }
        });

        restudyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myDeck.restudyCard();
                newCard();
            }
        });

        addNoteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!notesTextField.getText().isEmpty()) {
                    myDeck.getCurr().addNote(notesTextField.getText());
                    notesTextField.setText("");
                }
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



    }

    public void newCard() {
        myDeck.newCard();
        i++;
        this.cardFlipButton.setText(myDeck.getCurr().getSide1());
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
