import com.sun.org.apache.xpath.internal.operations.Bool;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Robert on 18/07/2016.
 */
public class AIPlayer {

    public int col;
    public int row;


    public ArrayList<ArrayList<Integer>> ReadBoard(Board board)  //Returns an Arraylist of Arraylists that show every empty Square
    {
        ArrayList<ArrayList<Integer>> EmptyCells = new ArrayList<>();
        for (int i = 0; i < 3; i++) { // For each Row
            ArrayList<Integer> SingleCell = new ArrayList<>();
            for (int j = 0; j < 3; j++) { //For each column
                if (board.cells[i][j].content == Seed.EMPTY) {
                    //System.out.println("Empty space found");
                    SingleCell.add(j);
                }
            }
            EmptyCells.add(SingleCell);
        }
        System.out.println(EmptyCells);
        return EmptyCells;
    }

    public void DeclareMove(ArrayList<ArrayList<Integer>> OpenCells, Board board) //Assigns values to row and col, so that a move can be made
    {
        CheckForLines(OpenCells, board);
        //SelectRandomCell(OpenCells);
    }

    private void CheckForLines(ArrayList<ArrayList<Integer>> OpenCells) //Checks for potential wins in Horizontal and vertical lines


    private void CheckForHorizontal(ArrayList<ArrayList<Integer>> OpenCells)
    {
        for(int i = 0; i < 3; i++)
        {

        }
    }

    public void SelectRandomCell(ArrayList<ArrayList<Integer>> OpenCells)
    {
        int RN1;
        do{
            //System.out.println("Started Do While");
            RN1 = (int)(Math.random()* (OpenCells.size()));
            //System.out.println("RN1 assigned");
        }
        while((OpenCells.get(RN1).isEmpty()));

        System.out.println("Left Do While");

        int RN2 = (int) (Math.random() * (OpenCells.get(RN1).size()));
        row = RN1;
        col = OpenCells.get(RN1).get(RN2);
    }

    public void AIMove(Board board) //Overall Main Program
    {
        ArrayList<ArrayList<Integer>> OpenCells = ReadBoard(board);
        DeclareMove(OpenCells, board);
    }
}
