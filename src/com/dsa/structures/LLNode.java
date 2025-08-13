package com.dsa.structures;

public class LLNode {
    public int val;
    public LLNode next;

    public LLNode(int val) {
        this.val = val;
    }

    public LLNode(int val, LLNode next) {
        this.val = val;
        this.next = next;
    }
}
