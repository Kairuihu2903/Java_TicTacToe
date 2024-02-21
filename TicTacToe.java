import java.util.Arrays;

public class TicTacToe {
    private char[][] board;
    private char currentplayer;
    private int boardsize;
    private int movesnum;
    
    //constructor
    public TicTacToe(int size){
     // Initialize the board and set the starting player
        boardsize = size;
        currentplayer = 'O';
        board = new char[boardsize][boardsize];
        for (int i = 0; i < boardsize; i++) {
            for (int j = 0; j < boardsize; j++) {
                board[i][j] = '-'; // empty cell
            }
        }
        movesnum = 0;
    }

    public char getCurrentPlayer(){
        return currentplayer;
    }
    public char[][] getBoard(){
        return board;
    }

  // Method to display the current board
    public void displayBoard(){

        for (int i = 0; i < board.length; i++) {
            // Iterate through columns
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();

        }
    }
    // Method to check if the game is (win or draw)
    public boolean isGameOver(){
        // check for a win or draw condition
        displayBoard();
        int max = boardsize * boardsize;
        if (movesnum == max) {
            return true; 
        }
        // less then possible moves check
        if (checkWin('O') || checkWin('X')) {
            return true; // Game over if there's a winner
        }
        // Check if the board is full
        return false; 
    }

    // Method to handle a players move
    public boolean makeMove(int row, int col){
        // check validmove
        //place the current players mark on the board at the specified position
        //switch to the next player
        if (checkmove(row, col)){
            board[row][col] = currentplayer;
            movesnum++;
            currentplayer = (currentplayer == 'O') ? 'X' : 'O'; // switch player
            return true;
        }
        else{
            System.out.println("Invalid move");
            return false;
        }




    }
    /* 
    public char switchPlayer(){
        if (currentplayer == 'O'){
            return 'X';
        }
        else
            return 'O';
    }
    */

    //checks horizantal win
    public boolean checksameHorizantal(int row, char type){
        char[] win = new char[boardsize];
        Arrays.fill(win, type);
        char[] curr = new char[boardsize];
        for(int i = 0; i < boardsize; i++)
        {
            curr[i] = board[row][i];
        }
        return Arrays.equals(curr, win);
    }
    //checks vertical win 
    public boolean checksameVertical(int column, char type){
        char[] win = new char[boardsize];
        Arrays.fill(win, type);
        char[] curr = new char[boardsize];
        for(int i = 0; i < boardsize; i++){
            curr[i] = board[i][column];
        }
        return Arrays.equals(curr, win);
    }
    // ToDo
    public boolean checkCross(char type){
        char[] win = new char[boardsize];
        Arrays.fill(win, type);
        char[] curr_cross_one = new char[boardsize];
        char[] curr_cross_two = new char[boardsize];
        for(int i = 0; i < boardsize; i++)
        {
            curr_cross_one[i] = board[i][i];
            curr_cross_two[i] = board[(boardsize-1)-i][i];
        }
        if(Arrays.equals(curr_cross_one,win) || Arrays.equals(curr_cross_two,win))
        {
            return true;
        }

        return false;
    }
    //checks win
    public boolean checkWin(char XorO){
        for(int i = 0; i < boardsize; i++){
            if(checksameHorizantal(i,XorO)){
                return true;
            }
            if(checksameVertical(i,XorO)){
                return true;
            }
            if(checkCross(XorO))
            {
                return true;
            }
        }
        return false;
    }
    //checks if move is valid
    public boolean checkmove(int row, int col){
        if (row < 0 || row >= boardsize || col < 0 || col >= boardsize || board[row][col] != '-')
        {
            return false;
        }
        return true;
    }

}
