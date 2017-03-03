package Chapter5;

/**
 * Created by bresai on 2017/2/21.
 */
public class FlipBitToWin {
    public int solution(int num){
        int max = 1;
        int first = 0;
        int second = 0;
        boolean flipped = false;
        for (int i = 0; i < Integer.BYTES * 8 && num > 0; i++){
            if ( (num & 1) == 1) {
                if (flipped){
                    second++;
                }
                first++;
            }
            else if (! flipped){
                flipped = true;
                first++;
            }
            else{
                max = Math.max(first,max);
                first = second + 1;
                second = 0;
            }

            num >>>= 1;
        }

        return Math.max(first, max);
    }

    public static void main(String[] args) {
        FlipBitToWin object = new FlipBitToWin();
        System.out.print(object.solution(32));
    }

}
