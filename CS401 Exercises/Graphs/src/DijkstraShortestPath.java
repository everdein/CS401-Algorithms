import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Stack;

public class DijkstraShortestPath {
    private double[] distTo;
    private DirectedEdge[] edgeTo;
    private IndexMinPQ<Double> minPQ;

    public DijkstraShortestPath(EdgeWeightedDirectedGraph graph, int s) {
        distTo = new double[graph.v()];
        edgeTo = new DirectedEdge[graph.v()];
        minPQ = new IndexMinPQ(graph.v());
        for (int i = 0; i < distTo.length; i++) {
            distTo[i] = Double.MAX_VALUE;
        }

        distTo[s] = 0;

        minPQ.insert(s, distTo[s]);

        // relax vertices in order of distance from s
        while(!minPQ.isEmpty()) {
            int v = minPQ.delMin();
            for(DirectedEdge edge: graph.adj(v)) {
                relax(edge);
            }
        }

    }
    // relax edge e and update pq if changed
    private void relax(DirectedEdge edge) {
        int v = edge.from();
        int w = edge.to();
        if(distTo[w]>distTo[v]+edge.weight()) {
            distTo[w] = distTo[v] + edge.weight();
            edgeTo[w] = edge;
            if(minPQ.contains(w)) {
                minPQ.decreaseKey(w, distTo[w]);
            }else {
                minPQ.insert(w, distTo[w]);
            }
        }
    }

    //Returns the length of a shortest path from the source vertex s to vertex v.
    public double distTo(int v) {
        return distTo[v];
    }

    //Returns true if there is a path from the source vertex s to vertex v.
    public boolean hasPathTo(int v) {
        return distTo[v] < Double.MAX_VALUE;
    }

    //Returns a shortest path from the source vertex s to vertex v.
    public Iterable<DirectedEdge> pathTo(int v){
        Stack<DirectedEdge> path = new Stack<DirectedEdge>();
        for(DirectedEdge x=edgeTo[v];x!=null;x=edgeTo[x.from()]) {
            path.push(x);
        }

        return path;
    }

}
