package Chapter8;

import java.util.*;

/**
 * Created by bresai on 2017/3/1.
 */
public class BooleanEvaluation {
    Map<String, Integer> cache;
    public int soluton(String expression, boolean result){
        if (! validExpression(expression)) return -1;
        cache = new HashMap<>();
        return recur(expression, result);
    }

    private int recur(String expression, boolean result){
        if (cache.containsKey(expression + result)) return cache.get(expression + result);

        if (expression.length() == 1) {
            return equal(Integer.valueOf(expression), result)? 1 : 0;
        }

        int count = 0;
        for (int i = 1; i < expression.length(); i += 2){
            char operation = expression.charAt(i);

            int leftTrue = recur(expression.substring(0, i), true);
            int leftFalse = recur(expression.substring(0, i), false);
            int rightTrue = recur(expression.substring(i + 1), true);
            int rightFalse = recur(expression.substring(i + 1), false);

            switch (operation){
                case '&':
                    if (result){
                        count += leftTrue * rightTrue;
                    } else{
                        count += leftTrue * rightFalse;
                        count += leftFalse * rightTrue;
                        count += leftFalse * rightFalse;
                    }
                    break;
                case '|':
                    if (! result){
                        count += leftFalse * leftFalse;
                    } else{
                        count += leftTrue * rightFalse;
                        count += leftFalse * rightTrue;
                        count += leftTrue * rightTrue;
                    }
                    break;
                case '^':
                    if (result){
                        count += leftTrue * rightFalse;
                        count += leftFalse * rightTrue;
                    }else{
                        count += leftFalse * rightFalse;
                        count += leftTrue * rightTrue;
                    }
                    break;
                default:break;
            }

        }

        cache.put(expression + result, count);
        return count;
    }

    private boolean validExpression(String expression){
        Set<Character> values = new HashSet<>(Arrays.asList('1', '0'));
        Set<Character> operation = new HashSet<>(Arrays.asList('|', '&', '^'));

        if (expression.length() % 2 == 0) return false;
        for (int i = 0; i < expression.length(); i +=2){
            if (! values.contains(expression.charAt(i))) return false;
        }

        for (int i = 1; i < expression.length(); i +=2){
            if (! operation.contains(expression.charAt(i))) return false;
        }

        return true;
    }

    private boolean equal(int expression, boolean result){
        int res = result ? 1 : 0;
        return res == expression;
    }

    public static void main(String[] args) {
        BooleanEvaluation evaluation = new BooleanEvaluation();
        System.out.println(evaluation.soluton("1^0|0|1", false));
        System.out.println(evaluation.soluton("0&0&0&1^1|0", true));
    }
}
