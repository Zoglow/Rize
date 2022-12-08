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

    public String getSide1() {
        return side1;
    }
    public String getSide2() {
        return side2;
    }

/*
    public void setSide1(String side1) {
        this.side1 = side1;
    }
    public void setSide2(String side2) {
        this.side2 = side2;
    } */

    public void setNotFlipped() {
        isFlipped = false;
    }

//    public ArrayList<String> getNotes() {
//        return notes;
//    }

    public String flipCard() {
        isFlipped = (!isFlipped);
        return (isFlipped) ? side2 : side1;

    }

    public void addNote(String note) {
        notes.add(note);
    }
    
    public void printNotes() {
        System.out.println("\n~ ~ ~ Notes ~ ~ ~");
        for (String x : notes) {
            System.out.println(x);
        }
    }



}
