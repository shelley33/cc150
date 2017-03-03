package Chapter8;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bresai on 2017/2/28.
 */
// TODO: 2017/2/28 important
public class Coins {
    public int solution(int n){
        Map<Integer, Integer> cache = new HashMap<>();
        int[] coins = {25,10,5,1};
        return recur(n, coins,0, cache);
    }

    private int recur(int left, int[] coins, int coinType, Map<Integer, Integer> map){
        if (coinType >= coins.length - 1) return 1;

        int total = 0;
        for (int i = 0; coins[coinType] * i <= left; i++){
            total +=recur(left - coins[coinType] * i, coins, coinType + 1, map);
        }

        return total;
    }

    public static void main(String[] args) {
        Coins coins = new Coins();

        System.out.print(coins.solution(6));
    }
}
