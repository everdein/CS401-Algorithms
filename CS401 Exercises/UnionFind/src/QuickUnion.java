// package unionfind;

import edu.princeton.cs.algs4.StdOut;

public class QuickUnion implements UnionFind {
	protected int[] id;
	protected int count;
	public QuickUnion(int n) {
		id = new int[n];
		for (int i = 0; i < id.length; i++) {
			id[i] = i;
		}
		count = n;
	}
	protected int root(int i) {
		while(id[i]!=i) {
			i = id[i];
		}
		return i;		
	}
	@Override
	public void union(int p, int q) {
		if(find(p,q)) return;
		int rp = root(p);
		int rq = root(q);
		id[rp] = rq;
		count--;
	}

	@Override
	public boolean find(int p, int q) {
		return root(p) == root(q);
	}

	@Override
	public int getCount() {
		return count;
	}

}
