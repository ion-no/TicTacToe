package TicTacToe;

import java.util.Scanner;

public class Game {
    private Board board;
    private Player[] players;
    private int currentPlayer;

    public Game(Player p1, Player p2, int size) {
        board = new Board(size);
        players = new Player[]{p1, p2};
        currentPlayer = 0;
    }

    Scanner scanner = new Scanner(System.in);

    public void play() {
        while(true) {
            board.printBoard();
            Player activePlayer = players[currentPlayer];
        System.out.println(activePlayer.getName() + " Make your move with " + activePlayer.getSymbol());

        System.out.println("Enter row and column");
        int row = scanner.nextInt();
        int column = scanner.nextInt();

        if(!board.makeMove(row, column, activePlayer.getSymbol())) {
            System.out.println("Cell already occupied! Try again.");
            continue;
        }

        if(board.checkWinner(activePlayer.getSymbol())) {
            System.out.println("\n");
            board.printBoard();
            System.out.println("Congrats" + activePlayer.getName() + ". You win!");
            break;
        }
            currentPlayer = (currentPlayer + 1) % 2;
        }
        scanner.close();
    }
}
