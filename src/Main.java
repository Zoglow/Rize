import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Card> cards = new ArrayList<>();
    static ArrayList<Card> discardedCards = new ArrayList<>();

    /**
     * Populates card stack with csv data from file
     */
    public static void importCards() {
        String front;
        String back;

        try {
            File cardFile = new File("rizeCards.csv");
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

    public static void main(String[] args) {
        importCards();
        Scanner scan = new Scanner(System.in);

        while (!cards.isEmpty()) {
            for (int i = 0; i < cards.size(); i++) {

                boolean keepStudying = true;
                boolean flipped = false;

                Card curr = cards.get(i);
                System.out.println(curr.getSide1());

                while (keepStudying) {
                    System.out.println("Flip card: F, Discard: D, Restudy: R, New note: N");
                    char input = scan.next().charAt(0);

                    switch (Character.toUpperCase(input)) {
                        case 'F':
                            flipped = (!flipped);
                            String text = (flipped) ? curr.getSide2() : curr.getSide1();
                            System.out.println(text);
                            break;
                        case 'D':
                            discardedCards.add(curr);
                            cards.remove(i);
                            i--;
                        case 'R':
                            keepStudying = false;
                            break;
                        case 'N':
                            curr.printNotes();
                            scan.nextLine();
                            curr.newNote(scan.nextLine());
                            break;
                    }
                }
            }
        }

        printSessionReview();
    }
}