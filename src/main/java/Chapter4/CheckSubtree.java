package Chapter4;

/**
 * Created by bresai on 2017/2/21.
 */
public class CheckSubtree {
    public boolean solution(Tree.TreeNode<Integer> T1, Tree.TreeNode<Integer> T2){
        if (T2 == null) return true;

        return findNode(T1, T2);
    }

    private boolean findNode(Tree.TreeNode<Integer> node, Tree.TreeNode<Integer> target){
        if (node == null) return false;

        if (node.data.equals(target.data)) {
            boolean result = compare(node, target);
            if (result) return true;
        }

        return findNode(node.left, target) || findNode(node.right, target);
    }

    private boolean compare(Tree.TreeNode<Integer> node1, Tree.TreeNode<Integer> node2){
        if (node1 == null && node2 == null) return true;

        if (node1 == null || node2 == null) return false;

        if (! node1.data.equals(node2.data)) return false;

        return compare(node1.left, node2.left) && compare(node1.right, node2.right);
    }

    public static void main(String[] args) throws Exception{
        CheckSubtree checkSubtree = new CheckSubtree();
        Integer[] array1 = {1,2,5,4,5,6,5,8,9,10,11};
        Integer[] array2 = {5,6,5};
        Tree<Integer> tree1 = new Tree<>();
        tree1.build(array1);

        Tree<Integer> tree2 = new Tree<>();
        tree2.build(array2);
        System.out.print(checkSubtree.solution(tree1.root, tree2.root));
    }

}
