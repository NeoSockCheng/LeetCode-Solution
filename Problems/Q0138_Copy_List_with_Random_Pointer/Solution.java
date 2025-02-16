package Problems.Q0138_Copy_List_with_Random_Pointer;

import java.util.ArrayList;
import java.util.HashMap;


// Definition for a Node.


// class Solution {
//     public Node copyRandomList(Node head) {
//         if (head == null)
//             return head;


//         HashMap<Node, Node> map = new HashMap<>();

//         Node curr = head;
//         while (curr != null) {
//             map.put(curr, new Node(curr.val));
//             curr = curr.next;
//         }

//         curr = head;
//         while (curr != null) {
//             map.get(curr).next = map.get(curr.next);
//             map.get(curr).random = map.get(curr.random);
//             curr = curr.next;
//         }

//         return map.get(head);

//     }
// }

class Solution {
    class Node {
        int val;
        Node next;
        Node random;
    
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
            this.random = null;
        }
    }
    
    public Node copyRandomList(Node head) {
        if (head == null)
            return head;

        Node curr = head;
        while (curr != null) {
            Node newNode = new Node(curr.val, curr.next);
            curr.next = newNode;
            curr = newNode.next;
        }

        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next != null ? curr.next.next : null;
        }
        
        Node oldHead = head;
        Node newHead = head.next;
        Node oldCurr = oldHead;
        Node newCurr = newHead;

        while (oldCurr != null) {
            oldCurr.next = oldCurr.next.next;
            newCurr.next = newCurr.next != null ? newCurr.next.next : null;
            oldCurr = oldCurr.next;
            newCurr = newCurr.next;
        }
        
        return newHead;


    }
}

/*
 * Question: copy a linkedlist with random pointer
 * Solution1: hashmap method
 * 1. first traverse: create a hashmap which store <oldnode, newnode>, where newnode's next and random is null
 * 2. second traverse: update newnode's next and random using map
 * 
 * Solution2: interweaving node
 * 1. first traverse: create new node and insert into the middle of oldnode and old
ode.next
 * 2. second traverse: insert next and into new node (newnode.random = oldnode.random.next)
 * 3. third traverse: separate the linkedlist using two pointer
 * 
 * Second solution is better with less memory since no additional map is created, while the time complexity is still linear
 */
