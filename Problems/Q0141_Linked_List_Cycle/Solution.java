package Problems.Q0141_Linked_List_Cycle;

import java.util.HashSet;

// public class Solution {
//     public boolean hasCycle(ListNode head) {
//         HashSet<ListNode> set = new HashSet<>();

//         while (head != null) {
//             if (set.contains(head)) {
//                 return true;
//             } else {
//                 set.add(head);
//             }
//             head = head.next;
//         }

//         return false;
//     }
// }

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            if (fast == slow) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        return false;

    }
}

// question: detect whether there is a cycle in the linkedlist
// solution: put listnode in hashset
// solution2: use two pointer, one fast one slow, if there is cycle, they will meet each other eventually
