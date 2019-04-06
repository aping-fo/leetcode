class ReleteDuplicates {
      public static ListNode deleteDuplicates(ListNode head) {
          ListNode current = head;
          while (current != null && current.next != null) {
              if (current.next.val == current.val) {
                  current.next = current.next.next;
              } else {
                  current = current.next;
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
