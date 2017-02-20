package Chapter3;

/**
 * Created by bresai on 2017/2/16.
 */
public class SortStack {
    public MyStack<Integer> solution(MyStack<Integer> stack){
        MyStack<Integer> tmp = new MyStack<>();
        MyStack.StackNode<Integer> min = new MyStack.StackNode<>(Integer.MAX_VALUE);

        while ( ! stack.isEmpty() ){
            MyStack.StackNode<Integer> node = stack.pop();
            if (node.data < min.data){
                min = node;
                tmp.push(node);
            } else{
                while (! tmp.isEmpty()){
                    stack.push(tmp.pop());
                }

                tmp.push(node);
                min = node;
            }
        }
        return tmp;
    }

    public static void main(String[] args){
        MyStack<Integer> stack = new MyStack<>();
        stack.push(new MyStack.StackNode<>(1));
        stack.push(new MyStack.StackNode<>(3));
        stack.push(new MyStack.StackNode<>(5));
        stack.push(new MyStack.StackNode<>(2));
        stack.push(new MyStack.StackNode<>(4));

        SortStack object = new SortStack();
        object.solution(stack).print();
    }
}

class MyStack<T> {
    public static class StackNode<T>{
        T data;
        StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }

    private StackNode<T> head;
    int length;

    public boolean isEmpty(){
        return head == null;
    }

    public void push(StackNode<T> item){
        StackNode<T> tmp = item;
        tmp.next = head;
        head = tmp;
        length++;
    }

    public StackNode<T> pop(){
        if (isEmpty()) return null;
        StackNode<T> tmp = head;
        head = head.next;
        length--;
        tmp.next = null;
        return tmp;
    }

    public StackNode<T> peek(){
        if (isEmpty()) return null;
        return head;
    }

    public void print(){
        StackNode<T> tmp = head;
        while (tmp != null){
            System.out.print(tmp.data + " ");
            tmp = tmp.next;
        }
    }

}
