package Chapter5;

import java.util.Arrays;

/**
 * Created by bresai on 2017/2/22.
 */
public class NextNumber {
    public int[] solution(int input){

        int[] res = new int[2];
        boolean findOne = false;
        boolean findZero = false;
        int num = input;
        for (int i = 0; i < Integer.BYTES * 8 && num >0; i++){
            if ((num & (1 << i)) > 0) {
                if (! findOne) {
                    num = clearBit(num, i);
                    findOne = true;
                    continue;
                }
            }

            if ((num & (1 << i)) == 0) {
                if (findOne) {
                    num = setBit(num, i);
                    res[0] = num;
                    break;
                }
            }
        }

        num = input;

        for (int i = 0; i < Integer.BYTES * 8 && num >0; i++){
            if ((num & (1 << i)) == 0) {
                if (! findZero) {
                    num = setBit(num, i);
                    findZero = true;
                    continue;
                }
            }

            if ((num & (1 << i)) > 0) {
                if (findZero) {
                    num = clearBit(num, i);
                    res[1] = num;
                    break;
                }
            }
        }

        return res;
    }

    private int clearBit(int num, int index){
        return num & ~(1 << index);
    }

    private int setBit(int num, int index){
        return num | (1 << index);
    }

    public static void main(String[] args) throws Exception{
        NextNumber nextNumber = new NextNumber();
        System.out.print(Arrays.toString(nextNumber.solution(14)));
    }

}
