package Chapter2;

/**
 * Created by bresai on 2017/2/14.
 */
public class ReturnKthToLast {

	public Node solution(Node head, int k){
		Node p1 = head;
		Node p2 = head;

		for (int i = 0; i < k; i++){
			if (p1.next == null) return head;
			p1 = p1.next;
		}

		while (p1 != null){
			p1 = p1.next;
			p2 = p2.next;
		}

		return p2;
	}

	public static void main(String[] args){
		int[] array = {1,2,3,4,5,6,7,8,9,0};
		Node head = Node.build(array);
		ReturnKthToLast object = new ReturnKthToLast();
		Node.print(head);
		Node.print(object.solution(head, 4));
	}
}
