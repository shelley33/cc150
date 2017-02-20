package Chapter4;

/**
 * Created by bresai on 2017/2/17.
 */
public class CheckBalacned {
    public boolean solution (Tree.TreeNode<Integer> node){
        return dfs(node) != Integer.MIN_VALUE;
    }

    private int dfs(Tree.TreeNode<Integer> node){

        if (node == null) return 0;

        int left = dfs(node.left);
        int right = dfs(node.right);

        if (Math.abs(left - right) > 1) return Integer.MIN_VALUE;
        return left == Integer.MIN_VALUE || right == Integer.MIN_VALUE ?
                Integer.MIN_VALUE : Math.max(left,right) + 1;
    }

    public static void main(String[] args) throws Exception{
        CheckBalacned object = new CheckBalacned();
        Integer[] array = {1,2,0,4,5};
        Tree<Integer> tree = new Tree<>();
        tree.build(array);
        System.out.print(object.solution(tree.root));
    }

}
