package easyQuestions;
class ListNode {
    int val; // Value of the node
    ListNode next; // Reference to the next node

    // Constructor to initialize the node
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
public class LinkedListMiddle {
    /**
     Given the head of a singly linked list, return the middle node of the linked list
     if there are two middle nodes, return the second middle node.
     */

    public ListNode middleNode(ListNode head){

        ListNode slow = head;
        ListNode fast = head;

        while ( fast != null && fast.next != null){
                slow=slow.next;
                fast=fast.next.next;
        }
        return slow;
    }
    ListNode head = new ListNode(1);
//    head.next = new ListNode(2);
//    head.next.next = new ListNode(3);
//    head.next.next.next = new ListNode(4);
//    head.next.next.next.next = new ListNode(5);

    public static ListNode findMiddleNode(ListNode head) {
        // Initialize two pointers, slow and fast
        ListNode slow = head; // Moves one step at a time
        ListNode fast = head; // Moves two steps at a time

        // Traverse the list until fast or its next node is null
        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow pointer one step
            fast = fast.next.next; // Move fast pointer two steps
        }

        // When the loop ends, slow pointer will be at the middle node
        return slow;
    }
}
