public interface UnionFind {

	//replace sets containing p and q with their union
	public void union(int p, int q);
	
	//are p and q in the same set
	public boolean find(int p, int q);
	
	//number of connected components
	public int getCount();
	
}


