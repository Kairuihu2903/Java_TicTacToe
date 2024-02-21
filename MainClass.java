import java.util.Scanner;
// MainClass.java
public class MainClass {
    public static void main(String[] args) {
        // Create players
        Scanner scanner = new Scanner(System.in);
        Player player1 = new Player('X', "Alice");
        Player player2 = new Player('O', "Bob");

        // Access player information
        System.out.println(player1.getName() + " plays as " + player1.getMark());
        System.out.println(player2.getName() + " plays as " + player2.getMark());

        TicTacToe game = new TicTacToe(4);

        while(!game.isGameOver()){
            //game.displayBoard();
            Player currentPlayer = (game.getCurrentPlayer() == 'X') ? player1 : player2;
            System.out.println(currentPlayer.getName() + "'s turn. Enter row (0-2): ");
            int row = scanner.nextInt() /* read row input */;
            System.out.println("Enter Column (0-2): ");
            int col = scanner.nextInt() /* read column input */;
            // Make the move
            game.makeMove(row, col);
        }

        if (game.checkWin('X')) {
            System.out.println(player1.getName() + " wins!");
            scanner.close();
        } else if (game.checkWin('O')) {
            System.out.println(player2.getName() + " wins!");
            scanner.close();
        } else {
            System.out.println("It's a draw!");
            scanner.close();
        }
    }
}
