package MediumQuestions;

 class ListNode {
    int val; // Value of the node
    ListNode next; // Reference to the next node

    // Constructor to initialize the node
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class ReversedLinkdListTwo {
    /**
     Given the head of a singly linked list and two integers left and right
     where lef<= right, reverse the nodes of the list from position left to position right,
     and return the reversed list.
     */

   public ListNode reversedLinkedListTwo(ListNode head, ListNode left, ListNode Right){

       ListNode dummyHead = head;
       while (head != null){
           if (head.val == left.val){
               ListNode temp = left;
               left.val = left.next.next.val;
               left.next.next.val = temp.val;
           }
           head = head.next;
       }
       return dummyHead;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public class ReverseLinkedListII {

        public ListNode reverseBetween(ListNode head, int left, int right) {
            // Step 1: Create a dummy node to simplify edge cases (like reversing from the head)
            ListNode dummy = new ListNode(0);
            dummy.next = head;

            // Step 2: Use a pointer (prev) to traverse the list up to the node before the 'left' position
            ListNode prev = dummy;
            for (int i = 1; i < left; i++) {
                prev = prev.next; // Move the pointer forward
            }

            // Step 3: Mark the start node of the sublist that needs to be reversed
            ListNode current = prev.next;

            // Step 4: Reverse the sublist from 'left' to 'right' position
            for (int i = 0; i < right - left; i++) {
                // Store the node after 'current' temporarily
                ListNode temp = current.next;

                // Adjust pointers to reverse the links
                current.next = temp.next;
                temp.next = prev.next;
                prev.next = temp;
            }

            // Step 5: Return the updated list starting from the dummy node's next
            return dummy.next;
        }
    }

}

