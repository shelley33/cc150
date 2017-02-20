package Chapter3;

/**
 * Created by bresai on 2017/2/16.
 */
public class Queue<T> {
    public static class QueueNode<T>{
        public T data;
        public QueueNode<T> next;

        public QueueNode(T data) {
            this.data = data;
        }
    }


    private QueueNode<T> tail;
    private QueueNode<T> head;

    public boolean isEmpty(){
        return head == null;
    }

    public void add(T item){
        QueueNode<T> tmp = new QueueNode<T>(item);

        if (head == null){
            head = tmp;
        }

        if (tail == null){
            tail = tmp;
        }else{
            tail.next = tmp;
            tail = tail.next;
        }
    }

    public T peek(){
        return head.data;
    }

    public T remove(){
        T node = head.data;
        head = head.next;

        return node;
    }


}
