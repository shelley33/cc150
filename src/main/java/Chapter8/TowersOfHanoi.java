package Chapter8;

import java.util.Stack;

/**
 * Created by bresai on 2017/2/27.
 */
public class TowersOfHanoi {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    Stack<Integer> stack3;

    public Stack<Integer> solution(int n){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        stack3 = new Stack<>();

        for (int i = n - 1; i >= 0; i--){
            stack1.push(i);
        }

        moveToTarget(stack1, stack3, stack2, n);

        return stack3;
    }

    private void moveToTarget(Stack<Integer> src, Stack<Integer> dest, Stack<Integer> cache, int n){

        if (n <= 0) return;

        moveToTarget(src, cache, dest, n - 1);

        Integer item = src.pop();
        dest.push(item);

        moveToTarget(cache, dest, src, n - 1);

    }

    public static void main(String[] args) throws Exception{
        TowersOfHanoi towersOfHanoi = new TowersOfHanoi();
        towersOfHanoi.solution(5);
        System.out.println( "" );
    }

}
