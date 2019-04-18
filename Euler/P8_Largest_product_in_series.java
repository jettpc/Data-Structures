package Euler;

public class P8_Largest_product_in_series {

    /**
     * The four adjacent digits in the 1000-digit number that have the greatest product are 9 × 9 × 8 × 9 = 5832.
     *
     * 73167176531330624919225119674426574742355349194934
     * 96983520312774506326239578318016984801869478851843
     * 85861560789112949495459501737958331952853208805511
     * 12540698747158523863050715693290963295227443043557
     * 66896648950445244523161731856403098711121722383113
     * 62229893423380308135336276614282806444486645238749
     * 30358907296290491560440772390713810515859307960866
     * 70172427121883998797908792274921901699720888093776
     * 65727333001053367881220235421809751254540594752243
     * 52584907711670556013604839586446706324415722155397
     * 53697817977846174064955149290862569321978468622482
     * 83972241375657056057490261407972968652414535100474
     * 82166370484403199890008895243450658541227588666881
     * 16427171479924442928230863465674813919123162824586
     * 17866458359124566529476545682848912883142607690042
     * 24219022671055626321111109370544217506941658960408
     * 07198403850962455444362981230987879927244284909188
     * 84580156166097919133875499200524063689912560717606
     * 05886116467109405077541002256983155200055935729725
     * 71636269561882670428252483600823257530420752963450
     *
     * Find the thirteen adjacent digits in the 1000-digit number that have the greatest product. What is the value of this product?
     */

    public static void main(String[] args) {
        long answer = largestProductInSeries();
        System.out.println(answer);

        //INT : The adjacent digits create the greatest product: 9 7 8 1 7 9 7 7 8 4 6 1 7
        //2091059712
        //The adjacent digits create the greatest product: 5 5 7 6 6 8 9 6 6 4 8 9 5
        //23514624000
    }

    public static long largestProductInSeries() {
        //step 1) create the array to store the 1000-digit number
        String temp =   "73167176531330624919225119674426574742355349194934" +
                        "96983520312774506326239578318016984801869478851843" +
                        "85861560789112949495459501737958331952853208805511" +
                        "12540698747158523863050715693290963295227443043557" +
                        "66896648950445244523161731856403098711121722383113" +
                        "62229893423380308135336276614282806444486645238749" +
                        "30358907296290491560440772390713810515859307960866" +
                        "70172427121883998797908792274921901699720888093776" +
                        "65727333001053367881220235421809751254540594752243" +
                        "52584907711670556013604839586446706324415722155397" +
                        "53697817977846174064955149290862569321978468622482" +
                        "83972241375657056057490261407972968652414535100474" +
                        "82166370484403199890008895243450658541227588666881" +
                        "16427171479924442928230863465674813919123162824586" +
                        "17866458359124566529476545682848912883142607690042" +
                        "24219022671055626321111109370544217506941658960408" +
                        "07198403850962455444362981230987879927244284909188" +
                        "84580156166097919133875499200524063689912560717606" +
                        "05886116467109405077541002256983155200055935729725" +
                        "71636269561882670428252483600823257530420752963450";

        int[] nums = new int[1000]; //1000 digit number
        int[] adjacentDigits = new int[13];

        long product = 0;
        long maxProduct = 0;

        for(int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(temp.valueOf(temp.charAt(i)));
        }
        //step 2) sliding window protocol!!!
        int slideIndex = 12; //sliding window protocol max value. 4 initial values: 0, 1, 2, 3

        for(int i = slideIndex; i < nums.length; i++) { //sliding window index increment
            product = 1; //reset product to 1 instead of 0, bc multiplication is the operation
            for(int j = slideIndex - 12; j <= slideIndex; j++) { //product multiplication
                product = product * nums[j];
            }
            int tempCounter = 0;
            if(product > maxProduct) {
                maxProduct = product;
                //additionally, it said to find the digits that add up to the greatest product, below accomplishes that task
                tempCounter = 0;
                for(int k = slideIndex - 12; k <= slideIndex; k++) {
                    adjacentDigits[tempCounter] = nums[k];
                    tempCounter++;
                }
            }
            slideIndex++;             //increment the slideIndex
        }
        System.out.print("The adjacent digits create the greatest product: ");
        for(int i = 0; i < adjacentDigits.length; i++) {
            System.out.print(adjacentDigits[i] + " "); //said to find the
        }
        System.out.println();

        return maxProduct;
    }
}
