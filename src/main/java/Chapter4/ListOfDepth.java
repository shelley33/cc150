package Chapter4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by bresai on 2017/2/17.
 */
public class ListOfDepth {
    public List<List<Integer>> solution(Tree.TreeNode<Integer> node){
        List<List<Integer>> list = new ArrayList<>();
        dfs(node, list, 0);

        return list;
    }

    private void dfs(Tree.TreeNode<Integer> node, List<List<Integer>> list, int level){
        if (node == null) return;

        if (list.size() <= level) list.add(new LinkedList<>());

        list.get(level).add(node.data);

        dfs(node.left, list, level + 1);
        dfs(node.right, list, level + 1);
    }

    public static void main(String[] args) {
        ListOfDepth object = new ListOfDepth();
        Tree<Integer> tree = new Tree<>();
        Integer[] array = {1,2,3,4,5,6,7};
        tree.build(array);

        List<List<Integer>> list = object.solution(tree.root);
        System.out.print("haha");
    }

}
