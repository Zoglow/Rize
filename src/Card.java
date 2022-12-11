import java.util.ArrayList;

public class Card {
    private String side1;
    private String side2;
    private Boolean isFlipped = false;
    private ArrayList<String> notes = new ArrayList<>();

    /**
     * Constructs new card with two different sides
     * @param side1 represents the question side
     * @param side2 represents the answer side
     */
    public Card(String side1, String side2) {
        this.side1 = side1;
        this.side2 = side2;
    }

    /**
     * Gets side 1 of card
     * @return String value of side1
     */
    public String getSide1() {
        return side1;
    }

    /**
     * Gets side 2 of card
     * @return String value of side2
     */
    public String getSide2() {
        return side2;
    }

    /**
     * Sets card isFlipped Boolean to false, so that the card can be presented "face-down." Honestly unnecessary.
     */
    public void setNotFlipped() {
        isFlipped = false;
    }

    /**
     * Flips card by setting card's isFlipped Boolean to the opposite of its current value, and then returning the String value of the appropriate side of the card
     * @return String value of the side of the card that is "facing up."
     */
    public String flipCard() {
        isFlipped = (!isFlipped);
        return (isFlipped) ? side2 : side1;

    }

    /**
     * Adds the specified String to the card's notes ArrayList
     * @param note Represents the note that the user wants to add
     */
    public void addNote(String note) {
        notes.add(note);
    }

    /**
     * Gets array of notes associated with this card
     * @return the notes ArrayList
     */
    public ArrayList<String> getNotes() {
        return notes;
    }

    /**
     * Prints the notes ArrayList for this card to the console
     */
    public void printNotes() {
        System.out.println("\n~ ~ ~ Notes ~ ~ ~");
        for (String x : notes) {
            System.out.println(x);
        }
    }

}
