package Chapter2;

/**
 * Created by bresai on 2017/2/14.
 */
public class Partition {
	public Node solution(Node node, int partition){
		Node middle = new Node(0);
		Node middleHead = middle;
		Node tmp = node;
		Node prev = null;
		while (tmp != null){
			if (tmp.value >= partition){
				middle.next = tmp;
				middle = middle.next;
                if (prev == null){
                    tmp = tmp.next;
                } else{
                    prev.next = tmp.next;
                    tmp = tmp.next;
                }
			} else{
                prev = tmp;
			    tmp = tmp.next;
            }
		}

		if (middleHead.next != null){
            prev.next = middleHead.next;
        }

		return node;
	}

    public static void main(String[] args){
        int[] array = {1,2,3,4,1,2,3};
        Node head = Node.build(array);
        Node.print(head);
        Partition object = new Partition();
        Node.print(object.solution(head, 3));
    }
}
