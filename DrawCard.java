public class DrawCard extends Card {
    private int drawAmount;

    public DrawCard(String color, int number, int drawAmount) {
        super(color, number);
        this.drawAmount = drawAmount;
    }

    public void applyDrawEffect(Player nextPlayer, Deck deck) {
        System.out.println("Draw card played! " + nextPlayer.getName() + " must draw " + drawAmount + " card(s).");
        for (int i = 0; i < drawAmount; i++) {
            nextPlayer.drawCard(deck);
        }
    }
}
