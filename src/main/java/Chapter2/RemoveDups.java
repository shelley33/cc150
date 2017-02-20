package Chapter2;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by bresai on 2017/2/14.
 */
public class RemoveDups {

	public Node solution(Node head){
		Set<Integer> set = new HashSet<>();
		Node tmp = head;
		Node prev = null;
		while (tmp != null){
			if (set.contains(tmp.value)) prev.next = tmp.next;
			else {
			    set.add(tmp.value);
                prev = tmp;
            }
			tmp = tmp.next;
		}
		return head;
	}

	public static void main(String[] args){
		int[] array = {1,2,3,4,1,2,3};
		Node head = Node.build(array);
		Node.print(head);
		RemoveDups object = new RemoveDups();
		Node.print(object.solution(head));
	}
}

