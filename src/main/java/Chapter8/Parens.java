package Chapter8;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bresai on 2017/2/28.
 */
public class Parens {

    public List<String> solution(int n){
        List<String> result = new ArrayList<>();
        recur(0, 0, result, n, "");
        return result;
    }

    private void recur( int open, int close, List<String> result, int n, String string){
        if (open == n && close == n) {
            result.add(string);
            return;
        }
        if (open < n){
            recur(open + 1, close, result, n, string + "(");
        }
        if (open > close){
            recur(open, close + 1, result, n, string + ")");
        }

    }

    public static void main(String[] args) {
        Parens parens = new Parens();
        System.out.println(parens.solution(3));
    }
}
