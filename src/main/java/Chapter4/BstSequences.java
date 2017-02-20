package Chapter4;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by bresai on 2017/2/20.
 */
public class BstSequences {
    public List<List<Integer>> solution (Tree.TreeNode<Integer> head){
        List<List<Integer>> result = new LinkedList<>();


    }

    private void recursive(Tree.TreeNode<Integer> node, List<List<Integer>> result, List<Integer> array){

        if (array == null) array = new LinkedList<>();
        array.add(node.data);

        recursive(node.left, result, new LinkedList<>(array));
        recursive(node.right, result, new LinkedList<>(array));


    }
}
