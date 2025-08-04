package com.dsa;

import java.util.PriorityQueue;

public class MergeKSortedList {
    public static void main(String[] args) {
        LLNode[] lists = new LLNode[3];
        LLNode first = new LLNode(1);
        first.next = new LLNode(4);
        first.next.next = new LLNode(5);

        LLNode second = new LLNode(1);
        second.next = new LLNode(3);
        second.next.next = new LLNode(4);

        LLNode third = new LLNode(2);
        third.next = new LLNode(6);

        lists[0] = first; lists[1] = second; lists[2] = third;

        LLNode head = mergeKSorted(lists);
        System.out.println("K merged Sorted lists : - ");
        LLNode temp = head;
        while(temp != null) {
            System.out.print((temp.next != null) ? temp.val + " -> " : temp.val);
            temp = temp.next;
        }
    }

    public static LLNode mergeKSorted(LLNode[] lists) {
        PriorityQueue<LLNode> queue = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);
        for(LLNode node: lists) {
            if(node != null)
                queue.add(node);
        }

        LLNode dummy = new LLNode(0);
        LLNode temp = dummy;
        while(!queue.isEmpty()) {
            LLNode poppedNode = queue.poll();
            temp.next = poppedNode;
            if(poppedNode.next != null) {
                queue.add(poppedNode.next);
            }
            temp = temp.next;
        }
        return dummy.next;
    }
}
