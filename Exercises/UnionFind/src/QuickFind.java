public class QuickFind implements UnionFind{

	private int[] id;
	private int count;
	
	//create quick-find data structure 
	//with N objects and no connections
	public QuickFind(int n) {
		id = new int[n];
		count = n;
		initialize();
	}
	
	//set id of each object to itself (n disjoint sets)
	private void initialize() {
		for (int i = 0; i < id.length; i++) {
			id[i] = i;
		}
	}

	//change all entries with id[p] to id[q]
	@Override
	public void union(int p, int q) {
		int pId = id[p];
		int qId = id[q];
		if(id[p] == id[q]) return;
		for (int i = 0; i < id.length; i++) {
			if(id[i] == pId)
				id[i] = qId;
		}
		count--;
	}
	
	//check if p and q have the same id 
	@Override
	public boolean find(int p, int q) {
		return id[p] == id[q];
	}
	public int getCount() {
		return count;
	}
}


