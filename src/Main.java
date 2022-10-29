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

    public static void main(String[] args) {
        importCards();
        Scanner scan = new Scanner(System.in);
        boolean flipped = false;

        for (int i = 0; i < cards.size(); i++) {

            boolean keepStudying = true;

            Card curr = cards.get(i);
            System.out.println(curr.getSide1());

            while (keepStudying) {
                System.out.println("Flip card: F, Discard: D, Restudy: R");
                char input = scan.next().charAt(0);

                if ((input == 'F') || (input == 'f')) {
                    flipped = (!flipped);
                    String text = (flipped) ? curr.getSide2() : curr.getSide1();
                    System.out.println(text);
                } else if ((input == 'D')||(input == 'd')) {
                    discardedCards.add(curr);
                    cards.remove(curr);
                    i--;
                    keepStudying = false;
                }
            }
        }




    }
}