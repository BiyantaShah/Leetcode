package fullTime;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Biyanta on 13/09/17.
 */
public class Dijkstras {

    public static void main(String[] args) {
        int graph[][] = new int[][] {{0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0},
        };

        dijkstras(0, graph);
    }

    private static void dijkstras(int start, int[][] graph) {

        Set<Integer> visited = new HashSet<>();
        Integer[] dist = new Integer[graph.length];
        Integer [] prev = new Integer[graph.length];

        for (int i = 0; i < graph.length; i++) {
            dist[i] = Integer.MAX_VALUE;
            prev[i] = null;
        }
        dist[start] = 0;

        while (visited.size() != graph.length) {
            int vertex = minValue(visited, dist);
            visited.add(vertex);

            List<Integer> adjList = findNeighbours(graph, vertex);

            for (Integer neigh : adjList) {
               if ( dist[neigh] > graph[neigh][vertex] + dist[vertex]) {
                   dist[neigh]  = graph[neigh][vertex] + dist[vertex];
                   prev[neigh] = vertex;
               }
            }
        }

        for (int i = 1 ; i < graph.length; i++) {
            System.out.println(prev[i] + " " + i + " " + dist[i]);
        }
    }

    private static List<Integer> findNeighbours(int[][] graph, int vertex) {

        List<Integer> tempList = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            if (graph[vertex][i] != 0)
                tempList.add(i);
        }
        return tempList;
    }

    private static int minValue(Set<Integer> visited, Integer[] dist) {

        int min = Integer.MAX_VALUE;
        int index = -1;

        for(int i = 0; i < dist.length; i++) {
            if (dist[i] < min && !visited.contains(i)) {
                min = dist[i];
                index = i;
            }
        }
        return index;
    }
}
