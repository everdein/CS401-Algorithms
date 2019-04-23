import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StopwatchCPU;

public class Client {
	
	public static void main(String[] args) {
        In in = new In("dataset1.txt");
		int n = in.readInt();
        UnionFind uf = new QuickFind(n);
        while (!in.isEmpty()) {
            int p = in.readInt();
            int q = in.readInt();
            if (uf.find(p, q))
            	continue;
            uf.union(p, q);
        }
        StdOut.println(uf.getCount() + " components");
  	}

}
