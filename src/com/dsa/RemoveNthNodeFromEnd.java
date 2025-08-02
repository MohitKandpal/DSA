/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 */
package com.dsa;

public class RemoveNthNodeFromEnd {
    public static void main(String[] args) {
        LLNode head = new LLNode(1);
        head.next = new LLNode(2);
        head.next.next = new LLNode(3);
        head.next.next.next = new LLNode(4);
        head.next.next.next.next = new LLNode(5);

        head = removeNthFromEnd(head, 2);
        System.out.println("Updated list is: - ");
        LLNode temp = head;
        while(temp != null) {
            System.out.print((temp.next != null) ? temp.val + " -> " : temp.val);
            temp = temp.next;
        }
    }

    public static LLNode removeNthFromEnd(LLNode head, int n) {
        if(head == null)
            return head;
        int length = 0; LLNode temp = head;
        while(temp != null) {
            length++;
            temp = temp.next;
        }
        int nodeIndToRemove = length - n + 1;
        LLNode prev = null; temp = head;
        while(nodeIndToRemove > 1 && temp != null) {
            prev = temp;
            temp = temp.next;
            nodeIndToRemove--;
        }

        if(prev == null)
            head = temp.next;
        if(temp != null && temp.next != null)
            prev.next = temp.next;
        else
            prev.next = null;
        return head;
    }
}
