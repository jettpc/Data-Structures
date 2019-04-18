package CCI;

/**
 * Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0,
 * its entire row and column are set to 0
 */

public class Ch1_8_ZeroMatrix {

    public static void main(String args[]) {
        int[][] matrix = new int[4][5];
        int k = 1;

        System.out.println(matrix.length);
       // System.out.println(matrix[0].length); //1



        System.out.println();
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = k;
                System.out.print(matrix[i][j] + "\t");
                k++;
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();
        matrix[0][0] = 0;
        matrix[2][3] = 0;

        setZeros(matrix);

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static boolean setZeros(int[][] matrix) {
        if(matrix.length == 0) return false;
        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        boolean[] rows = new boolean[rowLen]; //rows
        boolean[] cols = new boolean[colLen]; //columns

        for(int r = 0; r < rowLen; r++) { //4
            for (int c = 0; c < colLen; c++) {
                if(matrix[r][c] == 0) {
                    rows[r] = true;
                    cols[c] = true;
                }
            }
        }
        //nullify rows
        System.out.println(rows.length);
        for(int r = 0; r < rowLen; r++) {
            if(rows[r] == true) { //nullify the row by iterating over the columns
                for(int c = 0; c < colLen; c++) {
                    matrix[r][c] = 0;
                }
            }
        }
        //nullify cols
        System.out.println(cols.length);
        for(int c = 0; c < colLen; c++) {
            if(cols[c] == true) { //nullify the col by iterating over the rows
                for(int r = 0; r < rowLen; r++) {
                    matrix[r][c] = 0;
                }
            }
        }
        return true;
    }
}
