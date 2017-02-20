package Chapter1;

/**
 * Created by bresai on 2017/2/14.
 */
public class StringRotation {

	public boolean solution(String s1, String s2){
		int length = s1.length();
		for (int i = 0; i < length; i++){
			if (s1.substring(0, i).equals(s2.substring(length - 1 - i, length - 1))){
				if (isSubstring(s1.substring(i+1), s2)){
					return true;
				}
			}
		}
		return false;
	}

	private boolean isSubstring(String word, String s){
	    return true;
    }
}
