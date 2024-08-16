public class SkipCard extends Card {
    private int skipCount;

    public SkipCard(String color, int number, int skipCount) {
        super(color, number);
        this.skipCount = skipCount;
    }

    public int applySkipEffect() {
        System.out.println("Skip card played! The next " + skipCount + " player(s) will be skipped.");
        return skipCount;
    }
}
