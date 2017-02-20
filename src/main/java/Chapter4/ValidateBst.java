package Chapter4;

/**
 * Created by bresai on 2017/2/17.
 */
public class ValidateBst {

    public boolean solution(Tree.TreeNode<Integer> node){
//        return dfs(node, true) != Integer.MAX_VALUE;
        return inorder(node, null);
    }

    private boolean inorder(Tree.TreeNode<Integer> node, Integer parent){
        if (node == null) return true;

        if (! inorder(node.left, parent)) return false;
        if (parent != null && parent > node.data) return false;
        parent = node.data;

        if (! inorder(node.right, parent)) return false;

        return true;
    }

    private int dfs(Tree.TreeNode<Integer> node, boolean direction){
        if (node == null) {
            return direction ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

        int left = dfs(node.left, true);
        int right = dfs(node.right, false);

        if (left > node.data || right < node.data){
            return direction ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        if (direction){
            if (right == Integer.MAX_VALUE) return node.data;
            else return right;
        }else{
            if (left == Integer.MIN_VALUE) return node.data;
            else return left;
        }
    }

    public static void main(String[] args) throws Exception{
        ValidateBst object = new ValidateBst();
        Integer[] array = {3,5,2,1,null,4};
        Tree<Integer> tree = new Tree<>();
        tree.build(array);
        System.out.print(object.solution(tree.root));
    }
}
