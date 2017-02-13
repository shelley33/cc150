package Chapter1;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bresai on 2017/2/13.
 */
public class Permutation {
	public boolean solution(String a, String b){
		if (a.length() != b.length()) return false;
		Map<Character, Integer> map = new HashMap<>();
		for (char c : a.toCharArray()){
			if (! map.containsKey(c)) map.put(c, 0);
			map.put(c, map.get(c) + 1);
		}

		for (char c : b.toCharArray()){
			if (! map.containsKey(c)) return false;
			if (map.get(c) <= 0) return false;
			map.put(c, map.get(c) - 1);
		}

		for (Map.Entry<Character, Integer> entry : map.entrySet()){
			if (entry.getValue() > 0) return false;
		}

		return true;
	}

	public static void main(String[] args){
		Permutation object = new Permutation();
		System.out.print(object.solution("ab".toLowerCase(), "bc"));
	}
}
