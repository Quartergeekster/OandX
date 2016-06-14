/**
 * Created by Robert on 14/06/2016.
 */
public class Board {
    public static final int ROWS = 3;
    public static final int COLS = 3;

    Cell[][] cells;
    int currentRow, currentCol;

    public Board() {
        cells = new Cell[ROWS][COLS];
        for(int row = 0; row < ROWS; ++row){
            for(int col = 0; col < COLS;++col){
                cells[row][col] = new Cell(row, col);
            }
        }
    }

    public void init(){
        for(int row = 0; row < ROWS; ++row){
            for(int col = 0; col < COLS;++col){
                cells[row][col].clear();
            }
        }
    }

    public boolean isDraw(){
        for(int row = 0; row < ROWS; ++row){
            for(int col = 0; col < COLS;++col){
                if(cells[row][col].content == Seed.EMPTY)
                {
                    return false;
                }
            }
        }
        return true;
    }
}
