package Study_Prep;

public class MemoizationAndDynamicProgramming {
    public static void main(String[] args) {
        boolean[][] g  = new boolean[8][8]; //grid
        int[][] paths = new int[8][8];

        g[2][1] = true;
        g[6][1] = true;
        g[4][2] = true;
        g[0][3] = true;
        g[2][3] = true;
        g[5][3] = true;
        g[2][4] = true;
        g[3][5] = true;
        g[4][5] = true;
        g[6][5] = true;
        g[1][6] = true;
        g[5][6] = true;

        //print the grid
        for(int i = 0; i < g.length; i++) {
            for(int j = 0; j < g.length; j++) {
                System.out.print(g[j][i] + " "); //print the grid [j][i] because j is what is increasing
            }
            System.out.println();
        }

        int answer = countPaths(g, 0, 0, paths);
        System.out.println(answer);

    }

    //recursion
    public static int countPaths(boolean[][] grid, int r, int c, int[][] paths) {
        if(!validSquare(grid, r, c)) {
            System.out.println("invalid square r: " + r + " c: " + c);
            return 0;
        }
        if(isAtEnd(grid, r, c)) {
            System.out.println("made it to the end");
            return 1;
        }
        if(paths[r][c] == 0) { //meaning the path hasn't been calculated yet
            //calculate the number of paths from that square
            paths[r][c] = countPaths(grid, r + 1, c, paths) + countPaths(grid, r, c + 1, paths);
        }
        System.out.println("checking r: " + r + " c: " + c );
        return paths[r][c];
    }

    //true represents an invalid square
    //false represents a valid square
    public static boolean validSquare(boolean[][] grid, int r, int c) {
        //check range
        int range = grid.length - 1;
        if(r > range || c > range) {
            return false;
        }
        //check valid square
        if(grid[r][c]) {
            return false;
        }
        return true; //is valid
    }

    public static boolean isAtEnd(boolean[][] grid, int r, int c) {
        if(r == grid.length - 1 && c == grid.length - 1) {
            return true;
        }
        return false;
    }
}
