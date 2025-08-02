/**
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 */
package com.dsa;

public class MergeTwoSortedList {
    public static void main(String[] args) {
        LLNode head = new LLNode(1);
        head.next = new LLNode(2);
        head.next.next = new LLNode(4);

        LLNode head2 = new LLNode(1);
        head2.next = new LLNode(3);
        head2.next.next = new LLNode(4);

        LLNode mergedHead = merge(head, head2);
        System.out.println("Sorted merged list is: - ");
        LLNode temp = mergedHead;
        while(temp != null) {
            System.out.print((temp.next != null) ? temp.val + " -> " : temp.val);
            temp = temp.next;
        }
    }

    public static LLNode merge(LLNode head1, LLNode head2) {
        if(head1 == null && head2 == null)
            return null;
        if(head1 == null)
            return head2;
        if(head2 == null)
            return head1;

        if(head1.val <= head2.val) {
            head1.next = merge(head1.next, head2);
            return head1;
        } else {
            head2.next = merge(head1, head2.next);
            return head2;
        }
    }
}
