package Problems.Q0019_Remove_Nth_Node_From_End_of_List;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
            
        }
        if (fast == null)
            return head.next;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return head;
    }
}

// Question: remove nth element from end of a linkedlint
// solution: using fast and slow pointer
// we move fast pointer to nth element from the start
// means now fast and slow have a gap n
// then we move fast to the end of linkedlist to gether to end
// when fast reached end, then end is located at the nth elemnt from the back
// then slow.next = slow.next.next