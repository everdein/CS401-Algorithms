
import java.util.Iterator;
import java.util.Stack;

public class DepthFirstSearch
{
    private boolean[] marked;
    private int[] edgeTo;
    // Starting index.
    private int s;
    private Graph graph;

    DepthFirstSearch(Graph graph, int s)
    {
        this.graph = graph;
        this.s = s;
        marked = new boolean[graph.v()];
        edgeTo = new int[graph.v()];

        dfs(graph, s);
    }

    public boolean hasPath(int v)
    {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v)
    {
        if(hasPath(v))
        {
            Stack<Integer> path = new Stack<Integer>();
            for(int x = v; x != s; x = edgeTo[x])
            {

                path.push(x);
            }
            path.push(s);
            return path;
        }
        return null;
    }



    // Recursive solution.
    private void dfs(Graph g, int v)
    {
        marked[v] = true;
        for(int w: g.adj(v))
        {
            if(!marked[w])
            {
                marked[w] = true;
                edgeTo[w] = v;
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
