package Study_Prep;

public class Google_2_Blooming {
    public static void main(String[] args) {
        int[] A = {1, 2, 7, 6, 4, 3, 5};

        int answer = solution(A, 2, 2);
        System.out.println(answer);

    }


    /**
     *
     * @param A Array A is a permutation of integers associated with rose blood date and position
     * @param K long blossoming group containing at least K roses
     * @param M latest day on which tehre are exactly M long blossoming groups
     * @return
     */
    public static int solution(int[] A, int K, int M) {
        //basic problem = create an array of booleans and scan it for the latest day there are exactly M long blossoming groups
        boolean[] myGarden = new boolean[A.length];

        //false represents no rose;
        //true represents a rose!

        int bloomedFlowerIndex = 0;
        int tempBCounter = 0;
        int blossomCounter = 0;
        int lastDay = 0;
        int counter = 0;
        //every day update the garden (every iteration scan for a new rose position and validated case
        for(int i = 0; i < myGarden.length; i++) {
            //represent the flower patch
            bloomedFlowerIndex = A[i];
            myGarden[bloomedFlowerIndex - 1] = true;

            //scan for latest day there are M blossoming groups
            for (int j = 0; j < myGarden.length; j++) {
                if (myGarden[j] == true) {
                    counter++;
                    if (counter == K) {
                        tempBCounter++;
                        counter = 0;
                    }
                } else {
                    counter = 0;
                }
            }

            if (blossomCounter < tempBCounter) {
                blossomCounter = tempBCounter;
                lastDay = i;
            }
            tempBCounter = 0;
        }
        return lastDay + 1;

    }
}
