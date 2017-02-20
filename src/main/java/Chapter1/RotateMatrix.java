package Chapter1;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/2/13.
 */
public class RotateMatrix {
	public int[][] solution(int[][] matrix){
		rotation(matrix, 0);

		return matrix;
	}
	
	private void rotation(int[][] matrix, int start){
		if (start >= matrix.length - start) return;
		int tmp;
		for (int i = start; i < matrix.length - start - 1; i++){
			tmp = matrix[start][i];
			matrix[start][i] = matrix[matrix.length - i - 1][start];
            matrix[matrix.length - i - 1][start] = matrix[matrix.length - start - 1][matrix.length - i - 1];
            matrix[matrix.length - start - 1][matrix.length - i - 1] = matrix[i][matrix.length - start - 1];
            matrix[i][matrix.length - start - 1] = tmp;
		}
		
		rotation(matrix, start + 1);
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
