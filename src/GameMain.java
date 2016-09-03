/**
 * Created by Robert on 14/06/2016.
 */

import java.util.Scanner;

public class GameMain {
    private Board board;
    private GameState CurrentState;
    private Seed CurrentPlayer;
    private AIPlayer AI;

    private static Scanner in = new Scanner(System.in);

    public GameMain(){
        board = new Board();
        AI = new AIPlayer();
        board.paint();
        initGame();

        do {
            playerMove(CurrentPlayer);
            board.paint();
            UpdateGame(CurrentPlayer);
            System.out.println();

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
            int row;
            int col;
            System.out.println();
            if(TheSeed == Seed.CROSS) {
                System.out.print("Player X: Enter your move (Row, col)");
                row = in.nextInt() - 1;
                col = in.nextInt() - 1;
            }
            else {
                AI.AIMove(board);
                row = AI.row;
                col = AI.col;
                System.out.println("AI chose row " + row + " and col " + col);
            }


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
            in.nextLine();
        } while(!validInput);
    }
    public static void main(String[] args){
        new GameMain();
    }
}
