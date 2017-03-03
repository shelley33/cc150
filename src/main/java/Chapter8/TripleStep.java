package Chapter8;

/**
 * Created by bresai on 2017/2/27.
 */
public class TripleStep {

    public int solution(int n){
        Integer[] cache = new Integer[n + 1];
        return recur(n, cache);
    }

    private int recur(int n, Integer[] cache){
        if (n < 0) return 0;
        if (n == 0) return 1;

        if ( cache[n] != null) return cache[n];

        int combination = 0;
        combination += recur(n - 1, cache);
        combination += recur(n - 2, cache);
        combination += recur(n - 3, cache);

        cache[n] = combination;

        return combination;
    }

    public static void main(String[] args) {
        TripleStep step = new TripleStep();
        System.out.print(step.solution(36));
    }

}
