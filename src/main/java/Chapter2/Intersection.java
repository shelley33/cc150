package Chapter2;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by bresai on 2017/2/15.
 */
public class Intersection {
	public Node solution(Node a, Node b){
		Set<Node> set = new HashSet<>();

		while (a != null){
			set.add(a);
			a = a.next;
		}

		while (b != null){
			if (set.contains(b)) return b;

			b = b.next;
		}

		return null;
	}

	public static void main(String[] args){
		Intersection object = new Intersection();
		int[] a = {1,2,3};
		int[] b = {4,5,6};
		Node head1 = Node.build(a);
		Node head2 = Node.build(b);

		head1.next = head2.next.next;

		Node.print(head1);
		Node.print(head2);
		
		Node res = object.solution(head1, head2);
		System.out.println(res.value);
	}
}
