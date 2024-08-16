public class ReversedCard extends Card {
    public ReversedCard(String color, int number) {
        super(color, number);
    }

    public void applyReverseEffect(UNOGame game) {
        game.reverseDirection();  // Correct method name
        System.out.println("Reverse card played! The direction of play has been reversed.");
    }
}
