package Chapter10;

/**
 * Created by bresai on 2017/3/2.
 */
public class SearchRotatedArray {
    public int solution(int[] array, int num){
        if (array.length == 0) return -1;

        return binarySearch(array, 0, array.length - 1, num);
    }

    private int binarySearch(int[] array, int start, int end, int num){
        if (start > end) return -1;
        if (start == end) return num == array[start] ? start : -1;

        int middle = (start + end) >> 1;
        if (array[middle] == num) return middle;

        int left = -1; int right = -1;
        if (start < middle){//left is normal order
            if (num > middle){
                right = binarySearch(array, middle + 1, end, num);
            } else{
                left = binarySearch(array, start, middle - 1, num);
                right = binarySearch(array, middle + 1, end, num);
            }
        } else{
            if (num < middle){
                left = binarySearch(array, start, middle - 1, num);
            }else{
                left = binarySearch(array, start, middle - 1, num);
                right = binarySearch(array, middle + 1, end, num);
            }
        }

        if (left != -1) return left;
        if (right != -1) return right;

        return -1;
    }
}
