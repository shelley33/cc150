package Chapter1;

/**
 * Created by bresai on 2017/2/13.
 */
public class Urlify {

	public String solution(String s, int length){
		char[] sArray = s.toCharArray();

		int startSpaceCount = 0;
		int count = 0;

		while (sArray[startSpaceCount] == ' ') {
			startSpaceCount++;
		}

		for (int i = 0; i < length; i++){
			if (sArray[i] == ' ') count += 2;
		}

		count += length;

		for (int i = length + startSpaceCount - 1; i > startSpaceCount ; i--){
			if (sArray[i] != ' '){
				sArray[count - 1] = sArray[i];
				count--;
			} else{
				sArray[count - 1] = '0';
				sArray[count - 2] = '2';
				sArray[count - 3] = '%';
				count = count - 3;
			}
		}

		return String.valueOf(sArray);
	}

	public static void main(String[] args){
		Urlify object = new Urlify();
		System.out.print(object.solution("Mr John Smith          ", 13));
	}
}
