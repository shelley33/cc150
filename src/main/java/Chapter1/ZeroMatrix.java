package Chapter1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by bresai on 2017/2/14.
 */
public class ZeroMatrix {
    public int[][] solution(int[][] matrix){
    	Set<Integer> column = new HashSet<>();
    	Set<Integer> row = new HashSet<>();
    	int m = matrix.length;
    	int n = matrix[0].length;

    	for (int i = 0; i < m; i++){
    		for (int j = 0; j < n; j++){
    			if (matrix[i][j] == 0) {
    				row.add(i);
    				column.add(j);
    			}
    		}
    	}

    	for (int i : row){
    		for (int j = 0; j < n; j++){
    			matrix[i][j] = 0;
    		}
    	}

    	for (int i : column){
    		for (int j = 0; j < m; j++){
    			matrix[j][i] = 0;
    		}
    	}

    	return matrix;
    }

    public static void main(String[] args){
    	ZeroMatrix object = new ZeroMatrix();
    	int[][] matrix = new int[][]{
    		{0,1,2,3,4},
    		{1,2,3,4,6},
    		{2,4,0,4,5}
    	};

    	System.out.print(Arrays.deepToString(object.solution(matrix)));
    }
}
