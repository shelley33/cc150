package Chapter8;

/**
 * Created by bresai on 2017/2/27.
 */
public class RecursiveMultiply {

    public int solution(int a, int b){
        return recur(Math.min(a, b), Math.max(a,b));
    }

    private int recur(int smaller, int bigger){
        if (smaller == 0) return 0;
        if (smaller == 1) return bigger;

        int tmp = recur(smaller >> 1, bigger);

        if (smaller % 2 == 0){
            return tmp + tmp;
        }else{
            return tmp + tmp + bigger;
        }
    }

    public static void main(String[] args) throws Exception{
        RecursiveMultiply multiply = new RecursiveMultiply();

        System.out.print(multiply.solution(123,1232));
    }

}
