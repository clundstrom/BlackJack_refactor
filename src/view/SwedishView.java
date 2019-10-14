package view;

import model.Card;

public class SwedishView extends BaseView {

    public SwedishView(){
        play = 'p';
        hit = 'h';
        stand = 's';
        quit = 'q';
    }

    public void DisplayWelcomeMessage() {
        ClearConsole();
        System.out.println("Hej Black Jack Världen");
        System.out.println("----------------------");
        System.out.println("Skriv 'p' för att Spela, 'h' för nytt kort, 's' för att stanna 'q' för att avsluta\n");
    }

    public void DisplayCard(Card a_card) {
        if (a_card.GetColor() == Card.Color.Hidden) {
            System.out.println("Dolt Kort");
        } else {
            String colors[] =
                    {"Hjärter", "Spader", "Ruter", "Klöver"};
            String values[] =
                    {"två", "tre", "fyra", "fem", "sex", "sju", "åtta", "nio", "tio", "knekt", "dam", "kung", "ess"};
            System.out.println("" + colors[a_card.GetColor().ordinal()] + " " + values[a_card.GetValue().ordinal()]);
        }
    }

    public void DisplayPlayerHand(Iterable<Card> a_hand, int a_score) {
        DisplayHand("Spelare", a_hand, a_score);
    }

    public void DisplayDealerHand(Iterable<Card> a_hand, int a_score) {
        DisplayHand("Croupier", a_hand, a_score);
    }

    public void DisplayGameOver(boolean a_dealerIsWinner) {
        System.out.println("Slut: ");
        if (a_dealerIsWinner) {
            System.out.println("Croupiern Vann!");
        } else {
            System.out.println("Du vann!");
        }
    }

    private void DisplayHand(String a_name, Iterable<Card> a_hand, int a_score) {
        System.out.println(a_name + " Har: " + a_score);
        for (Card c : a_hand) {
            DisplayCard(c);
        }
        System.out.println("Poäng: " + a_score);
        System.out.println("");
    }
}
