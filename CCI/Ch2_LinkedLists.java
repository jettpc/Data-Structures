package CCI;

import CCI.LinkedListNode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Ch2_LinkedLists {

    public static void main(String args[]) {

        LinkedListNode list1 = new LinkedListNode();

        list1.addToTail(5);

        LinkedListNode.Node one = new LinkedListNode.Node(100, null);
        LinkedListNode.Node two = new LinkedListNode.Node(101, null);
        LinkedListNode.Node three = new LinkedListNode.Node(102, null);


        one.next = two;
        two.next = three;
        three.next = one;

        list1.addNodeToTail(one);

        System.out.println(one);
        System.out.println(list1.findBeginning(list1));




    }
}
