import java.io.*;
import java.util.*;

public class Deck {
    private String deckFile;
    private ArrayList<Card> cards = new ArrayList<>();
    private ArrayList<Card> discardedCards = new ArrayList<>();
    private Card curr;

    public Deck(String file) {
        this.deckFile = file;
        importCards();
        curr = cards.get(0);
    }

    public void importCards() {
        String front;
        String back;

        try {
            File cardFile = new File(deckFile);
            Scanner readCards = new Scanner(cardFile);
            readCards.useDelimiter(",");

            while (readCards.hasNextLine()) {
                front = readCards.next();
                back = readCards.next();
                readCards.nextLine();

                cards.add(new Card(front, back));
            }
        } catch (FileNotFoundException e) {
            System.out.println("There is no file with that name.\n");
        } catch (InputMismatchException m) {
            System.out.println("The file did not contain valid data.");
        }
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public Card getCurr() {
        return curr;
    }

    /**
     * Populates card stack with csv data from file
     */


    public void restudyCard() {
        cards.add(curr);
        cards.remove(0);
    }

    public void discardCard() {
        discardedCards.add(curr);
        cards.remove(0);
    }

    public void newCard() {
        curr.setNotFlipped();
        curr = cards.get(0);
    }

    /**
     * Prints list of cards reviewed this session
     */
    public void printSessionReview() {

        System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ");
        System.out.println("\nSession overview:");

        for (Card x : discardedCards) {
            System.out.println(x.getSide1() + " - " + x.getSide2());
        }

        System.out.println("\n~ ~ ~ ~ ~ ~ ~ ~ ~ ");
    }
}
