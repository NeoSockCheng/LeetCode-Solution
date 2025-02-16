package Problems.Q0023_Merge_k_Sorted_Lists;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

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

// class Solution {
//     public ListNode mergeKLists(ListNode[] lists) {
//         TreeMap<Integer, Integer> map = new TreeMap<>();
//         for (ListNode l : lists) {
//             while (l != null) {
//                 map.put(l.val, map.getOrDefault(l.val, 0) + 1);
//                 l = l.next;
//             }
//         }

//         ListNode dummy = new ListNode();
//         ListNode current = dummy;

//         while (!map.isEmpty()) {
//             Map.Entry<Integer, Integer> firstEntry = map.firstEntry();
//             int key = firstEntry.getKey();
//             int count = firstEntry.getValue();

//             for (int i = 0; i < count; i++) {
//                 current.next = new ListNode(key);
//                 current = current.next;
//             }
//             map.remove(firstEntry);

//         }
//         return dummy.next;
//     }
// }

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (ListNode head : lists) {
            while (head != null) {
                minHeap.add(head.val);
                head = head.next;
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while (!minHeap.isEmpty()) {
            current.next = new ListNode(minHeap.remove());
            current = current.next;
        }

        return dummy.next;
    }
}



// question: merge k sorted linkedlist
// solution1: using a treemap to get count of each key in every linked list, then build a linkedlist using that
// solution2: using a priority queue to store all value of the linkedlists, then retrieve and build a linkedlist
// the priority queue automatically arrange the values in ascending order
