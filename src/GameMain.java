/**
 * Created by Robert on 14/06/2016.
 */

import java.util.Scanner;

public class GameMain {
    private Board board;
    private GameState CurrentState;
    private Seed CurrentPlayer;

    private static Scanner in = new Scanner(System.in);

    public GameMain(){
        board = new Board();

        initGame();

        do {
            playerMove(CurrentPlayer);
            board.paint();
            UpdateGame(CurrentPlayer);

            if(CurrentState == GameState.X_WON){
                System.out.println("X has won.");
            }
            else if(CurrentState == GameState.O_WON){
                System.out.println("O has won.");
            }
            else if(CurrentState == GameState.DRAW){
                System.out.println("It's a draw.");
            }

            CurrentPlayer = (CurrentPlayer == Seed.CROSS) ? Seed.NOUGHT : Seed.CROSS;
        }
        while(CurrentState == GameState.PLAYING);
    }

    public void initGame(){
        board.init();
        CurrentPlayer = Seed.CROSS;
        CurrentState = GameState.PLAYING;
    }

    public void UpdateGame(Seed TheSeed){
        if(board.hasWon(TheSeed)){
            CurrentState = (TheSeed == Seed.CROSS) ? GameState.X_WON : GameState.O_WON;
        }
        else if(board.isDraw()){
            CurrentState = GameState.DRAW;
        }
    }

    public void playerMove(Seed TheSeed){
        boolean validInput = false;
        do {
            if(TheSeed == Seed.CROSS) {
                System.out.print("Player X: Enter your move (Row, col)");
            }
            else {
                System.out.print("Player O: Enter your move(Row, col)");
            }

            int row = in.nextInt() - 1;
            int col = in.nextInt() - 1;

            if (row >= 0 && row < Board.ROWS && col >=0 && col < Board.COLS && board.cells[row][col].content == Seed.EMPTY)
            {
                board.cells[row][col].content = TheSeed;
                board.currentRow = row;
                board.currentCol = col;
                validInput = true;
            }

            else {
                System.out.println("This move is invalid, try again.");
            }
        } while(!validInput);
    }
}
