package Study_Prep;

import java.util.LinkedList;

public class JayReverseSecHalfLL {

    public static void main(String args[]) {
        LinkedList<Integer> l = new LinkedList<>();

        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4); //this is half
        l.add(5);
        l.add(6);
        l.add(7);
        l.add(8);
        l.add(9);

        System.out.println(l);
        reverseSecondHalf(l);
        System.out.println(l);


    }

    public static void reverseSecondHalf(LinkedList<Integer> l) {
        int half = l.size() / 2;
        int max = l.size();

        LinkedList<Integer> l2 = new LinkedList<>();

        for(int i = half; i < max; i++) {
            l2.add(l.removeLast());
        }
        l.addAll(l2);
    }
}
