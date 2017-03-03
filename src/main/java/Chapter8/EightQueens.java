package Chapter8;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bresai on 2017/2/28.
 */
public class EightQueens {
    List<List<Integer>> result;
    int queens = 8;
    public void solution(int n){
        result = new ArrayList<>();
        recur(0, new ArrayList<>(), n);
    }

    private void recur(int row, List<Integer> column, int n){
        if (row == queens) {
            result.add(column);
            return;
        }

        for (int i = 0; i < n; i++){
            if (! checkValid(row, i, column)) continue;

            List<Integer> tmp = new ArrayList<>(column);
            tmp.add(i);
            recur(row + 1, tmp, n);
        }
    }

    private boolean checkValid(int r1, int c1, List<Integer> queens){
        for (int i = 0; i < queens.size(); i++){
            if ( queens.get(i) == c1 ) return false;
            if ( Math.abs(r1 - i) == Math.abs(c1 - queens.get(i))) return false;
        }

        return true;
    }


    public static void main(String[] args) throws Exception{
        EightQueens queens = new EightQueens();
        queens.solution(8);
        System.out.print(queens.result);
    }

}