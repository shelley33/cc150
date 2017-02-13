package Chapter1;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/2/13.
 */
public class RotateMatrix {
	public int[][] solution(int[][] matrix){
		rotation(matrix, 0, matrix.length);

		return matrix;
	}
	
	private void rotation(int[][] matrix, int start, int end){
		if (start >= end) return;
		int tmp = 0;
		for (int i = start; i < end - 1; i++){
			tmp = matrix[i][end - 1];
			matrix[i][end - 1] = matrix[start][i];
            matrix[start][i] = tmp;

			tmp = matrix[end - 1][end - i - 1];
            matrix[end - 1][end - i - 1] = matrix[start][i];
            matrix[start][i] = tmp;

			tmp = matrix[end - i - 1][start];
			matrix[end - i - 1][start] = matrix[start][i];
            matrix[start][i] = tmp;
		}
		
		rotation(matrix, start + 1, end - 1);
	}

	public static void main(String[] args){
	    RotateMatrix object = new RotateMatrix();
        int[][] matrix = new int[][]{
                { 1,2,3,4 },
                { 5,6,7,8 },
                { 9,10,11,12 },
                { 13,14,15,16 }
        };

	    System.out.print(Arrays.deepToString(object.solution(matrix)));
    }
}
