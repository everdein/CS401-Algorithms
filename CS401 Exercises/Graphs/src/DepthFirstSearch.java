import java.util.Stack;

public class DepthFirstSearch
{
    private boolean[] marked;
    private int[] edgeTo;
    private int[] distTo;
    private int start;
    private Graph graph;

    DepthFirstSearch(Graph graph, int start)
    {
        this.graph = graph;
        this.start = start;
        marked = new boolean[graph.v()];
        edgeTo = new int[graph.v()];
        distTo = new int[graph.v()];

        dfs(graph, start);
    }

    public boolean hasPath(int v)
    {
        return marked[v];
    }

    public int distTo(int v)
    {
        return distTo[v];
    }

    public Iterable<Integer> pathTo(int v)
    {
        if(hasPath(v))
        {
            Stack<Integer> path = new Stack<>();
            for(int x = v; x != start; x = edgeTo[x])
            {
                path.push(x);
            }
            path.push(start);
            return path;
        }
        return null;
    }

    // Recursive solution.
    private void dfs(Graph g, int v)
    {
        marked[v] = true;
        distTo[start] = 0;
        for(int w: g.adj(v))
        {
            if(!marked[w])
            {
                marked[w] = true;
                edgeTo[w] = v;
                distTo[w] = 1 + distTo[v];
                dfs(g, w);
            }
        }
    }

    // Non-Recursive solution.
//    private void dfs(Graph g, int s)
//    {
//        // Algorithms textbook stack.
//        Stack<Integer> stack = new Stack<Integer>();
//        Iterator<Integer>[] iterators = new Iterator[g.v()];
//        for(int i = 0; i < iterators.length; i++)
//        {
//            iterators[i] = g.adj(i).iterator();
//        }
//
//        marked[s] = true;
//        edgeTo[s] = s;
//        stack.push(s);
//
//        while(!stack.isEmpty())
//        {
//            int v = stack.peek();
//            Iterator<Integer> iter = iterators[v];
//            if(iter.hasNext())
//            {
//                int w = iter.next();
//                if(!marked[w])
//                {
//                    stack.push(w);
//                    marked[w] = true;
//                    edgeTo[w] = v;
//                }
//            }
//            else
//            {
//                stack.pop();
//            }
//        }
//    }

}
