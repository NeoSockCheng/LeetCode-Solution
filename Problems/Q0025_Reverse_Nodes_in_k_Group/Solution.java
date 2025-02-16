package Problems.Q0025_Reverse_Nodes_in_k_Group;

class Solution {
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

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || k==1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, curr = head;

// count the number of nodes
        int count = 0;
        while(curr!=null){
            count++;
            curr = curr.next;
        }

//reverse k nodes at a time
        while(count>=k){
            curr = prev.next;
            ListNode next = curr.next;

            for(int i = 1; i<k; i++){
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
            }

            prev = curr;
            count-=k;
        }
            return dummy.next;


    }
}

// question: reverse linkedlist nodes of number of k repeatedly
// solution: calculate number of nodes
// loop through the linkedlist, while count>=k
// will have a forloop to reverse the linkedlist