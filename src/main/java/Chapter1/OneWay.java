package Chapter1;

/**
 * Created by Administrator on 2017/2/13.
 */
public class OneWay {
	public boolean solution(String a, String b){
		if (a.length() == b.length())
			return checkReplace(a, b);
		else if ( a.length() - b.length() == 1)
			return checkInsertion(a, b);
		else if ( b.length() - a.length() == 1)
			return checkInsertion(b, a);
		else 
			return false;
	}
	
	private boolean checkReplace(String a, String b){
		int count = 0;
		for (int i = 0; i < b.length(); i++){
			if (a.charAt(i) != b.charAt(i)) {
				count++;
			}
			
			if (count > 1)
				return false;
		}
		return true;
	}
	
	private boolean checkInsertion(String a, String b){
		int count = 0;
		for (int i = 0; i < b.length(); i++){
			if (a.charAt(i + count) == b.charAt(i)) continue;

			count++;
			i--;
			if (count > 1)
				return false;			
	
		}
		return true;
	}
	
	public static void main(String[] args){
		OneWay object = new OneWay();
		System.out.print(object.solution("afbc", "abc"));
	}
}
