package Chapter4;

/**
 * Created by bresai on 2017/2/17.
 */
public class MinimalTree {
    public Tree<Integer> solution(int[] array){
        Tree.TreeNode<Integer> node = dfs(array, 0, array.length - 1);
        return new Tree<>(node);
    }

    private Tree.TreeNode<Integer> dfs(int[] array, int start, int end){
        if (start > end) return null;
        if (start == end) return new Tree.TreeNode<>(array[start]);

        int index = start + ((end - start)>> 1);
        Tree.TreeNode<Integer> node = new Tree.TreeNode<>(array[index]);

        node.left = dfs(array, start, index - 1);
        node.right = dfs(array, index + 1, end);

        return node;
    }

    public static void main(String[] args) {
        MinimalTree object = new MinimalTree();
        int[] array = {1,2,3,4,5,6,7};
        Tree<Integer> tree = object.solution(array);

        tree.print();
    }
}
