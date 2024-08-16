import java.util.ArrayList;
import java.util.List;

public class UNOGame {
    private List<Player> players;
    private Deck deck;
    private List<Card> discardPile;
    private boolean isReversed;
    private int currentPlayerIndex;

    public UNOGame(List<Player> players) {
        this.players = players;
        this.deck = new Deck();
        this.discardPile = new ArrayList<>();
        this.isReversed = false;
        this.currentPlayerIndex = 0;
        deck.shuffle();
    }

    public void start() {
        for (Player player : players) {
            for (int i = 0; i < 7; i++) {
                player.drawCard(deck);
            }
        }
        discardPile.add(deck.draw());
        System.out.println("Game started. First card is: " + discardPile.get(0).getColor() + " " + discardPile.get(0).getNumber());

        while (!isGameOver()) {
            playTurn(players.get(currentPlayerIndex));
            currentPlayerIndex = getNextPlayerIndex(currentPlayerIndex);
        }
    }

    public void playTurn(Player player) {
        Card topCard = discardPile.get(discardPile.size() - 1);
        Card cardToPlay = null;

        for (Card card : player.getHand()) {
            if (card.canPlayOn(topCard)) {
                cardToPlay = card;
                break;
            }
        }

        if (cardToPlay != null) {
            player.playCard(cardToPlay, this);
        } else {
            player.drawCard(deck);
            System.out.println(player.getName() + " draws a card.");
        }

        if (player.hasWon()) {
            System.out.println(player.getName() + " has won the game!");
        }
    }

    public void playTurn(Player player, Card card) {
        discardPile.add(card);
        System.out.println(player.getName() + " played " + card.getColor() + " " + card.getNumber());

        if (card instanceof SkipCard) {
            int skipCount = ((SkipCard) card).applySkipEffect();
            currentPlayerIndex = skipNextPlayers(currentPlayerIndex, skipCount);
        } else if (card instanceof ReversedCard) {
            ((ReversedCard) card).applyReverseEffect(this);
        } else if (card instanceof DrawCard) {
            Player nextPlayer = players.get(getNextPlayerIndex(currentPlayerIndex));
            ((DrawCard) card).applyDrawEffect(nextPlayer, deck);
        }
    }

    public void reverseDirection() {
        isReversed = !isReversed;
    }

    private int getNextPlayerIndex(int currentIndex) {
        if (isReversed) {
            return (currentIndex - 1 + players.size()) % players.size();
        } else {
            return (currentIndex + 1) % players.size();
        }
    }

    private int skipNextPlayers(int currentIndex, int skipCount) {
        for (int i = 0; i < skipCount; i++) {
            currentIndex = getNextPlayerIndex(currentIndex);
            System.out.println(players.get(currentIndex).getName() + " is skipped!");
        }
        return getNextPlayerIndex(currentIndex);
    }

    public boolean isGameOver() {
        return players.stream().anyMatch(Player::hasWon);
    }
}
