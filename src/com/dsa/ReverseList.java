/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */
package com.dsa;

public class ReverseList {
    public static void main(String[] args) {
        LLNode head = new LLNode(1);
        head.next = new LLNode(2);
        head.next.next = new LLNode(3);
        head.next.next.next = new LLNode(4);

        LLNode revHead = reverse(head);
        System.out.println("Reversed list is: - ");
        LLNode temp = revHead;
        while(temp != null) {
            System.out.print((temp.next != null) ? temp.val + "->" : temp.val);
            temp = temp.next;
        }
    }

    public static LLNode reverse(LLNode head) {
        if(head == null)
            return null;
        LLNode temp = head, prev = null, next = null;
        while(temp != null) {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }
}
