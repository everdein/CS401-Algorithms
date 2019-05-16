public class separateChainingHashST<Key, Value>
{
    private int n; // Number of key-value pairs
    private int m = 19; // Hash table size
    private SequentialSearchST<Key, Value>[] st;

    public separateChainingHashST(int m)
    {
        st = new SequentialSearchST[m];
        for(int i = 0; i < m; i++)
        {
            st[i] = new SequentialSearchST<Key, Value>();
        }
    }
    int hash(Key key)
    {
        return (key.hashCode() & 0x7fffffff) % m;
    }
    public Value get(Key key)
    {
        if(key == null)
        {
            throw new IllegalArgumentException();
        }
        int h = hash(key);
        return st[h].get(key);
    }
    public void put(Key key, Value value)
    {
        if(key == null)
        {
            throw new IllegalArgumentException();
        }
        if(value == null)
        {
            return; // Delete(key)
            // if(n > 10)
            // resize 2*n
        }

        int h = hash(key);
        st[h].put(key, value);
    }
}
