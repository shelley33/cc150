package Chapter4;

/**
 * Created by bresai on 2017/2/20.
 */
public class FirstCommonAncester {

    public Tree.TreeNode<Integer> solution(Tree.TreeNode<Integer> head, int value1, int value2){
        return dfs(head, value1, value2);
    }

    private Tree.TreeNode<Integer> dfs(Tree.TreeNode<Integer> node, int value1, int value2){

        if (node == null || node.data == value1 || node.data == value2) return node;

        Tree.TreeNode<Integer> left = dfs(node.left,value1, value2);
        Tree.TreeNode<Integer> right = dfs(node.right, value1, value2);

        if (left != null && right != null) return node;

        if (left != null) return left;

        if (right != null) return right;

        return null;

    }

    public static void main(String[] args){
        FirstCommonAncester object = new FirstCommonAncester();

        Integer[] array = {1,2,3,4,5,6,7,8};
        Tree<Integer> tree = new Tree<>();
        tree.build(array);
        System.out.println(object.solution(tree.root, 2, 8).data);
    }
}
