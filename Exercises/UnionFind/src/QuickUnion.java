public class QuickUnion implements UnionFind {

	protected int[] id;
	protected int n;
	protected int count;
	//initialize quick union data structure with size N
	public QuickUnion(int n) {
		this.n= n;
		id = new int[n];
		count = n;
		initialize();
	}
	//set id objects to itself (n disjoint sets, n connected components)
	private void initialize() {
		for (int i = 0; i < id.length; i++) {
			id[i] = i;
		}
	}
	//get the root of i
	protected int root(int i) {
		while(id[i] != i) {
			i = id[i];
		}
		return i;
	}
	//change the root of p to point to root of q
	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		if(i==j) 
			return;
		id[i] = j;
		count--;
	}
	//check if p and q have the same root
	public boolean find(int p, int q) {
		return root(p) == root(q);
	}
	
	public int getCount() {
		return count;
	}
}


