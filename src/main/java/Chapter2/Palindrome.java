package Chapter2;

import java.util.Stack;

/**
 * Created by bresai on 2017/2/15.
 */
public class Palindrome {
	public boolean solution(Node head){
		if (head == null) return false;

		Stack<Integer> stack = new Stack<>();

		Node fast = head;
		Node slow = head;

		while (fast != null){
            if (fast.next == null){
                break;
            }

			stack.push(slow.value);

			fast = fast.next.next;
			slow = slow.next;
		}

		if (fast != null){
		    slow = slow.next;
        }

		while (slow != null){
			if (slow.value != stack.pop()) return false;
			slow = slow.next;
		}

		return true;
	}

	public static void main (String[] args){
		Palindrome object = new Palindrome();
		int[] array = {1,2,1};

		System.out.print(object.solution(Node.build(array)));
	}
}
