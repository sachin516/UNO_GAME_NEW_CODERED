import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
        initializeDeck();
    }

    private void initializeDeck() {
        String[] colors = {"Red", "Blue", "Green", "Yellow"};
        for (String color : colors) {
            for (int i = 1; i <= 9; i++) {
                cards.add(new Card(color, i));
                cards.add(new SkipCard(color, 10, 1));
                cards.add(new ReversedCard(color, 11));
                cards.add(new DrawCard(color, 12, 2));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card draw() {
        return cards.remove(0);
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }
}
