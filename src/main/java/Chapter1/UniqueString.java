package Chapter1;

public class UniqueString{

	public boolean isUnique(String s){
        long tmp = 0;
		for (char c : s.toCharArray()){
			long index = c - 'a';
			if (((tmp & (1 << index)) >> index) == 1) return false;

			tmp = tmp | (1 << index);
		}

		return true;
	}

	public static void main(String[] args){
		UniqueString object = new UniqueString();
		System.out.print(object.isUnique("asfc"));
	}
}