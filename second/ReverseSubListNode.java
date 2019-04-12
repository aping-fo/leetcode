package com.leetcode;

public class ReverseSubListNode {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        head.next = node2;
        //node2.next = node3;
        //node3.next = node4;
        //node4.next = node5;

        System.out.println(reverse(head, 1, 2));

        String a = "";
        String b = "";

        System.out.println(a == b);
    }

    public static ListNode reverse(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }

        if (m == n) {
            return head;
        }


        //做为需要反转头节点
        ListNode mNode = head;
        //m节点的父节点
        ListNode mParentNode = head;
        int i = 1;
        while (mNode != null) {
            if (i == m) {
                break;
            }
            mParentNode = mNode;
            mNode = mNode.next;
            i += 1;
        }

        ListNode mHead = mNode;
        ListNode node1 = mHead.next;
        i += 1;
        ListNode node2 = mHead.next.next;
        mNode.next = null;

        while (node1 != null) {
            node1.next = mHead;
            mHead = node1;
            if (i == n) {
                mNode.next = node2;
                if (m != 1) {
                    mParentNode.next = mHead;
                } else {
                    head = mHead;
                }
                break;
            }
            i += 1;
            node1 = node2;
            if (node2 != null) {
                node2 = node2.next;
            }
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
