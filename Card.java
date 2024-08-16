public class Card {
    private String color;
    private int number;

    public Card(String color, int number) {
        this.color = color;
        this.number = number;
    }

    public boolean canPlayOn(Card card) {
        return this.color.equals(card.color) || this.number == card.number;
    }

    public String getColor() {
        return color;
    }

    public int getNumber() {
        return number;
    }
}
