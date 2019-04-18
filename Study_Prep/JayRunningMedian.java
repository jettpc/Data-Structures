package Study_Prep;

import java.util.Collections;
import java.util.PriorityQueue;

public class JayRunningMedian {

    public static void main(String args[]) {
        int[] array = {5,15,10,20,3};

        MedianFinder m = new MedianFinder();
        m.addNum(5);
        System.out.println(m.findMedian());
        m.addNum(15);
        System.out.println(m.findMedian());
        m.addNum(10);
        System.out.println(m.findMedian());
        m.addNum(20);
        System.out.println(m.findMedian());
        m.addNum(3);
        System.out.println(m.findMedian());





    }

    static class MedianFinder {
        PriorityQueue<Integer> maxHeap;//lower half
        PriorityQueue<Integer> minHeap;//higher half

        public MedianFinder(){
            maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
            minHeap = new PriorityQueue<Integer>();
        }

        // Adds a number into the data structure.
        public void addNum(int num) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());

            if(maxHeap.size() < minHeap.size()){
                maxHeap.offer(minHeap.poll());
            }
        }

        // Returns the median of current data stream
        public double findMedian() {
            if(maxHeap.size()==minHeap.size()){
                return (double)(maxHeap.peek()+(minHeap.peek()))/2;
            }else{
                return maxHeap.peek();
            }
        }
    }

}
