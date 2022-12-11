import java.io.*;
import java.util.*;

public class Deck {
    private String deckFile; // points to CSV file with card data
    private ArrayList<Card> cards = new ArrayList<>();
    private ArrayList<Card> discardedCards = new ArrayList<>();
    private Card curr;

    /**
     * Creates Deck object with cards created from the specified file
     * @param file Represents the name of the file which contains the card data
     */
    public Deck(String file) {
        this.deckFile = file;
        importCards();
        curr = cards.get(0);
    }

    /**
     * Populates cards ArrayList by reading data from a CSV file
     */
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

    /**
     * Returns cards ArrayList
     * @return cards ArrayList
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * Returns discardedCards ArrayList
     * @return discardedCards ArrayList
     */
    public ArrayList<Card> getDiscardedCards() {
        return discardedCards;
    }

    /**
     * Returns current card being reviewed
     * @return current Card
     */
    public Card getCurr() {
        return curr;
    }

    /**
     * Adds the current card to the end of the cards ArrayList and then removes it from the front
     */
    public void restudyCard() {
        cards.add(curr);
        cards.remove(0);
    }

    /**
     * Adds the current card to the discardedCards ArrayList, and removes it from the cards ArrayList
     */
    public void discardCard() {
        discardedCards.add(curr);
        cards.remove(0);
    }

    /**
     * Resets the current card to be "face down" and resets the current card variable to point to the first card in the cards ArrayList
     */
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
