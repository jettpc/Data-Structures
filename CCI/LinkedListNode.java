package CCI;

import java.util.HashSet;
import java.util.LinkedList;

public class LinkedListNode {
    Node head;

    public LinkedListNode() {
        System.out.println("Created a LinkedListNode");
    }

    public static class Node {
        int data;
        Node next;

        Node(int d) { //constructor
            data = d;
            next = null;
            System.out.println("Node created with data: " + data);
        }
        //constructor for a Node
        Node(int d, Node n) {
            data = d;
            next = n;
        }
    }

    public void printList() {
        Node n = head;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    //appends the specific element to the end of the list
    public void addToTail(int d) {
        if (head == null) { //check if this is first element being added to list
            head = new Node(d); //if it is, set the head node to a new node with data d
            return; //break out of method
        }
        Node addToEnd = new Node(d); //new node
        Node current = head; //get access to the current node
        while (current.next != null) {
            current = current.next;
        }
        current.next = addToEnd;
    }

    //adds a node to the end of the list
    public void addNodeToTail(Node n) {
        //if the list is empty
        if(head == null) {
            head = n;
            return;
        }
        //if the list is not empty, find the last node and make the last node.next = n
        Node current = head;
        while(current.next != null) {
            current = current.next;
        }
        current.next = n;

    }

    public void addToFront(int d) {


        if(head == null) {
            head = new Node(d);
            return;
        }

        Node addToFront = new Node(d);
        addToFront.next = head;
        head = addToFront;
    }

    public void deleteNode(int d) {
        //if no nodes exist
        if (head == null) {
            System.out.println("nothing in the list");
            return;
        }
        Node n = head;
        //if the head node needs to be deleted
        if (n.data == d) {
            if (n.next != null) { //if another node exists
                head = n.next;
                System.out.println("deleting head node");
                return;
            }
            System.out.println("deleting the only head node");
            head = null; //if no other node exists
            return;
        }

        //if head node doesn't need to be deleted
        while (n.next != null) {
            if (n.next.data == d) {
                n.next = n.next.next;
                System.out.println("deleting node in the middle of list");
                return;
            }
            n = n.next;
        }
        System.out.println("found nothing");
        return;
    }

    /**
     * 2.1 Remove Dups: Write code to remove duplicates from an unsorted linked list.
     * FOLLOW UP
     * How would you solve this problem if a temporary buffer is not allowed?
     * *****************************************************************************************************************
     * *****************************************************************************************************************
     */
    //Technique 1: use a buffer - hashset, remove any nodes who's data already exist in the hashset
    public void removeDups() {
        //use a hash set, check if the value exists in the hash set, if it does, remove it, otherwise add it to the table
        HashSet<Integer> set = new HashSet<Integer>();
        Node n = head;
        Node previous = null;
        while (n != null) {
            //if data already exists in the set, delete it.
            if (set.contains(n.data)) {
                //delete data currently inside
                System.out.println("already contained in set, delete node");
                previous.next = n.next; //sets the previous node next reference to the current nodes next reference, effectively deleting the current node since there is no longer a reference to it
            } else {
                System.out.println("add data to set, set prev to current node with data : " + n.data);
                set.add(n.data);
                previous = n;
            }
            n = n.next;
        }
    }
    //Technique 2: O(n^2) no buffer - grab one element, check against all, remove if needed, grab next element, repeat
    public void removeDubs2() {
        Node current = head;
        Node runner = null;


        //iterate through every element of current linkedList
        while(current.next != null) {

            System.out.println("head : \t\t" + head);
            System.out.println("current: \t" + current);

            runner = current;
            System.out.println("runner : \t" + runner);
            //iterate through it again with a different node
            while(runner.next != null) {

                System.out.println("runner inside loop : " + runner);
                //check if data is a duplicate of currents data
                if(current.data == runner.next.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    /**
     * 2.2 Implement an algorithm to find the kth to last element of a singly linked list
     * *****************************************************************************************************************
     * *****************************************************************************************************************
     */
    //Technique 1:
    //index wrapper takes the index out of the scope of the recursion, allowing you to store it apart from the stack performing recursion
    class IndexWrapper {
        public int value = 0;
    }

    public Node kthToLast(int k) {
        IndexWrapper index = new IndexWrapper();
        System.out.println("original call:");
        return kthToLastHelp(head, index, k);
    }

    public Node kthToLastHelp(Node current, IndexWrapper index, int k) {
        System.out.println("help call: ");
        //if you've reached the last node
        if (current == null) {
            System.out.println("current node is null : ");
            return null;
        }
        System.out.println("current node: " + current.data + "  index " + index.value + " k " + k);

        //n is currently null, unless we can find something to assign it to (current)
        Node n = kthToLastHelp(current.next, index, k);


        index.value = index.value + 1;

        System.out.println("current node: " + current.data + "  index " + index.value + " k " + k);
        if (index.value == k) {
            System.out.println("found " + current );
            return current;
        }

        System.out.println(n );
        return n;
    }

    //Technique 2: find total count, then length - k
    public int kthToLast2(int k) {
        int counter = 0;
        Node current = head;
        int returnData = - 1;
        while(current != null) {
            counter++;
            current = current.next;
        }
        current = head;
        for(int i = 0; i < counter - k; i++){
            returnData = current.data;
            current = current.next;
        }
        return returnData;
    }

    /**
     * 2.3 Delete middle node: implement an algorithm to delete a node in the middle (i.e., any node but the first
     * and last node, not necessarily the exact middle) of a singly linked list, given onnly access to that node.
     * EXAMPLE
     * Input: the node c from the linked list a->b->c->d->e->f
     * Result: no return, but new linked list a->b->d->e->f
     * *****************************************************************************************************************
     * *****************************************************************************************************************
     */
    //already deleted any node above, deleting a node in the middle is easier


    /**
     * 2.4 Write code to partition a linked list around a value x, such that all nodes less than x come before all
     * nodes greater than or equal to x. If x is contained within the list, the values of x only need to be after the
     * elements less than x (see below). The partition element x can appear anywhere in the "right partition"; it does
     * not need to appear between the left and right partitions.
     * EXAMPLE
     * Input:   3->5->8->5->10->2->1 [partition 5]
     * Output:  3->1->2->10->5->5->8
     * *****************************************************************************************************************
     * *****************************************************************************************************************
     */
    //objective = create a list for left partition and right partition and then merge
    public LinkedListNode partitionAroundX(LinkedListNode currentList, int partitionVal) {
        LinkedListNode beforePartitionVal = new LinkedListNode();
        LinkedListNode afterPartitionVal = new LinkedListNode();
        Node n = head;

        if (n.next == null) { //if head is null
            System.out.println("nothing in currentList");
            return null;
        }

        //create both lists
        while (n != null) {
            if (n.data < partitionVal) {
                beforePartitionVal.addToTail(n.data);
            } else {
                afterPartitionVal.addToTail(n.data);
            }
            n = n.next;
        }

        //print both seperate lists
        beforePartitionVal.printList();
        System.out.println();
        afterPartitionVal.printList();

        //if there was a value smaller than the partition val, and we need to merge the lists
        if (beforePartitionVal.head != null) {
            Node beforeHead = beforePartitionVal.head;
            while (beforeHead.next != null) {
                //find the beforeHead tail node
                beforeHead = beforeHead.next;
            }
            System.out.println("beforeHead Node: " + beforeHead.data);
            beforeHead.next = afterPartitionVal.head;
            beforePartitionVal.printList();
            return beforePartitionVal;
        }
        System.out.println("never");
        afterPartitionVal.printList();
        return afterPartitionVal;
    }

    /**
     * 2.5 Sum Lists: You have two numbers represented by a linked list, where each node contains a single digit.
     * The digits are stored in reverse order, such that the 1's digit is at the head of the list. Write a function
     * that adds the two numbers and returns the sum as a linked list.
     * EXAMPLE
     * Input:   (7->1->6) + (5->9->2). That's, 617+295
     * Output:  2->1->9 That's, 912.
     * *****************************************************************************************************************
     * *****************************************************************************************************************
     */

    public LinkedListNode addLists(LinkedListNode list1, LinkedListNode list2) {
        Node list1Current = list1.head;
        Node list2Current = list2.head;

        LinkedListNode listOfSum = new LinkedListNode();

        int carry = 0;
        int sum = 0;

        //while there is still something to add
        while (list1Current != null || list2Current != null) {

            //case 1: both have data to add
            if (list1Current != null && list2Current != null) {
                sum = list1Current.data + list2Current.data + carry;
                listOfSum.addToFront(sum % 10);
                list1Current = list1Current.next;
                list2Current = list2Current.next;
                if (sum > 9) {
                    carry = 1;
                } else {
                    carry = 0;
                }
            } //case 2: list1 has data, list2 doesn't
            else if (list1Current != null) {
                sum = list1Current.data + carry;
                listOfSum.addToFront(sum % 10);
                list1Current = list1Current.next;
                if (sum > 9) {
                    carry = 1;
                } else {
                    carry = 0;
                }
            } //case 3: list2 has data, list1 doesn't
            else if (list2Current != null) {
                sum = list2Current.data + carry;
                listOfSum.addToFront(sum % 10);
                list2Current = list2Current.next;
                if (sum > 9) {
                    carry = 1;
                } else {
                    carry = 0;
                }

            }
        }
        return listOfSum;
    }

    /**
     * 2.6 Palindrome: implement a function to check if a linked list is a palindrome
     * *****************************************************************************************************************
     * *****************************************************************************************************************
     */
    public boolean isPalindrome() {
        LinkedListNode reversedList = reverseList(head);
        return isEqual(head, reversedList);
    }

    private LinkedListNode reverseList(Node headNode) {
        LinkedListNode reverse = new LinkedListNode();
        Node node = headNode;
        while(node != null) {
            reverse.addToFront(node.data);
            node = node.next;
        }
        return reverse;
    }

    private boolean isEqual(Node headNode, LinkedListNode revList) {
        Node revNode = revList.head;

        while(headNode != null && revNode != null) {
            if(headNode.data != revNode.data) {
                return false;
            }
            headNode = headNode.next;
            revNode = revNode.next;
        }
        //return true if both are at the final node pointing to null
        return headNode == null && revNode == null;
    }

    /**
     * 2.7 Intersection: Given two (singly) linked lists, determine if the two lists intersect. Return the
     * intersecting node. Note that the intersection is defined based on reference, not value. That is, if
     * the kth node of the first linked list is the exact same node (by reference) as the jth node of the
     * second linked list, then they are intersecting
     * *****************************************************************************************************************
     * *****************************************************************************************************************
     */
    //return the intersecting node if there is one
    public Node intersection(LinkedListNode list1, LinkedListNode list2) {
        //determine if the last node is the same, if it is the same by reference, the lists intersect

        //while getting last node and comparing reference, get counts of both lists
        Node list1Current = list1.head;
        Node list2Current = list2.head;
        int list1Counter = 0;
        int list2Counter = 0;

        while(list1Current != null) {
            list1Counter++;
            list1Current = list1Current.next;
        }

        while(list2Current != null) {
            list2Counter++;
            list2Current = list2Current.next;
        }

        if(list2Current != list1Current) {
            System.out.println("No intersecting node");
            return null;
        } else {
            System.out.println("Intersecting Node!!!");
        }

        //iterate the size difference on the longer list
        System.out.println("list1: " + list1Counter);
        System.out.println("list2: " + list2Counter);

        int difference = Math.abs(list1Counter - list2Counter);
        list1Current = list1.head;
        list2Current = list2.head;

        //move the longer list forward the difference
        if(list1Counter > list2Counter) {
            for(int i = 0; i < difference; i++) {
                if(list1Current.next != null) {
                    list1Current = list1Current.next;
                }
            }
        } else if(list1Counter < list2Counter) {
            for(int i = 0; i < difference; i++) {
                if(list2Current.next != null) {
                    list2Current = list2Current.next;
                }
            }
        }
        while(list1Current != list2Current) {
            list1Current = list1Current.next;
            list2Current = list2Current.next;
        }
        return list2Current;
    }

    /**
     * 2.8 Loop detection: Given a circular linked list, implement an algorithm that returns the node at the
     * beginning of the loop. DEFINITION Circular linked list: A (corrupt) linked list in which a node's next
     * pointer points to an earlier node, so as to make a loop in the linked list.
     * EXAMPLE
     * Input: a -> b -> c -> d -> e -> c [the same C as earlier]
     * Output: c
     * *****************************************************************************************************************
     * *****************************************************************************************************************
     */
     public Node findBeginning(LinkedListNode list) {
         //1. create two pointers, fastpointer and slowpointer
         Node slow = list.head;
         Node fast = list.head;

         //2. move fast pointer at a rate of 2 steps and slowpointer at a rate of 1 step
         //find meeting point. This will be LOOP_SIZE - k steps into the linked list
         while(fast != null && fast.next != null) {
             slow = slow.next;
             fast = fast.next.next;
             if(slow == fast) //collision
                 break;
         }

         //error check - no meeting point, and therefore no loop
         if(fast == null || fast.next == null) {
             return null;
         }

         //3. when they collide, move slow to head. keep fast pointer where it is
         slow = list.head;
         //4. move slow and fast at a rate of one step. Return the new collision point
         while(slow != fast) {
             slow = slow.next;
             fast = fast.next;
         }

         //both now point to the start of the loop
         return fast;
     }

}




