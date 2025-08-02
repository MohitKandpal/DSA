/**
 * You are given the head of a singly linked-list. The list can be represented as:
 *
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 *
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 */
package com.dsa;

public class ReorderList {
    public static void main(String[] args) {
        LLNode head = new LLNode(1);
        head.next = new LLNode(2);
        head.next.next = new LLNode(3);
        head.next.next.next = new LLNode(4);
        reorderList(head);

        System.out.println("Reordered list is: - ");
        LLNode temp = head;
        while(temp != null) {
            System.out.print((temp.next != null) ? temp.val + " -> " : temp.val);
            temp = temp.next;
        }
    }

    public static void reorderList(LLNode head) {
        if(head == null)
            return;
        LLNode sptr = head, fptr = head.next;
        while(fptr != null && fptr.next != null) {
            sptr = sptr.next;
            fptr = fptr.next.next;
        }
        LLNode head1 = head;
        LLNode head2 = sptr.next;
        sptr.next = null;
        head2 = reverse(head2);

        LLNode dummy = new LLNode(0);
        LLNode curr = dummy;
        while(head1 != null || head2 != null) {
            if(head1 != null) {
                curr.next = head1;
                head1 = head1.next;
                curr = curr.next;
            }

            if(head2 != null) {
                curr.next = head2;
                head2 = head2.next;
                curr = curr.next;
            }
        }
        head = dummy.next;
    }

    public static LLNode reverse(LLNode head) {
        LLNode temp = head, prev = null, temp2 = null;
        while(temp != null) {
            temp2 = temp.next;
            temp.next = prev;
            prev = temp;
            temp = temp2;
        }
        return prev;
    }
}

class LLNode {
    int val;
    LLNode next;

    public LLNode(int val) {
        this.val = val;
    }

    public LLNode(int val, LLNode next) {
        this.val = val;
        this.next = next;
    }
}
