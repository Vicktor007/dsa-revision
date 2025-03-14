package easyQuestions;

import java.util.List;

public class MinimumTimeVisitingAllPoints {

/**
 On a 2d plane, there are n points wit integer coordinates points[i] = [x,y], return the minimum time in seconds to visit all the points in the order given by points
 You can move according to these rules:
 in 1 second, you can either
 1. move vertically by one unit,
 2. move horizontally by one unit or,
 3. move diagonally sqrt(2) units (in other words, move one unit
 vertically, then one unit horizontally in 1 second).
 You have to visit the points in the same order as they appear in the array.
 You are allowed to pass through points that appear later in the order,but these do not count as visits.
 */




        public int minTimeToVisitAllPoints(List<int[]> points) {
            int res = 0;

            // Extract the starting point (x1, y1)
            int[] current = points.get(0);

            for (int i = 1; i < points.size(); i++) {
                int[] next = points.get(i);

                // Calculate the movement cost using Chebyshev distance
                res += Math.max(Math.abs(next[0] - current[0]), Math.abs(next[1] - current[1]));

                // Update current to the next point
                current = next;
            }

            return res;
        }


        public int minTimeToVisitAllPoints2(List<int[]> points){
            int result = 0;
//            extract the starting point(x1, y1)
            int[] currentPoints = points.getFirst();
            for (int i = 1; i<points.size(); i++){
                int[] nextPoints = points.get(i);

//                calculate the movement cost using chebyshev distance
                result += Math.max(Math.abs(nextPoints[0] - currentPoints[0]), Math.abs(nextPoints[1] - currentPoints[1]));
//                update current points to the next points
                currentPoints = nextPoints;
            }
            return result;
        }





}
