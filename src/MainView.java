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
                } else {
                    newCard();
                }
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

                updateNotes();
            }
        });

        notesTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public void newCard() {
        myDeck.newCard();
        this.cardFlipButton.setText(myDeck.getCurr().getSide1());
        updateNotes();
    }

    public void updateNotes() {

        this.listModel.clear();

        for (String note: myDeck.getCurr().getNotes()) {
            this.listModel.addElement(note);
        }

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
