package Chapter5;

/**
 * Created by bresai on 2017/2/21.
 */
public class Insertion {
    public int solution(int n, int m, int i, int j){
        int count = 0;
        for(int k = i; k <= j; k++){
            int bit = getBit(m, count);
            count++;
            n = setBit(n, bit, k);
        }

        return n;
    }

    private int getBit(int num, int pos){
        return (num & (1 << pos)) >> pos;
    }

    private int setBit(int num, int bit, int pos){
        if (bit == 1){
            return num | (1 << pos);
        }else{
            return num & ~(1 << pos);
        }

    }

    public static void main(String[] args) {
        Insertion object = new Insertion();
        System.out.println(object.solution(1024, 19, 2, 6));
    }
}
