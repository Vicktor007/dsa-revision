package easyQuestions;

public class MergeTwoSortedLists {
    /**

     you are given the heads of two sorted linked lists list1 and list2.
     Merge the two lists into one sorted list. The list should be made by splicing together
     the nodes of the first two lists.
     Return the head of the merged linked list.
     */

    public ListNode mergeTwoLinkedLists(ListNode head1, ListNode head2){
        ListNode head = new ListNode(0);
       while (head1 != null && head1.next != null){
            head1 = head1.next;
        }
       head1.next =head2;

       return head1;
    }

    public ListNode mergeTwoLinkedLists2(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0); // Dummy node to simplify edge cases
        ListNode current = dummy;        // Pointer for building the merged list

        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                current.next = head1;    // Attach the smaller node
                head1 = head1.next;      // Move the pointer forward
            } else {
                current.next = head2;
                head2 = head2.next;
            }
            current = current.next;      // Move the current pointer forward
        }

        // Attach the remaining nodes, if any
        if (head1 != null || head2 != null) {
            current.next = (head1 != null) ? head1 : head2;
        }

        return dummy.next; // Return the merged list, skipping the dummy node
    }

}
