package easyQuestions;

public class PlindromeLinkedList {
    /**
     Given the head of a singly linked list, return true if it is a palindrome or false otherwise
     */

//    public boolean palindromeLinkedList(ListNode head){
//        ListNode testHead = head;
//
//        while (head.next != null){
//            continue;
//            if (testHead.val == head.val){
//                return true;
//            }
//        }
//
//        return false;
//    }

//    o(n) o(1) space
    public boolean palindromeLinkedList2(ListNode head) {
        if (head == null || head.next == null) {
            return true; // A single node or empty list is a palindrome.
        }

        // Step 1: Find the middle of the linked list.
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the linked list.
        ListNode prev = null;
        while (slow != null) {
            ListNode nextTemp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nextTemp;
        }

        // Step 3: Compare the first and the reversed second half.
        ListNode firstHalf = head;
        ListNode secondHalf = prev;
        while (secondHalf != null) {
            assert firstHalf != null;
            if (firstHalf.val != secondHalf.val) {
                return false; // Not a palindrome.
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true; // The list is a palindrome.
    }

}
