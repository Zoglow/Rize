import java.io.*;
import java.util.*;

public class DeckModel {
    static String deckFile;
    static ArrayList<Card> cards = new ArrayList<>();
    static ArrayList<Card> discardedCards = new ArrayList<>();

    public DeckModel(String file) {
        this.deckFile = file;
    }

    /**
     * Populates card stack with csv data from file
     */
    public static void importCards() {
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

    public static String flipCard() {

        return null;
    }

    /**
     * Prints list of cards reviewed this session
     */
    public static void printSessionReview() {

        System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ");
        System.out.println("\nSession overview:");

        for (Card x : discardedCards) {
            System.out.println(x.getSide1() + " - " + x.getSide2());
        }

        System.out.println("\n~ ~ ~ ~ ~ ~ ~ ~ ~ ");
    }
}
