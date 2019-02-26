package com.ap;

public class SwapPairs {

    public static void main(String[] args) {
        Main.ListNode node = new Main.ListNode(1);
        Main.ListNode node2 = new Main.ListNode(2);
        Main.ListNode node3 = new Main.ListNode(3);
        Main.ListNode node4 = new Main.ListNode(4);
        Main.ListNode node5 = new Main.ListNode(5);
        Main.ListNode node6 = new Main.ListNode(6);

        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        swapPairs(node);

    }

    public static Main.ListNode swapPairs(Main.ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }


        Main.ListNode root = head.next;

        Main.ListNode n1 = head;
        Main.ListNode n2 = head.next;
        Main.ListNode p = n2.next;

        while (n1 != null && n2 != null) {
            n2.next = n1;

            if (p != null) {
                n2 = p.next;
            } else {
                n2 = null;
            }

            if (n2 == null) {
                n1.next = p;
            }else {
                n1.next = n2;
            }

            n1 = p;

            if (n2 != null) {
                p = n2.next;
            }

        }


        return root;
    }
}
