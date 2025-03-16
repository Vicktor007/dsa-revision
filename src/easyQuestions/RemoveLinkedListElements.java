package easyQuestions;

public class RemoveLinkedListElements {
    /**
     Given the head of a linked list and an integer val, remove all the nodes of
     the linked list that has Node.val == val, and return the new head.
     */

//    o(n) time o(1) space

    public ListNode removeLinkedListElements(ListNode head, int value){
//         create a dummy head pointing to the actual head
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
// set the current node to the dummy head to also check if the head is the value
        ListNode currentNode = dummyHead;
        while (currentNode.next != null){
            if (currentNode.next.val == value){
//                if the current node value is the value swap the values to exclude the current value
               currentNode.next = currentNode.next.next;
            } else {
//                go to the next node if it is not
                currentNode = currentNode.next;
            }
        }
//        return the current head
        return dummyHead.next;
    }
}
