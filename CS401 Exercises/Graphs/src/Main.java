import edu.princeton.cs.algs4.In;

public class Main
{
    public static void main(String[] args)
    {
//        graph();
//        graphMatrix();
//        depthFirstSearch();
//        breadthFirstSearch();
//        directedGraph();
//        directedGraphAndCycle();
//        topologicalDirectedGraph();
//        edgeWeightedGraph();
//        edgeWeightedDirectedGraph();
//        primLazy();
//        kruskalMST();
//        dijkstrasShortestPath();
    }

    //                     //
    //// Reads Text File ////
    //                     //
    public static Graph readGraphTextFile()
    {
        In in = new In("tiny_data.txt");
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

    public static DirectedGraph readDirectedGraphTextFile()
    {
        In in = new In("tiny_data.txt");
        int vertices = in.readInt();
        int edges = in.readInt();

        DirectedGraph directedGraph = new DirectedGraph(vertices);

        for(int i = 0; i < edges; i++)
        {
            int v = in.readInt();
            int w = in.readInt();
            directedGraph.addEdge(v, w);
        }

        return directedGraph;
    }

    public static EdgeWeightedGraph readEdgeWeightedGraphTextFile()
    {
        In in = new In("data2.txt");
        int vertices = in.readInt();
        int edges = in.readInt();

        EdgeWeightedGraph edgeWeightedGraph = new EdgeWeightedGraph(vertices);

        for(int i=0;i<edges;i++)
        {
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
            Edge edge = new Edge(v, w, weight);
            edgeWeightedGraph.addEdge(edge);
        }

        return edgeWeightedGraph;
    }

    public static EdgeWeightedDirectedGraph readEdgeWeightedDirectedGraphTextFile()
    {
        In in = new In("data2.txt");
        int vertices = in.readInt();
        int edges = in.readInt();

        EdgeWeightedDirectedGraph edgeWeightedDirectedGraph = new EdgeWeightedDirectedGraph(vertices);

        for(int i=0;i<edges;i++)
        {
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
            DirectedEdge edge = new DirectedEdge(v, w, weight);
            edgeWeightedDirectedGraph.addEdge(edge);
        }

        return edgeWeightedDirectedGraph;
    }

    //           //
    //// Graph ////
    //           //
    public static void graph()
    {
        Graph graph = readGraphTextFile();

        System.out.println("---------------------------------------");
        System.out.println("Graph:\n" + graph);
        System.out.println("Vertices: " + graph.v());
        System.out.println("Edges: " + graph.e());
        System.out.println("Degree: " + graph.degree(2));
        System.out.println("Adjacent: " + graph.adj(2));
    }

    //                  //
    //// Graph Matrix ////
    //                  //
    public static void graphMatrix()
    {
        Graph graph = readGraphTextFile();

        System.out.println("---------------------------------------");
        System.out.println("Graph Matrix:");
        System.out.println(graph);
        System.out.print("Ajacent: " );

        int adjacent = 2;

        for(int w: graph.adj(adjacent))
        {
            System.out.print(w + " ");
        }

        System.out.println();
    }

    //                    //
    //// Directed Graph ////
    //                    //
    public static void directedGraph()
    {
        DirectedGraph directedGraph = readDirectedGraphTextFile();

        System.out.println(directedGraph);
        System.out.println("In Degree: " + directedGraph.inDegree(1));
        System.out.println("Out Degree: " + directedGraph.outDegree(1));
        System.out.println("Directed Graph Adjacent: " + directedGraph.adj(1));
    }

    //                        //
    //// Depth First Search ////
    //                        //
    public static void depthFirstSearch()
    {
        Graph graph = readGraphTextFile();

        System.out.println("---------------------------------------");
        System.out.println("Depth First Search Graph:");
        System.out.println(graph);

        int startingVertex = 0;
        int endingVertex = 6;

        DepthFirstSearch bfs = new DepthFirstSearch(graph, startingVertex);

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
        Graph graph = readGraphTextFile();

        System.out.println("---------------------------------------");
        System.out.println("Breadth First Search Graph:");
        System.out.println(graph);

        int startingVertex = 0;
        int endingVertex = 6;

        BreadthFirstSearch bfs = new BreadthFirstSearch(graph, startingVertex);

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
        DirectedGraph directedGraph = readDirectedGraphTextFile();

        System.out.println("---------------------------------------");
        System.out.println("Directed and Cycle Graph:");
        System.out.println(directedGraph);

        DirectedCycle dc = new DirectedCycle(directedGraph);

        if(dc.hasCycle())
        {
            System.out.println("Cycle: " + dc.cycle());
        }
    }

    //                                //
    //// Topological Directed Graph ////
    //                                //
    public static void topologicalDirectedGraph()
    {

        DirectedGraph directedGraph = readDirectedGraphTextFile();

        DirectedCycle directedCycle = new DirectedCycle(directedGraph);

        if(!directedCycle.hasCycle())
        {
            DepthFirstOrder depthFirstOrder = new DepthFirstOrder(directedGraph);
            System.out.println(depthFirstOrder.reversePostOrder());
        }
        else
        {
            System.out.println("No topological order.");
        }
    }

    //                         //
    //// Edge Weighted Graph ////
    //                         //
    public static void edgeWeightedGraph()
    {
        EdgeWeightedGraph edgeWeightedGraph = readEdgeWeightedGraphTextFile();

        System.out.println(edgeWeightedGraph);
    }

    //                                  //
    //// Edge Weighted Directed Graph ////
    //                                  //
    public static void edgeWeightedDirectedGraph()
    {
        EdgeWeightedDirectedGraph edgeWeightedDirectedGraph = readEdgeWeightedDirectedGraphTextFile();

        System.out.println(edgeWeightedDirectedGraph);
    }

    //               //
    //// Prim's Lazy ////
    //               //
    public static void primLazy()
    {
        EdgeWeightedGraph edgeWeightedGraph = readEdgeWeightedGraphTextFile();


        PrimLazy prim = new PrimLazy(edgeWeightedGraph);

        System.out.println(edgeWeightedGraph);
        System.out.println(prim.weight());
        System.out.println(prim.mst());
    }

    //                                     //
    //// Kruskal's Minimum Spanning Tree ////
    //                                     //
    public static void kruskalMST()
    {
        EdgeWeightedGraph edgeWeightedGraph = readEdgeWeightedGraphTextFile();

        KruskalMST prim = new KruskalMST(edgeWeightedGraph);

        System.out.println(edgeWeightedGraph);
        System.out.println(prim.weight());
        System.out.println(prim.mst());
    }

    //                              //
    //// Dijkstra's Shortest Path ////
    //                              //
    public static void dijkstrasShortestPath()
    {

        EdgeWeightedDirectedGraph edgeWeightedDirectedGraph = readEdgeWeightedDirectedGraphTextFile();

        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(edgeWeightedDirectedGraph, 0);

        System.out.println(edgeWeightedDirectedGraph);
        System.out.println(dijkstraShortestPath.distTo(1));
        System.out.println(dijkstraShortestPath.hasPathTo(1));
        System.out.println(dijkstraShortestPath.pathTo(1));
    }
}
