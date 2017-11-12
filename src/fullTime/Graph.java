package fullTime;

import java.util.*;

/**
 * Created by Biyanta on 12/09/17.
 */
public class Graph {
    static Map<Integer, List<Integer>> graph = new HashMap<>();
//    static Map<Integer, String> mapGr = new HashMap<>();
    public static void main (String[] args) {
        
        List<Integer> neighbors = new ArrayList<>();

        neighbors.add(2);
        neighbors.add(0);
        graph.put(5, neighbors);
        List<Integer> neighbors1 = new ArrayList<>();
//        neighbors1.add("A");
        neighbors1.add(3);
        graph.put(2, (neighbors1));
        List<Integer> neighbors2 = new ArrayList<>();
//        neighbors2.add("A");
//        neighbors2.add("B");
//        neighbors2.add("D");
        graph.put(0, neighbors2);
        List<Integer> neighbors3 = new ArrayList<>();
        neighbors3.add(1);
        neighbors3.add(0);
        graph.put(4, (neighbors3));
        List<Integer> neighbors4 = new ArrayList<>();
        graph.put(1, (neighbors4));
        List<Integer> neighbors5 = new ArrayList<>();
        neighbors5.add(1);
        graph.put(3, ( neighbors5));


        for (Integer node : graph.keySet()) {
            System.out.print(node + ": " );
            for (Integer neigh : graph.get(node))
                System.out.print(neigh + " ");
            System.out.println();
        }

//        bfs(graph);
//        dfs(graph);
//        System.out.println();
        System.out.println("Disconnected");
        dfsRecur();
        System.out.println("Topological Sort");
        topologicalSort();
    }

    private static void topologicalSort() {
        boolean visited[] = new boolean[graph.size()];
        Stack stack = new Stack();

        for (int i = 0; i < graph.size(); i++) {
            if (visited[i] == false) {
                topoUtil(i, visited, stack);
            }

        }

        while (stack.empty() == false)
            System.out.print(stack.pop() +" ");

    }

    private static void topoUtil(int i, boolean[] visited, Stack stack) {

        visited[i] = true;

        List<Integer> adj = graph.get(i);

        for (Integer neigh : adj) {
            if (!visited[neigh])
                topoUtil(neigh, visited, stack);
        }
        stack.push(i);

    }

    private static void dfsRecur() {

        boolean visited[] = new boolean[graph.size()];
//        dfsUtil(5, visited);

        for (int i = graph.size()-1; i >= 0; i--) {
            if (visited[i] == false) {
                dfsUtil(i, visited);
            }

        }
        

    }

    private static void dfsUtil(int start, boolean[] visited) {

        visited[start] = true;
        System.out.print(start + " ");

        List<Integer> adj = graph.get(start);
        for (Integer neigh: adj) {
            if (!visited[neigh])
                dfsUtil(neigh, visited);
        }
    }

    private static void dfs(Map<String, List<String>> graph) {
        System.out.println();
        System.out.println("DFS Traversal");

        LinkedList<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add("A");
//        visited.add("A");

        while (!queue.isEmpty()) {
            String node = queue.pollLast();
            System.out.print(node + " ");
            visited.add(node);

            List<String> neighbors = graph.get(node);
            Collections.sort(neighbors, Collections.reverseOrder());
            for (String adj : neighbors) {
                if (!visited.contains(adj) && !queue.contains(adj)) {
                    queue.add(adj);
                }

            }

        }

    }

    private static void bfs(Map<String, List<String>> graph) {
        System.out.println();
        System.out.println("BFS Traversal");

        LinkedList<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.size();
        String a = "A";
        a = new StringBuffer(a).reverse().toString();
        queue.add("A");
        visited.add("A");

        while (!queue.isEmpty()) {

            String node = queue.poll();
            System.out.print(node + " ");
            List<String> neighbors = graph.get(node);

            for (String adj : neighbors) {
                if (!visited.contains(adj)) {
                    visited.add(adj);
                    queue.add(adj);
                }
            }

        }
    }
}
