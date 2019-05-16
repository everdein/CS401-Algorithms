import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Client
{
    public static void main(String[] args)
    {
        In in = new In("dataset1.txt");
        int n = in.readInt();
//        UnionFind uf = new QuickFind(n);
//        UnionFind uf = new QuickUnion(n);
        UnionFind uf = new WeightedQuickUnion(n);
        while(!in.isEmpty())
        {
            int p = in.readInt();
            int q = in.readInt();
            uf.union(p, q);
        }
        StdOut.print("Number of Components: " + uf.getCount());
    }
}