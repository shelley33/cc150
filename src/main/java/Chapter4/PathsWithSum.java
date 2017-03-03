package Chapter4;

import java.util.HashSet;

/**
 * Created by bresai on 2017/2/21.
 */
public class PathsWithSum {
    Integer count = 0;
    public int solution(Tree.TreeNode<Integer> head, int target){
        recur(head, target, new HashSet<>());

        return count;
    }

    private void recur(Tree.TreeNode<Integer> node, int target, HashSet<Integer> sums){
        if (node == null) return;

        if (sums.contains(node.data - target)) count++;

        if (node.data == target) count++;
        else sums.add(node.data);

        recur(node.left, target, new HashSet<>(sums));
        recur(node.right, target, new HashSet<>(sums));
    }

    public static void main(String[] args) {
        PathsWithSum object = new PathsWithSum();
        Integer[] array = {1,2,5,4,5,6,5,8,9,10,11};
        Tree<Integer> tree = new Tree<>();
        tree.build(array);
        System.out.println(object.solution(tree.root, 10));
    }
}
