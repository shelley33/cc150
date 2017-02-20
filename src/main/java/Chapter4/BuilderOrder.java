package Chapter4;

import java.util.*;

/**
 * Created by bresai on 2017/2/20.
 */
public class BuilderOrder {

    public List<String> solution(String[] projects, List<List<String>> dependencies) throws Exception {
        Map<String, List<String>> reversedGraph = new HashMap<>();
        buildGraph(dependencies, false, reversedGraph);
        List<String> res = new ArrayList<>();

        for (String key : projects) {
            if (res.contains(key)) continue;
            Set<String> dups = new HashSet<>();
            dfs(key, reversedGraph, res, dups);
        }

        return res;
    }

    private void dfs(String key, Map<String, List<String>> graph, List<String> res, Set<String> dups) throws Exception {
        if (dups.contains(key)) throw new Exception("duplicates");
        dups.add(key);
        List<String> list = graph.get(key);

        if (list == null || list.isEmpty()) {
            res.add(key);
            return;
        }

        for (String value : list) {
            if (res.contains(value)) continue;
            dfs(value, graph, res, dups);
        }

        res.add(key);
    }

    private void buildGraph(List<List<String>> dependencies, boolean reversed, Map<String, List<String>> graph) {
        for (List<String> list : dependencies) {
            String key = reversed ? list.get(1) : list.get(0);
            String target = reversed ? list.get(0) : list.get(1);
            if (!graph.containsKey(key)) {
                graph.put(key, new LinkedList<>());
            }

            graph.get(key).add(target);
        }
    }


    public static void main(String[] args) throws Exception {
        String[] project = {"a", "b", "c", "d", "e", "f"};
        List<List<String>> dependencies = new LinkedList<>();
        dependencies.add(new LinkedList<>(Arrays.asList("a", "d")));
        dependencies.add(new LinkedList<>(Arrays.asList("f", "b")));
        dependencies.add(new LinkedList<>(Arrays.asList("b", "d")));
        dependencies.add(new LinkedList<>(Arrays.asList("f", "a")));
        dependencies.add(new LinkedList<>(Arrays.asList("d", "c")));

        BuilderOrder object = new BuilderOrder();
        System.out.println(object.solution(project, dependencies));
    }
}
