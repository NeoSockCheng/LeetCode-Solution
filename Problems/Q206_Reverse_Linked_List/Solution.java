package Problems.Q206_Reverse_Linked_List;


class Solution {
    
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseList(ListNode head) {

        if (head == null) {
            return null;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode temp = head.next;
        curr.next = prev;

        while (temp != null) {
            prev = curr;
            curr = temp;
            temp = curr.next;
            curr.next = prev;
        }

        return curr;
    }
}

// Question: reverse linkedlist
// Approach: use three pointers, prev, curr, and temp