package CCI;

/**
 * Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write
 * a method to rotate the image by 90 degrees. Can you do this in place?
 */

public class Ch1_7_RotateMatrix {

    public static void main(String args[]) {

        int[][] matrix = new int[4][4];
        int k = 1;

        System.out.println(matrix.length);
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                matrix[i][j] = k;
                System.out.print(matrix[i][j] + "\t");
                k++;
            }
            System.out.println();
        }
        System.out.println();

        System.out.println(matrix[0][0]);
        System.out.println(matrix[3][0]);
        System.out.println(matrix[0][3]);

        rotateRightSoloTry(matrix);
        printMatrix(matrix);
    }

    public static boolean rotateRightSoloTry(int[][] matrix) {
        int len = matrix.length;
        if(len < 1 || matrix.length != matrix[0].length) return false;
        int temp;
        for(int layer = 0; layer < len / 2; layer++) { //outer layer loop!
            /**
             * for each layer, rotate all cells, range = 2 less than len
             * because if len was 4 you need to subtract 1 to index only 0-3
             * then also subtract another 1 because you don't rearrange
             * the corners twice
             */
            for(int i = layer; i < len - 1 - layer; i++) { //inner loop for data rearranging
                /**
                 * NOTE: matrix logic might seem backwards because indexing matrices goes as follows:
                 * matrix[row][col] meaning matrix[up-down][left right].
                 *
                 * Below you will have a changing variable related to i since you're in the inner
                 * loop responsible for rearranging the data, then you will have a variable
                 * responsible for keeping track of what consistent column or row you are keeping
                 * constant for that specific manipulation. For example with the matrix:
                 * 1    2	3	4
                 * 5	6	7	8
                 * 9	10	11	12
                 * 13	14	15	16
                 * moving the 13 to the 1, 9 to the 2 and 5 to the 3 means I would be indexing
                 * matrix[constant up-down][increasing = left->right] = matrix[decreasing = down->up][constant left-right]
                 */

                //getting the temp value of matrix[constant up-down][increasing left->right];
                temp = matrix[layer][i];

                //left --> top --> matrix[constant up-down][increasing left->right] = matrix[decreasing down->up][constant left-right]
                //            δ                 δ
                matrix[layer][i] = matrix[len-1-i][layer];

                //bottom --> left --> matrix[decreasing down->up][constant left-right] = matrix[constant up-down][decreasing right->left]
                //           δ                                     δ
                matrix[len-1-i][layer] = matrix[len-1-layer][len-1-i];

                //right --> bottom --> matrix[constant up-down][decreasing right->left] = matrix[increasing up->down][constant left-right]
                //                        δ           δ
                matrix[len-1-layer][len-1-i] = matrix[i][len-1-layer];

                //top --> right --> matrix[increasing up->down][constant left-right] = matrix[constant up-down][increasing left->right]
                //     δ
                matrix[i][len-1-layer] = temp;
            }
        }
        return true;
    }

    public static void printMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println();

    }

    public static boolean rotateRight(int[][] matrix) {
        if(matrix.length == 0 || matrix.length != matrix[0].length) return false;
        int n = matrix.length;

        for(int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for(int i = first; i < last; i++) {
                int offset = i - first;

                int top = matrix[first][i]; //save top

                //left -> top
                matrix[first][i] = matrix[last-offset][first];

                //bottom -> left
                matrix[last-offset][first] = matrix[last][last-offset];

                //right -> bottom
                matrix[last][last-offset] = matrix[i][last];

                //top -> right
                matrix[i][last] = top; //right <- saved top
            }
        }
        return true;
    }

    public static boolean rotateLeft(int[][] mat) {
        if(mat.length == 0 || mat.length != mat[0].length) return false;
        int n = mat.length;

        for(int layer = 0; layer < n / 2; layer++) {
        System.out.println("there");
            for(int i = layer; i < n - 1 - layer; i++) {
                System.out.println("here");
                // store current cell in temp variable
                int temp = mat[layer][i];

                // move values from right to top
                mat[layer][i] = mat[i][n-1-layer];

                // move values from bottom to right
                mat[i][n-1-layer] = mat[n-1-layer][n-1-i];

                // move values from left to bottom
                mat[n-1-layer][n-1-i] = mat[n-1-i][layer];

                // assign temp to left
                mat[n-1-i][layer] = temp;
            }
        }
        return true;
    }
}
