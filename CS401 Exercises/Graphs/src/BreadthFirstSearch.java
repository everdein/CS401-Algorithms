import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class BreadthFirstSearch
{
    private boolean[] marked;
    private int[] edgeTo;
    private int[] distTo;
    private int s;

    public BreadthFirstSearch(Graph graph, int s)
    {
        this.s = s;
        int vCount = graph.v();
        marked = new boolean[vCount];
        edgeTo = new int[vCount];
        distTo = new int[vCount];

        for (int i = 0; i < distTo.length; i++)
        {
            distTo[i] = Integer.MAX_VALUE;
        }
        bfs(graph, s);
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
        if(!hasPath(v))
        {
            return null;
        }
        Stack<Integer> path = new Stack<Integer>();
        for(int x = v; x != s; x = edgeTo[x])
        {
            path.push(x);
        }
        path.push(s);
        return path;
    }

    private void bfs(Graph graph, int s)
    {
        Queue<Integer> queue = new Queue<Integer>();
        queue.enqueue(s);
        marked[s] = true;
        edgeTo[s] = s;
        distTo[s] = 0;
        while (!queue.isEmpty())
        {
            int v = queue.dequeue();
            for (int w : graph.adj((v)))
            {
                if (!marked[w])
                {
                    queue.enqueue(w);
                    marked[w] = true;
                    edgeTo[w] = v;
                    distTo[w] = 1 + distTo[v];
                }
            }
        }

    }
}