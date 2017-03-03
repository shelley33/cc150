package Chapter6;

import java.util.*;

/**
 * Created by bresai on 2017/2/23.
 */
public class EggDrop {
    Set<Integer> result;
    Integer[] cache;
    public int solution(int levels){
        cache = new Integer[levels + 1];
        result = new HashSet<>();
        return recursive(levels);
    }

    private int recursive(int totalLevel){
        if (cache[totalLevel] != null) return cache[totalLevel];

        if (totalLevel == 0) return 0;

        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 1; i <= totalLevel; i++){
            int tmp = recursive(totalLevel - i);
            int current = Math.max(i - 1, tmp);
            if ( current + 1 < min){
                min = current + 1;
                index = i;
            }
        }

        cache[totalLevel] = min;
        result.add(100 - totalLevel + index);
        return min;
    }

    public static void main(String[] args) {
        EggDrop eggDrop = new EggDrop();

        eggDrop.solution(100);
        List<Integer> list = new ArrayList<>();
        list.addAll(eggDrop.result);
        Collections.sort(list);
        System.out.println(list);
        System.out.print(Arrays.toString(eggDrop.cache));
    }
}
