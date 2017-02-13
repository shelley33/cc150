package Chapter1;

/**
 * Created by Administrator on 2017/2/13.
 */
public class StringCompression {
	public String solution(String s){
		String res = compression(s);
		return res.length() < s.length() ? res : s;
	}
	
	private String compression(String s){
		StringBuilder builder = new StringBuilder();
		int count = 0;
		char tmp = s.charAt(0);
		for (char c : s.toCharArray()){
			if (tmp == c) count++;
			else {
				builder.append(tmp);
				builder.append(count);
				tmp = c;
				count = 1;	
			}
		}
		
		builder.append(tmp);
		builder.append(count);
		return builder.toString();
	}
	
	public static void main(String[] args){
		StringCompression object = new StringCompression();
		System.out.print(object.solution("ab"));
	}
}
