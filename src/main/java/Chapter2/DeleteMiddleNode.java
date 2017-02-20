package Chapter2;

/**
 * Created by bresai on 2017/2/14.
 */
public class DeleteMiddleNode {
	public void  solution(Node head){

	    if (head == null || head.next == null) return;
        head.value = head.next.value;
	    head.next = head.next.next;

	}

	public static void main (String[] args){
		int[] array = {1,2,3,4,5,6};
		Node head = Node.build(array);
		Node.print(head);
		Node tmp = head.next.next.next;
        (new DeleteMiddleNode()).solution(tmp);
		Node.print(head);
	}
}
