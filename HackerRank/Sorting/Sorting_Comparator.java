package HackerRank.Sorting;

public class Sorting_Comparator {

    class Player {
        public int score;
        public String name;
    }

    // complete this method
    //return -1 if a < b
    //       0 if a == b
    //       1 if a > b
    // Player class:
    //      attributes: name: string
    //                  score: int
    public int compare(Player a, Player b) {
        if (a.score < b.score) {
            return 1; //problem says when a < b return -1
        } else if (a.score > b.score) {
            return -1; //problem says when a > b return 1
        }
        //if the scores are equal check the string
        return a.name.compareTo(b.name);

    }
}
