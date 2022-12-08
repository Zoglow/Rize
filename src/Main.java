import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        Deck deck = new Deck("rizeCards.csv");
        MainView view = new MainView(deck);
        view.setContentPane(view.panelMain);
        view.setTitle("Test Title");
        view.setSize(600, 400);
        view.setVisible(true);
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*
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
        */

    }
}