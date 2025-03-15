import easyQuestions.*;

import java.util.List;

public class Runner {
    public static void main(String[] args) {

        int[] array = {3,9,5,2,4,1,7,8,6};
        int[] missingNumbersArray = {2,1,4,5,5,8,9};

//        for (int i : array){
//            System.out.print(i+ " ");
//
//        }
//        System.out.println();
//        QuickSort quickSort = new QuickSort();
//
//        quickSort.quickSort( array, 0, array.length-1);
//
//        for (int i : array){
//            System.out.print(i+ " ");
//
//        }
        // Example points (You can replace it with your input)
        List<int[]> points = List.of(
                new int[] {1, 1},
                new int[] {3, 4},
                new int[] {-1, 0}
        );


        MissingNumber missingNumber = new MissingNumber();

        missingNumber.findMissingNumbers(missingNumbersArray);
        System.out.println();

        MinimumTimeVisitingAllPoints minimumTimeVisitingAllPoints = new MinimumTimeVisitingAllPoints();

       int result = minimumTimeVisitingAllPoints.minTimeToVisitAllPoints2(points);
        System.out.println(result);

        int[] prices = {4,1,2,6,8,7,0,3};

        BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();

        System.out.println( "break");

        bestTimeToBuyAndSellStock.maxProfit(prices);

        System.out.println();

        int[] sortedArray = {1,2,3,4,5,6};

        SquaresOfaSortedArray squaresOfaSortedArray = new SquaresOfaSortedArray();

        squaresOfaSortedArray.squaresOfaSortedArray(sortedArray);
        System.out.println();
        squaresOfaSortedArray.squaresOfaSortedArray2(sortedArray);

        System.out.println();

        int[] array1 = {1,2,2,3,4,3,5,5,1};
        BitManipulation bitManipulation = new BitManipulation();

       int result1 =   bitManipulation.bitManipulation(array1);
        System.out.println(result1);

    }
}
