import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Robert on 18/07/2016.
 */
public class AIPlayer {

    public int col;
    public int row;


    public void ReadBoard(Board board) {
        ArrayList<ArrayList<Integer>> EmptyCells = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ArrayList<Integer> SingleCell = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                if (board.cells[i][j].content == Seed.EMPTY) {
                    System.out.println("Empty space found");
                    SingleCell.add(j);
                }
            }
            EmptyCells.add(SingleCell);
        }
        System.out.print(EmptyCells);
    }

    public void AIMove(Board board){
        ReadBoard(board);
    }
}
