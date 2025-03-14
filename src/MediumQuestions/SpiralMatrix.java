package MediumQuestions;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
/**
 *Given an n * n matrix return all elements of the matrix in spiral order
 */

public List<Integer> spiralOrder(int[][] matrix){
    List<Integer> result = new ArrayList<>();
//    return an empty lis if the matrix is empty
    if(matrix == null || matrix.length == 0){
        return result;
    }

    int top = 0;
    int bottom = matrix.length - 1;
    int left = 0;
    int right = matrix[0].length-1;

    while (top<= bottom && left <= right){
//        traverse rom left to right along the top row
        for (int i = left; i <= right; i++){
            result.add(matrix[top][i]);
        }
//        move down the top boundary
        top++;
//        Traverse from top to bottom along the right column
        for (int i = top; i<= bottom;i++){
            result.add(matrix[i][right]);

        }
//        move left the right boundary
        right--;
        if(top <= bottom){
//            Traverse from right to left along the bottom row
            for (int i = right; i >= left; i--){
                result.add(matrix[bottom][i]);
            }
//            move up the bottom boundary
            bottom--;

        }
        if (left <= right){
//            Traverse from bottom to top along te left column
            for (int i = bottom; i >= top; i--){
                result.add(matrix[i][left]);
            }
            left++;
        }
    }
    return result;
}
}
