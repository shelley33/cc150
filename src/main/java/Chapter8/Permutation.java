package Chapter8;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bresai on 2017/2/28.
 */
public class Permutation {

    public List<String> permutation(String input){
        return recur(input, input.length() - 1);
    }

    private List<String> recur(String string, int length){
        if (length == 0) {
            List<String> list = new ArrayList<>();
            list.add(string.substring(0, 1));
            return list;
        }

        List<String> list = recur(string, length - 1);

        List<String> result = new ArrayList<>();
        for (String candidate : list){
            for (int i = 0; i <= length; i++){
                result.add(addCharAt(i, candidate, string.charAt(length)));
            }
        }

        return result;

    }

    private String addCharAt(int index, String string, char c){
        return string.substring(0, index) + c + string.substring(index, string.length());
    }

    public static void main(String[] args) throws Exception{
        Permutation permutation = new Permutation();
        System.out.print(permutation.permutation("abcd"));
    }

}
