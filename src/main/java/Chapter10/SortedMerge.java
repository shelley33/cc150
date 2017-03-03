package Chapter10;

import java.util.Arrays;

/**
 * Created by bresai on 2017/3/2.
 */
public class SortedMerge {
    public void solution(int[] a, int[] b, int aLength, int bLength){
        if (a.length < aLength + bLength) return;

        int totalLength = aLength + bLength - 1;
        while(aLength > 0 && bLength > 0){
            a[totalLength--] = a[aLength - 1] > b[bLength - 1] ?
                    a[aLength-- - 1] : b[bLength-- - 1];
        }

        while (bLength > 0){
            a[totalLength--] = b[bLength-- - 1];
        }

    }

    public static void main(String[] args) throws Exception{
        boolean x = ((-1 & (1 << 31)) ^ (1 & (1 << 31))) > 0;

        SortedMerge sortedMerge = new SortedMerge();
        int[] a = {1,3,5,7,9,11,12,0,0,0,0,0,0,0};
        int[] b = {2,4,6,8,10};

        sortedMerge.solution(a,b, 7, 5);
        System.out.println(Arrays.toString(a));
    }

}
