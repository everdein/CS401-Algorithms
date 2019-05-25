import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Main
{
    public static void main(String[] args)
    {

//        GraphMatrix graph = new GraphMatrix(4);
//        graph.addEdge(0, 1);
//        graph.addEdge(0, 2);
//        graph.addEdge(1, 3);
//        for(int w: graph.adj(1))
//        {
//            System.out.println(w);
//        }

        // GraphMatrix
//        In in = new In("data.txt");
//        int vertices = in.readInt();
//        int edges = in.readInt();
//        GraphMatrix graph = new GraphMatrix(vertices);
//        for(int i = 0; i < edges; i++)
//        {
//            int v = in.readInt();
//            int w = in.readInt();
//            graph.addEdge(v, w);
//        }

        // Graph
        In in = new In("data.txt");
        int vertices = in.readInt();
        Graph graph = new Graph(vertices);
        int edges = in.readInt();
        for(int i = 0; i < edges;i++)
        {
            int v = in.readInt();
            int w = in.readInt();
            graph.addEdge(v, w);
        }

        // Prints graph.
        System.out.println("Graph:");
        System.out.println(graph);

        DepthFirstSearch dfs = new DepthFirstSearch(graph, 0);
        System.out.println("Depth First Search:");
        System.out.println(dfs.hasPath(6));

//        for(int x: dfs.pathTo(6))
//        {
//            System.out.println(x);
//        }
        System.out.println(dfs.pathTo(6) + "\n");

        BreadthFirstSearch bfs = new BreadthFirstSearch(graph, 0);
        if(bfs.hasPath(6))
        {
            System.out.println("Breadth First Search:");
            System.out.println(bfs.pathTo(6));
        }
        System.out.println(bfs.distTo(6) + "\n");

    }
}
