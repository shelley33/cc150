package Chapter4;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by bresai on 2017/2/17.
 */
public class RouteBetweenNodes {
    public boolean solution(Graph graph, int start, int end){
        return bfs(graph, start, end);
    }

    private boolean bfs(Graph graph, int start, int end){
        Queue<Integer> queue = new LinkedList<>();

        boolean[] seen = new boolean[graph.length];
        queue.offer(start);
        seen[start] = true;

        while (! queue.isEmpty()){
            int tmp = queue.poll();

            for (int node : graph.adjcentList.get(tmp)){
                if (seen[node]) continue;

                if (node == end) return true;

                queue.offer(node);
                seen[node] = true;
            }
        }

        return false;
    }
}
