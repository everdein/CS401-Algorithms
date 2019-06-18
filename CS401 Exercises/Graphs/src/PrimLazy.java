import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;

public class PrimLazy
{
    private Queue<Edge> mst;  // total weight of MST
    private double weight;	  // edges in the MST
    private boolean[] marked; // marked[v] = true iff v on tree
    private MinPQ<Edge> pq;   // edges with one endpoint in tree

    public PrimLazy(EdgeWeightedGraph graph) {
        mst = new Queue<Edge>();
        marked = new boolean[graph.v()];
        pq = new MinPQ<Edge>();

        for (int v = 0; v < graph.v(); v++) {  // run Prim from all vertices to
            if(!marked[v])					   // get a minimum spanning forest
                prim(graph, v);
        }
    }

    // run Prim's algorithm
    private void prim(EdgeWeightedGraph graph, int s) {
        scan(graph, s);

        while(!pq.isEmpty()) {				// better to stop when mst has V-1 edges
            Edge minEdge = pq.delMin();		// smallest edge on pq
            int v = minEdge.either();		// two endpoints
            int w = minEdge.other(v);
            if(marked[w] && marked[v]) continue;	// lazy, both v and w already scanned
            mst.enqueue(minEdge);					// add e to MST
            weight+=minEdge.weight();
            if(!marked[v])							// v becomes part of tree
                scan(graph, v);
            if(!marked[w])							// w becomes part of tree
                scan(graph, w);
        }

    }

    // add all edges e incident to v onto pq if the other endpoint has not yet been scanned
    private void scan(EdgeWeightedGraph graph, int v) {
        marked[v] = true;
        for(Edge edge:graph.adj(v)) {
            int w = edge.other(v);
            if(!marked[w]) {
                pq.insert(edge);
            }
        }
    }

    //Returns the edges in a minimum spanning tree (or forest).
    public Iterable<Edge> mst(){
        return mst;
    }

    //Returns the sum of the edge weights in a minimum spanning tree (or forest).
    public double weight() {
        return weight;
    }
}
