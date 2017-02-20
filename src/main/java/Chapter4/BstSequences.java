package Chapter4;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by bresai on 2017/2/20.
 */
public class BstSequences {
    public List<List<Integer>> solution (Tree.TreeNode<Integer> head){
        List<List<Integer>> result = new LinkedList<>();
        List<Tree.TreeNode<Integer>> tmp = new LinkedList<>();
        List<Integer> array = new LinkedList<>();
        recursive(head, result, tmp, array);

        return result;
    }

    private void recursive(Tree.TreeNode<Integer> node, List<List<Integer>> result,
                           List<Tree.TreeNode<Integer>> tmp,  List<Integer> array){

        array.add(node.data);
        if (node.left != null){
            tmp.add(node.left);
        }
        if (node.right != null){
            tmp.add(node.right);
        }

        for (Tree.TreeNode<Integer> removedNode : tmp){
            List<Tree.TreeNode<Integer>> removedList = new LinkedList<>(tmp);
            removedList.remove(removedNode);
            recursive(removedNode, result, removedList, new LinkedList<>(array));
        }

        if (tmp.isEmpty()){
            result.add(array);
        }
    }

    public static void main(String[] args){
        BstSequences bstSequences = new BstSequences();
        Integer[] array = new Integer[]{2,1,3,4};
        Tree<Integer> tree = new Tree<>();
        tree.build(array);
        List<List<Integer>> result = bstSequences.solution(tree.root);
        System.out.println(result);
    }
}
