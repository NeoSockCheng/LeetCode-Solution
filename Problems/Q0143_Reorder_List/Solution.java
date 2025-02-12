package Problems.Q0143_Reorder_List;

import java.util.HashMap;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode slow = head, fast = head;
        while(fast!=null &&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;
        slow.next = null;
        ListNode node = null;

        while(second!=null){
            ListNode temp = second.next;
            second.next = node;
            node = second;
            second = temp;
        }

        ListNode first = head;
        second = node;

        while(second!=null){
            ListNode temp1 = first.next, temp2 = second.next;
            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }


        }
        
        
    }


    //Question: reverse order of linkedlist, eg 12345 to 15243
    // solution: 1. split the linkedlist to two using slow and fast pointer
    // 2. reverse the second half of the linkedlist
    // 3. merge the two halves