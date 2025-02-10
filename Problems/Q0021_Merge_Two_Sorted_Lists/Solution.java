package Problems.Q0021_Merge_Two_Sorted_Lists;

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
            System.out.println(cur.val);
        }

        cur.next = (list1 != null) ? list1 : list2;
        
        return dummy.next;
    }
}

// Question: merge two linked list in ascending order
// Solution: compare two list, set next as the list with smaller value
// at the end, set next as the list that still have value