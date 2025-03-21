package MediumQuestions;

import java.util.Arrays;

public class TaskSheduler {
    /**
    Task Scheduler

     You are given an array of CPU tasks, each represented by letters A to Z,
     and a cooling time, n. Each cycle or interval allows the completion of one task.
     Tasks can be completed in any order, but there's a constraint:
     identical tasks must be separated by at least n intervals due to cooling time.
     Return the minimum number of intervals required to complete all tasks.
     */

    /**
     Explanation:
     Frequency Count:

     We count the frequency of each task using an array taskCounts of size 26 (for the 26 uppercase English letters).

     Sort Tasks:

     The taskCounts array is sorted in descending order, which allows us to identify the most frequent task.

     Idle Slots Calculation:

     The most frequent task determines the structure of the intervals. If its frequency is maxFreq, then we need at least (maxFreq - 1) * n idle slots to separate these tasks properly.

     Fill Idle Slots:

     We iterate through the other tasks and use their frequencies to fill the idle slots.

     Total Intervals:

     The result is the sum of the total number of tasks and the remaining idle slots. If there are no idle slots, the intervals equal the total number of tasks.

     Complexity:
     Time Complexity: O(N + 26 log 26) (counting tasks and sorting the frequencies). This simplifies to O(N) since 26 is constant.

     Space Complexity: O(1) (constant space for the taskCounts array).

     This is a clean and efficient way to solve the problem while adhering to the constraints.
     */

    public int leastInterval(char[] tasks, int n){
        // Step 1: Count the frequency of each task
        int[] taskCounts = new int[26];
        for (char task : tasks){
            taskCounts[task - 'A']++;
        }
// Step 2: Sort the task counts in descending order
        Arrays.sort(taskCounts);

        // Step 3: Determine the most frequent task and calculate the idle slots
        int maxFreq = taskCounts[25];// Most frequent task
        int idleSlots = (maxFreq - 1) * n;

// Step 4: Fill the idle slots with other tasks
        for (int i = 24; i >= 0 && idleSlots > 0; i-- ){
            idleSlots -= Math.min(maxFreq - 1, taskCounts[i]);
        }
        // Step 5: Ensure the total intervals is not less than the number of tasks
        idleSlots = Math.max(0, idleSlots);
        return tasks.length + idleSlots;
    }
}
