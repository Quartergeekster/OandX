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
        boolean MoveMade = false;
        while(!MoveMade) {
            MoveMade = CheckForHorizontal(OpenCells, board);
            if (MoveMade) {
                System.out.println("Loop broken");
                break;
            }
            MoveMade = CheckForLines(OpenCells, board);
            if (MoveMade) {
                break;
            }
            SelectRandomCell(OpenCells);
            System.out.println("Loop not broken");
            MoveMade = true;
        }
    }

    private boolean CheckForLines(ArrayList<ArrayList<Integer>> OpenCells, Board board) //Checks for potential losses in vertical lines
    {
        for(int i = 0; i < 3; i++)
        {
            if(OpenCells.get(0).indexOf(i) == -1 && OpenCells.get(1).indexOf(i) == -1 && board.cells[0][i].content == board.cells[1][i].content) //Checks vertical cells for row 0 and 1
            {
               if(board.cells[2][i].content == Seed.EMPTY)
               {
                   row = 2;
                   col = i;
                   return true;
               }
            }
            if(OpenCells.get(1).indexOf(i) == -1 && OpenCells.get(2).indexOf(i) == -1 && board.cells[1][i].content == board.cells[2][i].content) //Checks vertical cells for rows 1 and 2
            {
                if(board.cells[0][i].content == Seed.EMPTY)
                {
                    row = 0;
                    col = i;
                    return true;
                }
            }
            if(OpenCells.get(0).indexOf(i) == -1 && OpenCells.get(2).indexOf(i) == -1 && board.cells[0][i].content == board.cells[2][i].content)
            {
                if(board.cells[1][i].content == Seed.EMPTY)
                {
                    row = 1;
                    col = i;
                    return true;
                }
            }

        }
        return false;
    }


    private boolean CheckForHorizontal(ArrayList<ArrayList<Integer>> OpenCells, Board board) //Checks for potential losses in Horizontal lines
    {
        for(int i = 0; i < 3; i++)
        {
            ArrayList<Integer> clean = new ArrayList<Integer>();
            clean.add(0); clean.add(1); clean.add(2); //Adds all possible cells to Clean
            if(OpenCells.get(i).size() == 1) //If only one open cell per row
            {
                clean.removeAll(OpenCells.get(i)); //Converts clean arraylist into arraylist of spaces taken in that row
                if(board.cells[i][clean.get(0)].content == board.cells[i][clean.get(1)].content) //If both taken cells in row are the same
                {
                    row = i;
                    col = OpenCells.get(i).get(0);
                    return true;
                }
            }
        }
        return false;
    }

    public void SelectRandomCell(ArrayList<ArrayList<Integer>> OpenCells)
    {
        int RN1;
        do{
            RN1 = (int)(Math.random()* (OpenCells.size()));
        }
        while((OpenCells.get(RN1).isEmpty()));

        //System.out.println("Left Do While");

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
