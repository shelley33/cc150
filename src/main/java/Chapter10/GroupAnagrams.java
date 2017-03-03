package Chapter10;

import java.util.*;

/**
 * Created by bresai on 2017/3/2.
 */
public class GroupAnagrams {

    public List<List<String>> solution(String[] strings){
        Map<String, List<String>> map = new HashMap<>();

        for (String string : strings){
            char[] chars = string.toCharArray();
            Arrays.sort(chars);
            String sorted = String.valueOf(chars);
            if (! map.containsKey(sorted)) map.put(sorted, new ArrayList<>());

            map.get(sorted).add(string);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) throws Exception{
        String[] strings = {"abc", "bac", "aabc"};
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        List<List<String>> result = groupAnagrams.solution(strings);

        System.out.println(result);
    }

}
