package Problems.Q0002_Add_Two_Numbers;

// class Solution {
//     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//         ListNode temp1 = l1;
//         ListNode temp2 = l2;

//         if (l1 == null) {
//             return l2;
//         } else if (l2 == null) {
//             return l1;
//         }

//         int temp = 0;
//         int sum = 0;

//         while (true) {
//             sum = temp1.val + temp2.val + temp;
//             if (sum > 9) {
//                 temp1.val = sum % 10;
//                 temp = sum / 10;
//             } else {
//                 temp1.val = sum;
//                 temp = 0;
//             }

//             if (temp1.next == null || temp2.next == null)
//                 break;
//             else {
//                 temp1 = temp1.next;
//                 temp2 = temp2.next;
//             }
//         }

//         if (temp != 0) {
//             if (temp1.next == null) {
//                 if (temp2.next != null) {
//                     temp1.next = temp2.next;
//                     temp2.next = null;
//                 } else {
//                     temp1.next = new ListNode(0);
//                 }
//             }
//             temp1 = temp1.next;

//             while (temp != 0) {
//                 sum = temp1.val + temp;
//                 if (sum > 9) {
//                     temp1.val = sum % 10;
//                     temp = sum / 10;
//                 } else {
//                     temp1.val = sum;
//                     temp = 0;
//                 }
//                 if (temp != 0 && temp1.next == null) {
//                     temp1.next = new ListNode(0);
//                 }
//                 if (temp1.next == null)
//                     break;
//                 else {
//                     temp1 = temp1.next;
//                 }
//             }
//         }

//         if (temp2.next != null) {
//             temp1.next = temp2.next;
//         }

//         return l1;
//     }
// }

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int digit1 = (l1 != null) ? l1.val : 0;
            int digit2 = (l2 != null) ? l2.val : 0;

            int sum = digit1 + digit2 + carry;
            int digit3 = sum % 10;
            carry = sum / 10;

            ListNode newNode = new ListNode(digit3);
            tail.next = newNode;
            tail = tail.next;

            l1 = (l1 == null) ? null : l1.next;
            l2 = (l2 == null) ? null : l2.next;

        }

        return dummyHead.next;

    }
}

/*
 * Question: Given two linkedlist, return a linked list which every node is the sum of two node
 *  if sum>9, then the carry will be bring to the next
 * Solution: 
 * 1. create a dummyhead, and a tail to track its last node
 * 2. then while l1, l2 and carry are not null, keep looping
 * 3. in the loop, total up this three digit, get the digit and carry
 * 4. return dummyhead.next
*/


