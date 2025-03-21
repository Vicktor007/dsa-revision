package MediumQuestions;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    /**
     Given an integer array and an integer k, return the k most frequent
     elements. You may return the answer in any order.
     */

    /**
     Explanation:
     Frequency Map:

     A HashMap is used to store the frequency of each element in the input array.

     Min-Heap:

     A priority queue (min-heap) is used to keep track of the top k elements with the highest frequency.

     The comparator ensures the heap maintains elements in ascending order of frequency. If the size of the heap exceeds k, the least frequent element is removed.

     Extract Results:

     Once all elements are processed, the heap contains the k most frequent elements, which are extracted into the result array.

     Time Complexity:
     O(N log k):

     Constructing the frequency map takes O(N).

     Inserting into the heap takes O(log k) for each of the N elements.

     This is an efficient solution that handles the task with optimal performance!
     */

    public int[] topKFrequent(int[] nums, int k){
        // Step 1: Use a HashMap to store the frequency of each element
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums){
            frequencyMap.put(num, frequencyMap.getOrDefault(num,0)+1);
        }
// Step 2: Use a PriorityQueue (min-heap) to keep track of the top k elements
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
                (a, b) -> a.getValue() - b.getValue()
                // Sort by frequency (ascending order)
        );
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()){
            minHeap.offer(entry);
            if (minHeap.size() > k){
                minHeap.poll(); // Remove the least frequent element if heap size exceeds k
            }
        }
        // Step 3: Extract the top k elements from the heap
        int[] result = new int[k];
        for (int i = 0; i < k; i++){
            result[i] = minHeap.poll().getKey();
        }
        return result;
    }
}
