package Chapter2;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by bresai on 2017/2/15.
 */
public class LoopDetection {
	public Node solution(Node a){
	    Set<Node> set = new HashSet<>();

	    while (a != null){
	    	if (set.contains(a)) return a;
	    	set.add(a);
	    	a = a.next;
	    }		

	    return null;
	}

	public static void main(String[] args){
		LoopDetection object = new LoopDetection();

		int[] a = {1,2,3,4,5,6};

		Node head = Node.build(a);

        head.next.next.next.next = head.next;

		Node res = object.solution(head);

		System.out.println(res.value);
	}
}
