import edu.princeton.cs.algs4.In;

public class Main {
    public static void main(String[] args)
    {
//        graph();
//        graphMatrix();
//        depthFirstSearch();
//        breadthFirstSearch();
//        directedGraphAndCycle();



        DirectedGraph digraph = new DirectedGraph(8);
        digraph.addEdge(0,1 );
        digraph.addEdge(1,2 );
        digraph.addEdge(3,2 );
        digraph.addEdge(3,4 );

        DirectedCycle dc = new DirectedCycle(digraph);
        if(!dc.hasCycle())
        {
            DepthFirstOrder depthFirstOrder = new DepthFirstOrder(digraph);
            System.out.println(depthFirstOrder.reversePostOrder());
        }
        else
        {
            System.out.println("No topological order.");
        }

    }

    //                     //
    //// Reads Text File ////
    //                     //
    public static Graph readTxt()
    {
        In in = new In("data.txt");
        int vertices = in.readInt();
        int edges = in.readInt();
        Graph graph = new Graph(vertices, edges);
        for(int i = 0; i < edges; i++)
        {
            int v = in.readInt();
            int w = in.readInt();
            graph.addEdge(v, w);
        }
        return graph;
    }

    //           //
    //// Graph ////
    //           //
    public static void graph()
    {
        Graph g = readTxt();
        System.out.println("---------------------------------------");
        System.out.println("Graph:\n" + g);
        System.out.println("Vertices: " + g.v());
        System.out.println("Edges: " + g.e());
        System.out.println("Degree: " + g.degree(2));
        System.out.println("Adjacent: " + g.adj(2));
    }

    //                  //
    //// Graph Matrix ////
    //                  //
    public static void graphMatrix()
    {
        Graph g = readTxt();
        System.out.println("---------------------------------------");
        System.out.println("Graph Matrix:");
        System.out.println(g);
        System.out.print("Ajacent: " );
        int adjacent = 2;
        for(int w: g.adj(adjacent))
        {
            System.out.print(w + " ");
        }
        System.out.println();
    }

    //                        //
    //// Depth First Search ////
    //                        //
    public static void depthFirstSearch()
    {
        Graph g = readTxt();
        System.out.println("---------------------------------------");
        System.out.println("Depth First Search Graph:");
        System.out.println(g);
        int startingVertex = 0;
        int endingVertex = 6;
        DepthFirstSearch bfs = new DepthFirstSearch(g, startingVertex);
        if(bfs.hasPath(endingVertex))
        {
            System.out.println("Starting Vertex: " + startingVertex);
            System.out.println("Ending Vertex: " + endingVertex);
            System.out.println("Path To: "  + bfs.pathTo(endingVertex));
        }
        System.out.println("Path Distance: " + bfs.distTo(endingVertex));
    }

    //                          //
    //// Breadth First Search ////
    //                          //
    public static void breadthFirstSearch()
    {
        Graph g = readTxt();
        System.out.println("---------------------------------------");
        System.out.println("Breadth First Search Graph:");
        System.out.println(g);
        int startingVertex = 0;
        int endingVertex = 6;
        BreadthFirstSearch bfs = new BreadthFirstSearch(g, startingVertex);
        if(bfs.hasPath(endingVertex))
        {
            System.out.println("Starting Vertex: " + startingVertex);
            System.out.println("Ending Vertex: " + endingVertex);
            System.out.println("Path To: "  + bfs.pathTo(endingVertex));
        }
        System.out.println("Path Distance: " + bfs.distTo(endingVertex));
    }


    //                            //
    //// Directed Graph & Cycle ////
    //                            //
    public static void directedGraphAndCycle()
    {
        In in = new In("data.txt");
        int vertices = in.readInt();
        int edges = in.readInt();
        DirectedGraph digraph = new DirectedGraph(vertices);
        for (int i = 0; i < edges; i++) {
            int v = in.readInt();
            int w = in.readInt();
            digraph.addEdge(v, w);
        }
        System.out.println("---------------------------------------");
        System.out.println("Directed and Cycle Graph:");
        System.out.println(digraph);
        DirectedCycle dc = new DirectedCycle(digraph);
        if(dc.hasCycle())
        {
            System.out.println("Cycle:"+ dc.cycle());
        }
    }
}
