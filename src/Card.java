import java.util.ArrayList;

public class Card {
    private String side1;
    private String side2;
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

    public String getSide1() {
        return side1;
    }

    public void setSide1(String side1) {
        this.side1 = side1;
    }

    public String getSide2() {
        return side2;
    }

    public void setSide2(String side2) {
        this.side2 = side2;
    }

    public void printNotes() {
        System.out.println("\n~ ~ ~ Notes ~ ~ ~");
        for (String x : notes) {
            System.out.println(x);
        }
    }

    public void newNote(String note) {
        notes.add(note);
    }

}
