import edu.princeton.cs.algs4.Stack;

public class DirectedCycle
{
    private boolean[] marked;
    private int[] edgeTo;
    private boolean[] onStack;
    private Stack<Integer> cycle;

    // Determines whether the digraph has a directed cycle and, if so, finds such a cycle
    public DirectedCycle(DirectedGraph graph)
    {
        marked = new boolean[graph.v()];
        edgeTo = new int[graph.v()];
        onStack = new boolean[graph.v()];

        for (int v = 0; v < graph.v(); v++)
        {
            if(!marked[v] && cycle==null)
                dfs(graph, v);
        }

    }
    private void dfs(DirectedGraph graph, int v)
    {
        marked[v] = true;
        onStack[v] = true;
        for(int w : graph.adj(v))
        {
            // short circuit if directed cycle found
            if(cycle!=null)
            {
                return;
            }
            // found new vertex, so recur
            if(!marked[w])
            {
                edgeTo[w] = v;
                dfs(graph, w);
            }
            // trace back directed cycle
            else if(onStack[w])
            {
                cycle = new Stack<Integer>();
                for(int x=v;x!=w;x=edgeTo[x])
                {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }

    //Does the digraph have a directed cycle?
    public boolean hasCycle()
    {
        return cycle != null;
    }

    //Returns a directed cycle if the digraph has a
    //directed cycle, and null otherwise.
    public Iterable<Integer> cycle()
    {
        return cycle;
    }
}
