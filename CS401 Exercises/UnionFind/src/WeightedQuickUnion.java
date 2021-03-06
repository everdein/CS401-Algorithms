import edu.princeton.cs.algs4.StdOut;

public class WeightedQuickUnion extends QuickUnion
{
    private int[] size;
    public WeightedQuickUnion(int n)
    {
        super(n);
        size = new int[n];
        for(int i = 0; i < n; i++)
        {
            size[i] = 1;
        }
    }
    public void root(int p, int q)
    {
        if(find(p, q))
        {
            StdOut.println("No change.");
            return;
        }
        int rp = root(p);
        int rq = root(q);
        if(size[rp] <= size[rq])
        {
            id[rp] = rq;
            size[rp] += size[rq];
        }
        else
        {
            id[rq] = rp;
            size[rq] += size[rp];
        }
        for (int x : id)
        {
            StdOut.print(x);
        }
        StdOut.println();
        count--;
    }
}




















































//import edu.princeton.cs.algs4.StdOut;
//
//public class WeightedQuickUnion extends QuickUnion
//{
//    private int[] size;
//    public WeightedQuickUnion(int n)
//    {
//        super(n);
//        size = new int[n];
//        for(int i = 0; i < n; i ++)
//        {
//            size[i] = 1;
//        }
//    }
//    @Override
//    public void union(int p, int q)
//    {
//        if(find(p, q))
//        {
//            StdOut.println("No change.");
//            return;
//        }
//        int rp = root(p);
//        int rq = root(q);
//        if(size[rp] <= size[rq])
//        {
//            id[rp] = rq;
//            size[rq] += size[rp];
//        }
//        else
//        {
//            id[rq] = rp;
//            size[rp] += size[rq];
//        }
//        for (int x : id)
//        {
//            StdOut.print(x);
//        }
//        StdOut.println();
//        count--;
//    }
//}
