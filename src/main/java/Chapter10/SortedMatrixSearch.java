package Chapter10;

/**
 * Created by bresai on 2017/3/3.
 */
public class SortedMatrixSearch {
    public int[] solution(int[][] matrix, int target){
        return null;
    }

    private int[] recur(int[][] matrix, int target, int columnStart, int columnEnd, int rowStart, int rowEnd){

        if (columnStart == columnEnd && rowStart == rowEnd) {
            if(matrix[rowStart][columnStart] == target){
                return packResult(rowStart, columnStart);
            } else {
                return null;
            }
        }

        int columnMiddle = (columnStart + columnEnd) >> 1;
        int rowMiddle = (rowStart + rowEnd) >> 1;

        int[] result = null;
        if (target < matrix[rowMiddle][columnMiddle]){
            result = recur(matrix, target, columnStart, columnMiddle - 1, rowStart, rowMiddle - 1);
            if (result != null) return result;
            result = recur(matrix, target, columnStart, columnMiddle - 1, rowMiddle, rowEnd);
            if (result != null) return result;
            result = recur(matrix, target, columnMiddle, columnEnd, rowStart, rowMiddle - 1);
        }else{
            result = recur(matrix, target, columnMiddle - 1, columnEnd, rowMiddle - 1, rowEnd);
            if (result != null) return result;
            result = recur(matrix, target, columnStart, columnMiddle, rowMiddle - 1, rowEnd);
            if (result != null) return result;
            result = recur(matrix, target, columnMiddle - 1, columnEnd, rowStart, rowMiddle);
        }
        return result;
    }

    private int[] packResult(int row, int column){
        int[] result = new int[2];
        result[0] = row;
        result[1] = column;
        return result;
    }
}
