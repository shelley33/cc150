package Chapter3;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by bresai on 2017/2/16.
 */
public class SetOfStack<T> {
    int ThreadHold = 5;
    private List<Stack<T>> setOfStack;

    public SetOfStack() {
        this.setOfStack = new LinkedList<>();
    }

    public void push(T item){
        Stack<T> stack;
        if (setOfStack.size() == 0 ||
                setOfStack.get(setOfStack.size() - 1).length == ThreadHold){
            stack = new Stack<>();
            setOfStack.add(stack);
        } else{
            stack = setOfStack.get(setOfStack.size() - 1);
        }
        stack.push(item);
    }

    public T pop(){
        Stack<T> stack = setOfStack.get(setOfStack.size() - 1);
        T res = stack.pop();
        if (stack.isEmpty()){
            setOfStack.remove(setOfStack.size() - 1);
        }

        return res;
    }

    public T popAt(int index){
        int count = index / ThreadHold;
        Stack<T> tmp = setOfStack.get(count);
        T res = tmp.pop();

        if (tmp.isEmpty()){
            setOfStack.remove(count);
        }

        return res;
    }

    public T peek(){
        return setOfStack.get(setOfStack.size() - 1).peek();
    }

    public boolean isEmpty(){
        return setOfStack.size() == 0;
    }

    public static void main(String[] args){
        SetOfStack<Integer> object = new SetOfStack<>();
        object.push(1);
        object.push(2);
        object.push(3);
        object.push(4);
        object.push(5);
        System.out.println(object.setOfStack.size());
        object.push(6);
        object.push(7);
        object.push(9);
        System.out.println(object.setOfStack.size());
        System.out.println(object.pop());
        System.out.println(object.pop());
        System.out.println(object.pop());
        System.out.println(object.setOfStack.size());
    }
}
