package Chapter5;

/**
 * Created by bresai on 2017/2/21.
 */
public class BinaryToString {
    public String solution(double num){
        StringBuilder res = new StringBuilder();
        int count = 0;
        while (num != 0){
            if (count >= 32) return "ERROR";
            num = num * 2;
            if ((int) num == 1){
                res.append("1");
                num -= 1;
            }else{
                res.append("0");
            }
            count++;
        }

        return res.toString();
    }

    public static void main(String[] args) {
        BinaryToString object = new BinaryToString();
        System.out.print(object.solution(0.11));
    }

}
