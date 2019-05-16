public interface UnionFind
{
    void union(int p, int q);
    boolean find(int p, int q);
    int getCount();
    void print();
}
