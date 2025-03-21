package MediumQuestions;

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    /**
     K Closest Points to Origin

     Given an array of points where points [i] = [x1, y1] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).
     The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(X1X2)2 + (У1 У2)2).
     You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
     */

//    This approach has a time complexity of O(N * log k), where N is the number of points,
//    because we insert into the heap at most N times, and each insertion/removal operation is O(log k).

    public int[][] kClosest(int[][] points, int k){
//        Define a priority queue (max-heap) that sorts by Euclidean distance in descending order
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a,b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1])
        );
        // Iterate through each point
        for (int[] point : points){
            maxHeap.offer(point);// Add the current point to the heap
            if (maxHeap.size() > k){
                maxHeap.poll();// Remove the farthest point if heap size exceeds k
            }
        }
        // Create a result array to store the k closest points
        int[][] result = new int[k][2];
        for (int i  = 0; i< k; i++){
            result[i] = maxHeap.poll();
        }
        return result;
    }
}
