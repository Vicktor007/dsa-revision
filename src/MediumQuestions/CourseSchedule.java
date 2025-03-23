package MediumQuestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    /**
   Course Schedule

     There are a total of numCourses courses you have to take, labeled from to numCourses 1. You are given an array prerequisites where prerequisites [i] = [a, b₁] indicates that you must take course bi first if you want to take course a.
     • For example, the pair [0, 1], indicates that to take course you have to first take course 1.
     Return true if you can finish all courses. Otherwise, return false.
     */

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create adjacency list and in-degree array
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prereq = pair[1];
            graph.get(prereq).add(course);
            inDegree[course]++;
        }

        // Initialize a queue for BFS
        Queue<Integer> queue = new LinkedList<>();

        // Add all nodes with 0 in-degree (no prerequisites)
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int visitedCourses = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            visitedCourses++;

            for (int neighbor : graph.get(current)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // Check if all courses have been visited
        return visitedCourses == numCourses;
    }

    /**
     Explanation:
     Graph Representation:

     The graph is represented as an adjacency list, where each course points to the courses that depend on it.

     The inDegree array tracks how many prerequisites each course has.

     Topological Sort:

     Courses with an inDegree of 0 (no prerequisites) are added to the queue.

     As each course is "taken," its dependent courses (neighbors) have their inDegree decremented.

     If a dependent course's inDegree becomes 0, it's added to the queue.

     Cycle Detection:

     If all courses are visited (visitedCourses == numCourses), the graph has no cycles, and it's possible to complete all courses.

     If not, the graph contains cycles, making it impossible to finish all courses.
     */

}
