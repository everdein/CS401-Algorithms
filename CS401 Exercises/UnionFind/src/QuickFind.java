import edu.princeton.cs.algs4.StdOut;

public class QuickFind implements UnionFind
{
    private int count;
    private int[] id;

    public QuickFind(int n)
    {
        count = n;
        id = new int[n];
        for(int i = 0; i < id.length; i++)
        {
            id[i] = i;
        }
    }

    @Override
    public void union(int p, int q)
    {
        if(find(p, q))
        {
            StdOut.println("No change.");
            return;
        }
        int pId = id[p];
        int qId = id[q];
        for(int i = 0; i < id.length; i++)
        {
            if(id[i] == pId)
            {
                id[i] = qId;
            }
        }
        for (int x : id)
        {
            StdOut.print(x);
        }
        StdOut.println();
        count--;
    }

    @Override
    public boolean find(int p, int q)
    {
        return id[p] == id[q];
    }

    @Override
    public int getCount()
    {
        return count;
    }
}









































//import edu.princeton.cs.algs4.StdOut;
//
//public class QuickFind implements UnionFind
//{
//    private int[] id;
//    private int count;
//
//    public QuickFind(int n)
//    {
//        count = n;
//        id = new int[n];
//        for(int i = 0; i < id.length; i++)
//        {
//            id[i] = i;
//        }
//    }
//
//    @Override
//    public void union(int p, int q)
//    {
//        if(find(p, q))
//        {
//            StdOut.println("No change.");
//            return;
//        }
//        int pId = id[p];
//        int qId = id[q];
//        for(int i = 0; i < id.length; i++)
//        {
//            if(id[i] == pId)
//            {
//                id[i] = qId;
//            }
//        }
//        for (int x : id)
//        {
//            StdOut.print(x);
//        }
//        StdOut.println();
//    }
//
//    @Override
//    public boolean find(int p, int q)
//    {
//        return id[p] == id[q];
//    }
//
//    @Override
//    public int getCount()
//    {
//        return count;
//    }
//}