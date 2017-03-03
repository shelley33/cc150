package Chapter8;

/**
 * Created by bresai on 2017/2/27.
 */
public class MagicIndex {
    public int solution(int[] array){
        return recur(array, 0, array.length - 1);
    }

    private int recur(int[] array, int start, int end){
        if (end < start) return -1;

        int middle = (start + end) >> 1;

        if (middle == array[middle]) return middle;

        if (middle > array[middle]){
            return recur(array, middle + 1, end);
        } else{
            return recur(array, start, middle - 1);
        }
    }

    public static void main(String[] args) {
        int[] array = {-10, -9, -8, 0, 4, 5, 9, 10, 11};
        MagicIndex magicIndex = new MagicIndex();
        System.out.println(magicIndex.solution(array));
    }
}
