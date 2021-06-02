package com.homeless.ptr.addtwonumbers;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int box = 0;
        ListNode ret = new ListNode(0);
        ListNode current = null;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        while (temp1 != null || temp2 != null) {
            int x = ((temp1 != null) ? temp1.val : 0)
                    + ((temp2 != null) ? temp2.val : 0);
            x = x + box;
            if (x / 10 >= 1) {
                box = 1;
                x = x % 10;
            } else box = 0;

            if (current == null) {
                ret.val = x;
                current = ret;
            } else {
                ListNode newbie = new ListNode(x);
                current.next = newbie;
                current = newbie;
            }
            if (temp1 != null) temp1 = temp1.next;
            if (temp2 != null) temp2 = temp2.next;
        }
        if (box != 0 && current != null) {
            current.next = new ListNode(box);
        }
        return ret;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}