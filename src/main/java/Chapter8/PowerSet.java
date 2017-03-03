package Chapter8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by bresai on 2017/2/27.
 */
public class PowerSet {
    List<List<Integer>> result;

    public List<List<Integer>> solution(List<Integer> set){
        result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        result.add(subset);
        recur(0, set);

        return result;
    }

    private List<List<Integer>> deepCopy(List<List<Integer>> source){
        List<List<Integer>> tmp = new ArrayList<>();
        for ( List<Integer> set : source){
            tmp.add(new ArrayList<>(set));
        }

        return tmp;
    }

    private void recur(int length, List<Integer> set){
        if (set.size() == length) return;

        List<List<Integer>> subsets = deepCopy(result);

        for (List<Integer> subset : subsets){
            subset.add(set.get(length));
            result.add(subset);
        }

        recur(length + 1, set);
    }

    public static void main(String[] args) throws Exception{
        List<Integer> set = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        PowerSet powerSet = new PowerSet();
        powerSet.solution(set);

        System.out.println(powerSet.result);
    }

}
