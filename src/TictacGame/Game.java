package TictacGame;

import java.util.Scanner;

public class Game {
    private Board board;
    private Player player1;
    private Player player2;

    public Game(int rows, int cols) {
        board = new Board(rows, cols);
        player1 = new Player("Player 1", 'X');
        player2 = new Player("Player 2", 'O');
    }

    public void start() {
        Player currentPlayer = player1;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            board.printBoard();
            System.out.println(currentPlayer.getName() + "'s turn. Enter row and column (0, 1, or 2): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (board.makeMove(row, col, currentPlayer.getSymbol())) {
                if (board.checkWinner(currentPlayer.getSymbol())) {
                    board.printBoard();
                    System.out.println(currentPlayer.getName() + " wins!");
                    break;
                } else if (board.isFull()) {
                    board.printBoard();
                    System.out.println("It's a tie!");
                    break;
                } else {
                    currentPlayer = (currentPlayer == player1) ? player2 : player1;
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    public static void main(String[] args) {
        Game game = new Game(3, 3);
        game.start();
    }
}
