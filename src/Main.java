import java.util.*;

public class Main {
    public static void main(String[] args) {

        Card testCard = new Card("안녕", "Hi");
        Scanner scan = new Scanner(System.in);
        boolean keepStudying = true;
        boolean flipped = false;
        System.out.println(testCard.getSide1());

        while (keepStudying) {
            System.out.println("Flip card: F, Discard: D, Restudy: R");
            char input = scan.next().charAt(0);

            if ((input == 'F') || (input == 'f')) {
                flipped = (!flipped);
                String text = (flipped) ? testCard.getSide2() : testCard.getSide1();
                System.out.println(text);
            } else if ((input == 'D')||(input == 'd')) {
                keepStudying = false;
                
            }
        }

    }
}