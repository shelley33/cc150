package Chapter4;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by bresai on 2017/2/17.
 */
public class Tree<T> {

    public static class TreeNode<T> {
        T data;
        TreeNode<T> parent;
        TreeNode<T> left;
        TreeNode<T> right;

        public TreeNode(T data) {
            this.data = data;
        }
    }

    TreeNode<T> root;

    public Tree() {
    }

    public Tree(TreeNode<T> root) {
        this.root = root;
    }


    public void build(T[] array){
        root = dfs(array, 0);
    }

    private TreeNode<T> dfs(T[] array, int index){
        if (index >= array.length || array[index] == null) return null;

        TreeNode<T> node = new TreeNode<T>(array[index]);
        node.left = dfs(array, index*2 + 1);
        node.right = dfs(array, index*2 + 2);

        return node;
    }


    public void print(){
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.offer(root);
        while (! queue.isEmpty()){
            TreeNode<T> node = queue.poll();
            if (node != null){
                System.out.println(node.data + " ");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
    }
}
