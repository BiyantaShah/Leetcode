package fullTime;

import java.util.*;

/**
 * Created by Biyanta on 13/09/17.
 */
public class Prims {

    public static void main(String[] args) {
        int graph[][] = new int[][] {{0, 2, 0, 6, 0},
                                     {2, 0, 3, 8, 5},
                                     {0, 3, 0, 0, 7},
                                     {6, 8, 0, 0, 9},
                                     {0, 5, 7, 9, 0},
                                    };

        prims(graph);
    }

    private static void prims(int[][] graph) {
        Map<Integer, Integer> keyValue = new HashMap<>();
        Set<Integer> mstSet = new LinkedHashSet<>();
        Set<Integer> remainingVertices = new HashSet<>();
        int[] parent = new int[graph.length];
        parent[0] = -1;

        for (int i = 0; i < graph.length; i++) {
            keyValue.put(i, Integer.MAX_VALUE);
        }
        keyValue.put(0,0);

        for (int i = 0; i < graph.length; i++) {
            remainingVertices.add(i);
        }

        while (mstSet.size() != graph.length) {

            int vertex = minKeyValue(keyValue, mstSet);
            remainingVertices.remove(vertex);
            mstSet.add(vertex);

            List<Integer> adjList = findAdjList(graph, vertex);

            for (Integer neigh : adjList) {
                int weight = graph[vertex][neigh];
                if (keyValue.get(neigh) > weight && !mstSet.contains(neigh)) {
                    parent[neigh] = vertex;
                    keyValue.put(neigh, weight);
                }
            }
        }

       for (int i = 1; i < graph.length; i++) {
           System.out.println(parent[i] + " -- "+ i + ": "+ graph[i][parent[i]]);
       }
    }

    private static List<Integer> findAdjList(int[][] graph, int vertex) {

        List<Integer> adjList = new ArrayList<>();
        for (int i = 0; i < graph[0].length; i++) {
            if (graph[vertex][i] != 0) {
                adjList.add(i);
            }
        }
        return adjList;
    }

    private static int minKeyValue(Map<Integer, Integer> keyValue, Set<Integer> mstSet) {

        int min = Integer.MAX_VALUE;
        int index = -1;

        for (Integer key : keyValue.keySet()) {
            if (keyValue.get(key) < min && !mstSet.contains(key)) {
                min = keyValue.get(key);
                index = key;
            }
        }

        return index;
    }

}
