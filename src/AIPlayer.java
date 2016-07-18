/**
 * Created by Robert on 18/07/2016.
 */
public class AIPlayer {

    public int col;
    public int row;

    public void ReadBoard(Board board) {
        outerloop:
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.cells[i][j].content == Seed.EMPTY) {
                    System.out.println("Empty space found");
                    row = i;
                    col = j;
                    break outerloop;
                }
            }
        }
    }

    public void AIMove(Board board){
        ReadBoard(board);
    }
}
