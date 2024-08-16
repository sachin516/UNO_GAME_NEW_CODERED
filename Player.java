import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public void drawCard(Deck deck) {
        hand.add(deck.draw());
    }

    public void playCard(Card card, UNOGame game) {
        if (hand.contains(card)) {
            hand.remove(card);
            game.playTurn(this, card);
        }
    }

    public boolean hasWon() {
        return hand.isEmpty();
    }

    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }
}
