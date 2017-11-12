package fullTime;

import java.util.Arrays;

/**
 * Created by Biyanta on 13/09/17.
 */
public class UnionFindKruskals {

    int V, E;
    Edges[] edge;

    public UnionFindKruskals(int e, int v) {
        V = v;
        E = e;
        edge = new Edges[E];
        for (int i = 0; i <E; i ++) {
            edge[i] = new Edges();
        }
    }

    static class Edges implements Comparable<Edges> {
        int src = 0, dest = 0, weight = 0;

        @Override
        public int compareTo(Edges o) {
            return this.weight - o.weight;
        }
    }


    public static void main(String[] args) {
        int V = 4;
        int E = 5;
        UnionFindKruskals graph = new UnionFindKruskals(E,V);

        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 10;

        // add edge 0-2
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 6;

        // add edge 0-3
        graph.edge[2].src = 0;
        graph.edge[2].dest = 3;
        graph.edge[2].weight = 5;

        // add edge 1-3
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 15;

        // add edge 2-3
        graph.edge[4].src = 2;
        graph.edge[4].dest = 3;
        graph.edge[4].weight = 4;

        Kruskal(graph);

    }

    private static void Kruskal(UnionFindKruskals graph) {

        Edges[] result = new Edges[graph.V];
        for (int i = 0; i < graph.V ; i++) {
            result[i] = new Edges();
        }

        Arrays.sort(graph.edge);

        int[] parent = new int[graph.V];
        for (int i = 0 ; i < graph.V; i ++) {

            parent[i] = i;

        }
        int e = 0, i = 0;
        while (e < graph.V-1) {
            Edges nextEdge = new Edges();
            nextEdge = graph.edge[i++];

            int x =  find(parent, nextEdge.src);
            int y = find(parent, nextEdge.dest);

            if (x != y) {
                result[e++] = nextEdge;
                union(x, y, parent);
            }
        }


        for (int k = 0; k < e; k++) {
            System.out.println(result[k].src + " ----- "+result[k].dest + ": "+ result[k].weight);
        }
    }



    private static void union(int x, int y, int[] subset) {
        int xset = find(subset, x);
        int yset = find(subset, y);

        subset[xset] = yset;
    }

    private static int find(int[] subset, int src) {

        if (subset[src] == src)
            return src;
        else
            return find(subset, subset[src]);
    }
}
