/**
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 */
package com.dsa;

public class LinkedListCycle {
    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(3);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(0);
        head.next.next.next = new LinkedListNode(-4);
        head.next.next.next.next = head.next.next;
        System.out.println("Cycle present - " + hasCycle(head));
    }

    public static boolean hasCycle(LinkedListNode head) {
        if(head == null)
            return false;
        LinkedListNode sptr = head, fptr = head;
        while(fptr != null && fptr.next != null) {
            sptr = sptr.next;
            fptr = fptr.next.next;
            if(sptr == fptr)
                return true;
        }
        return false;
    }
}

class LinkedListNode {
    int val;
    LinkedListNode next;

    public LinkedListNode(int val) {
        this.val = val;
    }

    public LinkedListNode(int val, LinkedListNode next) {
        this.val = val;
        this.next = next;
    }
}
