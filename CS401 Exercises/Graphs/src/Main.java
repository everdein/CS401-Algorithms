import edu.princeton.cs.algs4.In;

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
        int edges = in.readInt();
        Graph graph = new Graph(vertices);
        for(int i = 0; i < edges;i++)
        {
            int v = in.readInt();
            int w = in.readInt();
            graph.addEdge(v, w);
        }

        // Prints graph.
        System.out.println(graph);
    }
}
