/**
 * Created by Robert on 14/06/2016.
 */
public class Cell {
    Seed content;
    int row, col;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        clear();
    }

    public void clear(){
        content = Seed.EMPTY;
    }

    public void paint(){
        switch(content){
            case CROSS:
                system.out.print(" X ");
                break;
            case NOUGHT:
                system.out.print(" O ");
                break;
            case EMPTY:
                system.out.print("   ");
                break;
        }
    }
}
