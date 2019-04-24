// package unionfind;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class Client {
	
	public static void main(String[] args) {
		In in = new In("dataset1.txt");
		int n = in.readInt();
		UnionFind uf = new WeightedQuickUnion(n);

		while(!in.isEmpty()) {
			int p = in.readInt();
			int q = in.readInt();
			uf.union(p, q);
		}

		StdOut.println(uf.getCount());
	}
	
	


}
