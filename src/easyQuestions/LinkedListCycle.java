package easyQuestions;



public class LinkedListCycle {
    /**
     Given head, the head of a linked list, determine if the linked list has a cycle in it.
     There is a cycle ina linked list if there is some node that can be reached again by
      continuously following the next pointer. Internally, pos is used to denote the index of the node
     that tail's next pointer is connected to. Note that pos is not passed as a parameter.

     Return true if there is a cycle in the linked list. Otherwise, return false.
     */
// o(n)
    public  boolean linkedListCycle(ListNode head){
        ListNode checkNode = head;
        while (
                checkNode != null && checkNode.next != null
        ) {
            checkNode = checkNode.next;
            return true;
        }

        return false;
    }

    public boolean linkedListCycle2(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if (slow ==  fast){
            return true;
        }
        return false;
    }

}
