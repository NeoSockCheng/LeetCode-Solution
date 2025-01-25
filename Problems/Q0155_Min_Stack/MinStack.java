package Problems.Q0155_Min_Stack;

import java.util.ArrayList;
import java.util.List;

// class MinStack {
//     List<Integer> stack;
//     int index;
//     public MinStack() {
//         stack = new ArrayList<>();
//         index = -1;
//     }
    
//     public void push(int val) {
//         stack.add(val);
//         index++;
//     }
    
//     public void pop() {
//         stack.remove(index);
//         index--;
//     }
    
//     public int top() {
//         return stack.get(index);
//     }
    
//     public int getMin() {
//         int min = Integer.MAX_VALUE;
//         for (int i = 0; i <= index; i++) {
//             min = Math.min(min, stack.get(i));
//         }
//         return min;
//     }
// }
    
// question: create a stack class, with function push, pop, top (like peek), get min
// Solution: use a stack/arraylist or create a node clasee (most lightweight and fastest
// area improved: instead of using arraylist (with index pointing to head), can create a node class
// each node containing value, min, and next (previous element in my understanding)
// when push, we replace head with new node, and within the node we compare the value with update min element

class MinStack {
    Node head;
    public void push(int val) {
        if (head==null) {
            head = new Node(val, val, null);
        } else {
            head = new Node(val, Math.min(head.min, val), head);
        }
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }

    private class Node {
        int val;
        int min;
        Node next;

        public Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }

    }
}
