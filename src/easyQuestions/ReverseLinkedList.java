package easyQuestions;

import java.util.ArrayList;
import java.util.List;

public class ReverseLinkedList {
    /**
     Given the head of a singly linked list, reverse the list, return the reversed list.
     */
//    0(n)
//    0(1)
    public void reverseLinkedList(ListNode head){

  ListNode previousNode = null;
  ListNode currentNode = head;

  while (currentNode != null){
//      move the next pointer
      ListNode nextPointer = currentNode.next;

//      move lnk to previous node
      currentNode . next = previousNode;
//      update current and previous nodes
      previousNode =currentNode;
      currentNode = nextPointer;
  }
  head = previousNode;

    }
}
