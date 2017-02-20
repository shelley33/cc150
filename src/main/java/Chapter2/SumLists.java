package Chapter2;

/**
 * Created by bresai on 2017/2/15.
 */
public class SumLists {
	public Node solution(Node a, Node b){

		if (a == null) return b;
		if (b == null) return a;

		int carry = 0;
		Node head = new Node(0);
		Node tmp = head;

		while (a != null){
			int tmpB = 0;
			if (b != null){
				tmpB = b.value;
			}

			int valueTmp = (a.value + tmpB + carry) % 10;
			carry = (a.value + tmpB + carry) / 10;
		
			tmp.next = new Node(valueTmp);
			tmp = tmp.next;

			a = a.next;
			if (b != null){
                b = b.next;
            }
		}

		while (b != null){
			int valueTmp = (b.value + carry) % 10;
			carry = (b.value + carry) / 10;
			tmp.next = new Node(valueTmp);
			tmp = tmp.next;

			b = b.next;
		}

		if (carry != 0){
			tmp.next = new Node(carry);
		}

		return head.next;
	}

	public static void main(String[] args){
		SumLists object = new SumLists();
		int[] a = {7,1,6};
		int[] b = {5,9,4};

		Node.print(object.solution(Node.build(a), Node.build(b)));
	}
}
