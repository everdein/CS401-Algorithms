// package unionfind;

public class WeightedQuickUnion extends QuickUnion{
   
	private int[] size;
	
	public WeightedQuickUnion(int n) {
	    super(n);
	    size = new int[n];
	    for (int i = 0; i < n; i++) {
			size[i] = 1;
		}
   }
	@Override
	public void union(int p, int q) {
		if(find(p,q)) return;
		int rp = root(p);
		int rq = root(q);
		if(size[rp]<=size[rq]) {
			id[rp] = rq;//id[rp] = id[rq];
			size[rq] += size[rp];
		}else {
			id[rq] = rp;
			size[rp] += size[rq];
		}
		count--;
	}
}
