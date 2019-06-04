public class WeightedQuickUnionWithPathCompression extends WeightedQuickUnion{

    private int[] parent;

    public WeightedQuickUnionWithPathCompression(int n) {
        super(n);
    }

    // Makes every other node in path point to its grandparent
    // (thereby halving path length).
    // This should flatten out the tree quite a bit and improve efficiency.
    @Override
    public int root(int i) {
        while (id[i] != i) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    // according to Sedgewick, if we Start from an empty data structure,
    // any sequence of M union-find operations on N objects makes
    // <= c(N + M lg* N) array accesses.
    // lg* N (read "log star") is REALLY efficient. For example:
    // N        lg* N
    // 1        0
    // 2        1
    // 4        2
    // 16       3
    // 65536    4
    // 2^65536  5
    // this is the "iterated logarithm" of n.
    // the number of times the logarithm function must be iteratively
    // applied before the result is less than or equal to 1.
}
