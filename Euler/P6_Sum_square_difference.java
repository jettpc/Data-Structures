package Euler;

public class P6_Sum_square_difference {
    /**
     * The sum of the squares of the first ten natural numbers is,
     *
     * 1^2 + 2^2 + ... + 10^2 = 385
     * The square of the sum of the first ten natural numbers is,
     *
     * (1 + 2 + ... + 10)^2 = 55^2 = 3025
     * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
     *
     * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
     *
     */
    public static void main(String[] args) {
        int answer = sum_vs_square();
        System.out.println(answer); //25164150
    }

    public static int sum_vs_square(){
        int squareOfTheSum = 0; //3025
        int sumOfTheSquares = 0; //385

        for(int i = 1; i <= 100; i++) {
            sumOfTheSquares = sumOfTheSquares + (i * i);
            squareOfTheSum = squareOfTheSum + i;
        }
        squareOfTheSum = squareOfTheSum * squareOfTheSum;

        System.out.println(sumOfTheSquares);
        System.out.println(squareOfTheSum);


        return squareOfTheSum - sumOfTheSquares;
    }
}
