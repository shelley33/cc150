package Chapter2;

/**
 * Created by bresai on 2017/2/14.
 */
public class Node {
    public Node next;
    public int value;
    public Node prev;

    public Node(int value) {
        this.value = value;
    }

    public static void print(Node node){
        Node tmp = node;
        while (tmp != null){
            System.out.print(tmp.value + " ");
            tmp = tmp.next;
        }
        System.out.println("");
    }

    public static Node build(int[] array){
        Node head = new Node(array[0]);

        Node tmp = head;
        for (int i  = 1; i < array.length; i ++){
            tmp.next = new Node(array[i]);
            tmp = tmp.next;
        }

        return head;
    }
}
