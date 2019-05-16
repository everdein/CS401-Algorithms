import edu.princeton.cs.algs4.StdOut;

public class QuickUnion implements UnionFind
{
//    private int count;
    protected int count;
//    private int[] id;
    protected int[] id;
    public QuickUnion(int n)
    {
        count = n;
        id = new int[n];
        for(int i = 0; i < id.length; i++)
        {
            id[i] = i;
        }
    }

    protected int root(int i)
    {
        while(id[i] != i)
        {
            i = id[i];
        }
        return i;
    }

    @Override
    public void union(int p, int q)
    {
        if(find(p, q))
        {
            StdOut.println("No change.");
            return;
        }
        int rp = root(p);
        int rq = root(q);
        id[rp] = rq;
        for (int x : id)
        {
            StdOut.print(x);
        }
        StdOut.println();
    }

    @Override
    public boolean find(int p, int q)
    {
        return root(p) == root(q);
    }

    @Override
    public int getCount()
    {
        return count;
    }
}