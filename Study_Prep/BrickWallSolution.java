package Study_Prep;

import java.util.LinkedList;

/**
 * @Author: Paul Jett
 * Write a function such that given this 2d array and a coordinate (ex: [1,1])
 * all of the bricks that are no longer connected by removing the brick at
 * the coordinates position, hit the ground (are printed out)
 *
 * ex: 2. //1 represents a brick
 *
 *              3 [[1, 1, 1, 1]
 *              2 [0, 1, 0, 1]
 *              1 [0, 1, 0, 0]
 *              0 [0, 1, 0, 0]]
 *              yx 0  1  2  3
 *
 * if (1,1) was removed print: [(0,3), (1,3), (2,3), (3,3), (3,2), (1,2)]
 *
 * Assumptions: 1) edge case where if no brick is in the base
 * row (floating wall), then we would break from the function.
 *
 * 2) the 2d array would be given where row 0 is represented as the base
 * meaning the above example would be flipped to:
 *
 *            {{0, 1, 0, 0},
 *             {0, 1, 0, 0},
 *             {0, 1, 0, 1},
 *             {1, 1, 1, 1}};
 *
 * 3) for simplicity, I'm going to assume the bricks can't be stacked
 * to create an arch, where two coordinates at the base exist apart from one another:
 *
 *            {{0, 1, 0, 1},
 *             {0, 1, 0, 1},
 *             {0, 1, 0, 1},
 *             {1, 1, 1, 1}};
 *
 * Since removing a brick here might result in the wall being able to stand or potentially fall
 */

public class BrickWallSolution {

    public static void main(String[] args) {

        //flipped y-values (row) so the base row would be 0 instead of max # of rows
        int[][] brickWall = {{0, 1, 0, 0},
                             {0, 1, 0, 0},
                             {0, 1, 0, 1},
                             {1, 1, 1, 1}};

        int[] removedB = new int[2];
        removedB[0] = 1; //row
        removedB[1] = 1; //col

        fallingBricks(brickWall, removedB); //[(1,2)(1,3)(0,3)(2,3)(3,3)(3,2)]
    }

    /**
     * Ultimately creates a list of coordinates where chained bricks are creating a wall
     * then prints out a list of coordinates of the bricks that would fall if the removed
     * brick was taken away from the 2d representation of a wall
     * @param grid 2d array of grid representing bricks
     * @param removedBrick the brick removed (changed to a 0) from the wall
     */
    public static void fallingBricks(int[][] grid, int[] removedBrick) {
        //check for a floating wall and starting point
        Coordinate start = new Coordinate();
        for(int i = 0; i < grid.length; i++) {
            if(grid[0][i] == 1) { //if a brick exists in row 0
                start.setCol(i);
                start.setRow(0);
                break;
            }
        }
        if(start.getRow() == -1) { //check wall starting point exists
            System.out.println("Wall has no base! The input wall is floating!");
            return;
        }
        if(grid.length < 0) { //array is greater than length 0
            System.out.println("No bricks in a wall of size 0!");
            return;
        }
        if(grid[removedBrick[0]][removedBrick[1]] != 1) { //check the removed brick exists
            System.out.println("Can't remove a brick that isn't there!");
            return;
        }

        //create and fill LinkedList of coordinates utilizing DFS variation
        LinkedList<Coordinate> bricks = new LinkedList<>();
        findBricks(bricks, grid, start.getRow(), start.getCol());
        printBricksAfter(bricks, removedBrick);
    }

    /**
     * Variation of a DFS (variation meaning i chose to go left, right, top, (which is going down in a
     * mathematical graph representation of x,y coordinates) bottom (which is going up) to search 2d
     * array for bricks at the starting row and col
     * @param brickList list of all the touching bricks
     * @param g 2d array of grid representing bricks
     * @param row row in the 2d grid
     * @param col column in the 2d grid
     */
    public static void findBricks(LinkedList<Coordinate> brickList, int[][] g, int row, int col) {
        if(row < 0 || col < 0 || row >= g.length || col >= g[row].length) {         //check bounds
            return;
        }
        if(g[row][col] == 0) { //if coordinate doesn't have a brick
            return;
        } else if(g[row][col] == 1) {//just double checking that 1 is the value representing a brick
            g[row][col] = 0; //easy to simply clear grid to avoid recursive over the same element rather than create seperate data structure.
            Coordinate c = new Coordinate(row, col);
            brickList.add(c); //add bricks coordinate to the list

            findBricks(brickList, g, row, col - 1); //check one coordinate left
            findBricks(brickList, g, row, col + 1); //check one coordinate right
            findBricks(brickList, g, row - 1, col); //check one coordinate above
            findBricks(brickList, g, row + 1, col); //check one coordinate below
        }
    }

    /**
     * Prints everything in the list after the removed brick
     * @param brickList
     * @param removedBrick
     */
    public static void printBricksAfter(LinkedList<Coordinate> brickList, int[] removedBrick) {
        if(brickList.isEmpty())
            return;
        boolean beginPrintingBricks = false; //start printing after the brick the removed brick
        System.out.print("[");
        for(int i = 0; i < brickList.size(); i++) {
            if(beginPrintingBricks)
                System.out.print(brickList.get(i));
            if(brickList.get(i).getRow() == removedBrick[0] && brickList.get(i).getCol() == removedBrick[1])
                beginPrintingBricks = true;
        }
        System.out.println("]");
    }

}

//class to make things more clear since an int array
class Coordinate {
    private int row;
    private int col;

    public Coordinate(int rowY, int colX) {
        this.row = rowY;
        this.col = colX;
    }

    public Coordinate() {
        this.row = -1;
        this.row = -1;
    }

    public void setRow(int r) {
        this.row = r;
    }

    public void setCol(int c) {
        this.col = c;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    public String toString() {
        return "(" + col + "," + row + ")";
    }
}

