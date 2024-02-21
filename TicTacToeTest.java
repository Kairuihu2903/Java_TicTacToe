import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {
    private TicTacToe game;

    @BeforeEach
    public void setUp() {
        game = new TicTacToe();
    }

    @Test
    public void testInitialBoard() {
        // Verify that the board is initialized correctly
        char[][] expectedBoard = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        assertArrayEquals(expectedBoard, game.getBoard());
    }

    @Test
    public void testMakeValidMove() {
        // Make a valid move and verify that the board updates correctly
        game.makeMove(0, 0); // Player O moves
        char[][] expectedBoard = {{'O', ' ', ' '}, {' ', ' ', ' ' }, {' ', ' ', ' '}};
        assertArrayEquals(expectedBoard, game.getBoard());
    }

    @Test
    public void testMakeInvalidMove() {
        // Attempt to make an invalid move and verify that it's rejected
        assertFalse(game.makeMove(5, 5)); // Player X moves
    }

    @Test
    public void testCheckWinHorizontal() {
        // Set up a winning scenario (horizontal win) and verify that it's detected
        game.makeMove(0, 0); // O
        game.makeMove(1, 0); // X
        game.makeMove(0, 1); // O
        game.makeMove(1, 1); // X
        game.makeMove(0, 2); // O (wins)
        assertTrue(game.checkWin('O'));
    }

    @Test
    public void testCheckDraw() {
        // Fill the board without a win and verify that it's a draw
        game.makeMove(0, 0); // O
        game.makeMove(0, 1); // X
        game.makeMove(0, 2); // O
        game.makeMove(1, 1); // X
        game.makeMove(1, 0); // O
        game.makeMove(1, 2); // X
        game.makeMove(2, 1); // O
        game.makeMove(2, 0); // X
        assertFalse(game.isGameOver()); // Game should not be over yet
        game.makeMove(2, 2); // O (draw)
        game.displayBoard();
        assertTrue(game.isGameOver()); // Game is a draw
    }
}