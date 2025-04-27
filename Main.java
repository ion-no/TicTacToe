package TicTacToe;

public class Main {
    // Main class remains here for program entry point.
    public static void main(String[] args) {
        Player p1 = new Player("Sri", 'X');
        Player p2 = new Player("Ram", 'O');
        Game game = new Game(p1, p2, 3);

        game.play();
    }
}
