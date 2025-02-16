package Template;

class ListNode {
    int val;
    ListNode next;
    
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class DoublyListNode {
    int val;
    DoublyListNode next, prev;
    
    DoublyListNode(int val) {
        this.val = val;
        this.next = this.prev = null;
    }
}

public class LinkedListTemplate {

    // ✅ Insert a node at the head of a singly linked list
    public static ListNode insertAtHead(ListNode head, int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        return newNode; // New head
    }

    // ✅ Reverse a linked list (Iterative)
    public static ListNode reverseListIterative(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next; // Save next node
            curr.next = prev;  // Reverse pointer
            prev = curr;
            curr = nextNode;
        }
        return prev; // New head
    }

    // ✅ Reverse a linked list (Recursive)
    public static ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    // ✅ Find the middle of a linked list using slow & fast pointer
    public static ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // Middle node
    }

    // ✅ Detect cycle in a linked list (Floyd’s Cycle Detection Algorithm)
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true; // Cycle detected
        }
        return false;
    }

    // ✅ Merge two sorted linked lists
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    // ✅ Insert a node at the head of a doubly linked list
    public static DoublyListNode insertAtHead(DoublyListNode head, int val) {
        DoublyListNode newNode = new DoublyListNode(val);
        if (head != null) {
            head.prev = newNode;
            newNode.next = head;
        }
        return newNode; // New head
    }

    // ✅ Delete a node from a doubly linked list
    public static DoublyListNode deleteNode(DoublyListNode head, DoublyListNode node) {
        if (head == null || node == null) return head;
        
        if (node == head) head = head.next; // If deleting head, move head
        
        if (node.next != null) node.next.prev = node.prev; // Fix next pointer
        if (node.prev != null) node.prev.next = node.next; // Fix previous pointer
        
        return head;
    }

    // ✅ Print a singly linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    // ✅ Print a doubly linked list
    public static void printDoublyList(DoublyListNode head) {
        DoublyListNode tail = null;
        System.out.print("Forward: ");
        while (head != null) {
            System.out.print(head.val + " ⇄ ");
            tail = head; // Move tail to the last node
            head = head.next;
        }
        System.out.println("null");

        System.out.print("Backward: ");
        while (tail != null) {
            System.out.print(tail.val + " ⇄ ");
            tail = tail.prev;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Test Singly Linked List
        ListNode head = null;
        head = insertAtHead(head, 3);
        head = insertAtHead(head, 2);
        head = insertAtHead(head, 1);
        System.out.print("Original List: ");
        printList(head);

        head = reverseListIterative(head);
        System.out.print("Reversed List: ");
        printList(head);

        System.out.println("Middle Node: " + findMiddle(head).val);

        System.out.println("Has Cycle: " + hasCycle(head));

        // Test Doubly Linked List
        DoublyListNode dHead = null;
        dHead = insertAtHead(dHead, 3);
        dHead = insertAtHead(dHead, 2);
        dHead = insertAtHead(dHead, 1);
        System.out.println("\nDoubly Linked List:");
        printDoublyList(dHead);
    }
}

