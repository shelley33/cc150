package Chapter3;

import java.util.Arrays;

/**
 * Created by bresai on 2017/2/16.
 */
public class ThreeInOneStack {
	private int numberOfStack = 3;
	private int stackSize;
	private int[] array;
	private int[] sizes;



	public ThreeInOneStack(int size){
		this.array = new int[numberOfStack * size];
		this.stackSize = size;
		this.sizes = new int[]{0,0,0};
	}

	private int getIndex(int stackNo){
		return (sizes[stackNo - 1] - 1 )* numberOfStack + stackNo - 1;
	}

	public void push(int stackNo, int item) throws Exception{
		if (isFull(stackNo)) throw new Exception("stack is full");;
        sizes[stackNo - 1] += 1;
		array[getIndex(stackNo)] = item;
	}

	public int peek(int stackNo) throws Exception{
		if (isEmpty(stackNo)) throw new Exception("stack is empty");
		return array[getIndex(stackNo)];
	}

	public int pop(int stackNo) throws Exception{
		int res = peek(stackNo);
		sizes[stackNo - 1] -= 1;
		return res;
	}

	public boolean isFull(int stackNo){
		return sizes[stackNo - 1] == stackSize;
	}

	public boolean isEmpty(int stackNo){
		return sizes[stackNo - 1] == 0;
	}

	public static void main(String[] args) throws Exception {
	    ThreeInOneStack object = new ThreeInOneStack(10);

	    object.push(1, 1);
	    object.push(1,2);
	    object.push(1,3);
	    System.out.println(object.peek(1));
		System.out.println(object.pop(1));
		System.out.println(object.peek(1));

		object.push(2, 4);
		object.push(2,5);
		object.push(2,6);
		System.out.println(object.peek(2));
		System.out.println(object.pop(2));
		System.out.println(object.peek(2));

		object.push(3, 7);
		object.push(3,8);
		object.push(3,9);
		System.out.println(object.peek(3));
		System.out.println(object.pop(3));
		System.out.println(object.peek(3));

		System.out.println(Arrays.toString(object.array));
    }
}
