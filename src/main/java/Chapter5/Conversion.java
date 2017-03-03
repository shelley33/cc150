package Chapter5;

/**
 * Created by bresai on 2017/2/22.
 */
public class Conversion {
    public int solution(int a, int b){
        int count = 0;
        while (a != 0 || b != 0){
            if ( (a & 1) != (b & 1)) count++;
            a >>>= 1;
            b >>>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        Conversion conversion = new Conversion();
        System.out.println(conversion.solution(1,13));
    }
}
