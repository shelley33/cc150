package Chapter1;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bresai on 2017/2/13.
 */
public class PalindromePermutation {
	public boolean solution(String s){
		int odd = 0;

		Map<Character, Integer> map = new HashMap<>();

		for (char c : s.toCharArray()){
			if (! map.containsKey(c)) map.put(c, 0);
			map.put(c, map.get(c) + 1);
			if (map.get(c) % 2 == 0) odd--;
			else odd++;
		}

		return s.length() % 2 == 0 ? odd == 0 : odd == 1;
	}

	public static void main(String[] args){
		PalindromePermutation object = new PalindromePermutation();
		System.out.print(object.solution("cbbbd"));
	}
}
