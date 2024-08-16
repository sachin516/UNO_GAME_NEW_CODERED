import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Player prathyush = new Player("Prathyush");
        Player sachhin = new Player("Sachhin");
        Player crix = new Player("Crix");
        Player mubeen = new Player("Mubeen");

        UNOGame game = new UNOGame(Arrays.asList(prathyush, sachhin, crix, mubeen));
        game.start();

        prathyush.playCard(new SkipCard("Red", 10, 1), game);
        sachhin.playCard(new ReversedCard("Blue", 11), game);
        crix.playCard(new DrawCard("Green", 12, 2), game);
    }
}
