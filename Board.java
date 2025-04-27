package TicTacToe;

public class Board {
    private Cell[][] board;
    private int size;

    public Board(int size) {
        this.size = size;
        board = new Cell[size][size];
        initializeBoard();
    }

    private void initializeBoard() {
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++)
                board[i][j] = new Cell();
        }
    }

    public boolean makeMove(int row, int column, char value) {
        if(board[row][column].isEmpty()) {
            board[row][column].setValue(value);
            return true;
        }
        return false;
    }

    public void printBoard() {
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                System.out.print(board[i][j].getValue() + " |");
            }
            System.out.print("\n");
        }
    }

    public boolean isFull() {
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(board[i][j].isEmpty())
                    return false;
            }
        }
        return true;
    }

    public boolean checkWinner(char symbol) {
        //row wise winner
        for(int i = 0; i < size; i++) {
            int k = 0;
            for(int j = 0; j < size; j++) {
                if(board[i][j].getValue() == symbol)  k++;
                else    break;
            }
            if(k == size)   return true;
        }

        //column wise winner check
        for(int i = 0; i < size; i++) {
            int k = 0;
            for(int j = 0; j < size; j++) {
                if(board[j][i].getValue() == symbol)  k++;
                else    break;
            }
            if(k == size)   return true;
        }

        //left diagonal wise winner check
        int k = 0;
        for(int i = 0; i < size; i++) {
            if(board[i][i].getValue() == symbol)
                k++;
            else    
                break;
        }
        if(k == size) return true;

        //right diagonal wise winner check
        k = 0;
        for(int i = 0; i < size; i++) {
            if(board[size - i - 1][i].getValue() == symbol)
                k++;
            else    
                break;
        }
        if(k == size) return true;

        return false;
    }
}