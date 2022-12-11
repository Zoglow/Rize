import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView extends JFrame {

    private static Deck myDeck;

    public JPanel panelMain;
    private JButton restudyButton;
    private JButton discardButton;
    private JScrollPane notesListScroll;
    private JButton cardFlipButton;
    private JButton addNoteButton;
    private JTextField notesTextField;

    private DefaultListModel listModel;
    private JList notesList;

    public MainView(Deck deck) {

        this.myDeck = deck;
        listModel = new DefaultListModel();
        notesList.setModel(listModel);

        newCard();

        /**
         * Runs flipCard action on the current card being reviewed and displays the String value for the new side facing up
         */
        cardFlipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardFlipButton.setText(myDeck.getCurr().flipCard());
            }
        });

        /**
         * Runs discardCard action on the current card being reviewed, and sends the user to either the next card or the end screen if there are no more cards to review
         */
        discardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                myDeck.discardCard();

                if (myDeck.getCards().isEmpty()) {
                    nextView();
                } else {
                    newCard();
                }
            }
        });

        /**
         * Runs the restudyCard action on the current card being reviewed, and retrieves new card to be displayed
         */
        restudyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myDeck.restudyCard();
                newCard();
            }
        });

        /**
         * Runs the addNote action on the current card being reviewed using the text that the user inputs, and updates the GUI with the new notes
         */
        addNoteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!notesTextField.getText().isEmpty()) {
                    myDeck.getCurr().addNote(notesTextField.getText());
                    notesTextField.setText("");
                }

                updateNotes();
            }
        });

    }

    /**
     * Updates GUI to display new card along with its notes
     */
    public void newCard() {
        myDeck.newCard();
        this.cardFlipButton.setText(myDeck.getCurr().getSide1());
        updateNotes();
    }

    /**
     * Updates GUI to display all the current card's notes
     */
    public void updateNotes() {

        this.listModel.clear();

        for (String note: myDeck.getCurr().getNotes()) {
            this.listModel.addElement(note);
        }

    }

    /**
     * Displays the end view and disposes of deck view
     */
    public void nextView() {
        EndView view = new EndView();
        view.setContentPane(view.panelMain2);
        view.setTitle("Rize App");
        view.setSize(600, 400);
        view.setVisible(true);
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }
}
