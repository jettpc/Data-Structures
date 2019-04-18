package Euler;

public class P18_Maximum_path_sum_I {

    /**
     * By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.
     *
     * 3
     * 7 4
     * 2 4 6
     * 8 5 9 3
     *
     * That is, 3 + 7 + 4 + 9 = 23.
     *
     * Find the maximum total from top to bottom of the triangle below:
     *
     * 75
     * 95 64
     * 17 47 82
     * 18 35 87 10
     * 20 04 82 47 65
     * 19 01 23 75 03 34
     * 88 02 77 73 07 63 67
     * 99 65 04 28 06 16 70 92
     * 41 41 26 56 83 40 80 70 33
     * 41 48 72 33 47 32 37 16 94 29
     * 53 71 44 65 25 43 91 52 97 51 14
     * 70 11 33 28 77 73 17 78 39 68 17 57
     * 91 71 52 38 17 14 91 43 58 50 27 29 48
     * 63 66 04 68 89 53 67 30 73 16 69 87 40 31
     * 04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
     *
     * NOTE: As there are only 16384 routes, it is possible to solve this problem by trying every route.
     * However, Problem 67, is the same challenge with a triangle containing one-hundred rows; it cannot be solved by brute force, and requires a clever method! ;o)
     */

    public static void main(String[] args) {
        int answer = maximumPathSum();
        System.out.println(answer);
    }

    public static int maximumPathSum() {
        int[][] table = createTable();

        for(int row = table.length - 1; row > 0; row--) {
            for(int col = 0; col < table.length; col++) {
                if (table[row - 1][col] != 0) {
                    table[row - 1][col] += max(table[row][col], table[row][col + 1]);
                }
            }
        }
        return table[0][0];
    }

    public static int[][] createTable() {
        String parseMe =
                "75\n" +
                "95 64\n" +
                "17 47 82\n" +
                "18 35 87 10\n" +
                "20 04 82 47 65\n" +
                "19 01 23 75 03 34\n" +
                "88 02 77 73 07 63 67\n" +
                "99 65 04 28 06 16 70 92\n" +
                "41 41 26 56 83 40 80 70 33\n" +
                "41 48 72 33 47 32 37 16 94 29\n" +
                "53 71 44 65 25 43 91 52 97 51 14\n" +
                "70 11 33 28 77 73 17 78 39 68 17 57\n" +
                "91 71 52 38 17 14 91 43 58 50 27 29 48\n" +
                "63 66 04 68 89 53 67 30 73 16 69 87 40 31\n" +
                "04 62 98 27 23 09 70 98 73 93 38 53 60 04 23";

        String[] myStrArray = parseMe.split("\n");
        int length = myStrArray.length;
        String[] temp;
        int[][] table = new int[length][length];

        for(int i = 0; i < length; i++) {
            temp = myStrArray[i].split(" ");
            for(int j = 0; j < temp.length; j++) {
                table[i][j] = Integer.parseInt(temp[j]);
            }
        }
        return table;
    }

    public static int max(int a, int b) {
        if(a > b)
            return a;
        return b;
    }
}
