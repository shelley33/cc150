package Chapter4;

/**
 * Created by bresai on 2017/2/17.
 */
public class Successor {
    public Integer solution(Tree.TreeNode<Integer> node){
        if (node == null) return null;

        if (node.right != null){
            return findRightMin(node.right);
        }
        else{
            return findMinParent(node);
        }
    }

    private int findRightMin(Tree.TreeNode<Integer> node){
        while (node.left != null){
            node = node.left;
        }

        return node.data;
    }

    private Integer findMinParent(Tree.TreeNode<Integer> node){
        int data = node.data;
        while (node != null && node.data <= data){
            node = node.parent;
        }
        return node == null ? null : node.data;
    }
}
