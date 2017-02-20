package Chapter3;

/**
 * Created by bresai on 2017/2/16.
 */
public class Stack<T> {
    public static class StackNode<T>{
        private T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }

    private StackNode<T> head;
    int length;

    public boolean isEmpty(){
        return head == null;
    }

    public void push(T item){
        StackNode<T> tmp = new StackNode<T>(item);
        tmp.next = head;
        head = tmp;
        length++;
    }

    public T pop(){
        if (isEmpty()) return null;
        T tmp = head.data;
        head = head.next;
        length--;
        return tmp;
    }

    public T peek(){
        if (isEmpty()) return null;
        return head.data;
    }

}
