package MediumQuestions;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    /**
  Kth Largest Element in an Array
Given an integer array nums and an integer k, return the kith largest element in the array.
 Note that it is the kth largest element in the sorted order, not the kth distinct element.
Can you solve it without sorting?
     */

//    time = 0(n log k)

    public int findKthLargest(int[] nums, int k){
//         create a mi-heap with a size of k
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        for (int num : nums){
            minHeap.add(num);
//            if the heap size exceeds k, remove the smallest element
            if (minHeap.size() > k){
                minHeap.poll();
            }
        }
//        the top of the heap is the kth largest element
        return minHeap.peek();
    }
}
