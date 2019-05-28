import edu.princeton.cs.algs4.RedBlackBST;

import java.util.HashSet;
import java.util.Map;

public abstract class Not <T extends Comparable<T>> implements Query
{
    private RedBlackBST<T, HashSet<Integer>> movieFieldRBT = new RedBlackBST<>();

    public T mapKey;
    public T rbtKey;

    public Not(T mapKey, T rbtKey)
    {
        this.mapKey = mapKey;
        this.rbtKey = rbtKey;
    }

    @Override
    public HashSet<Integer> execute(Map movieFieldsRBTMap) {
        // Gets and stores field red black tree.
        movieFieldRBT = (RedBlackBST<T, HashSet<Integer>>) movieFieldsRBTMap.get(mapKey);

        // Creates temporary hash set.
        HashSet<Integer> tempHashSet = new HashSet<>();

        // For each iterates through all red black tree keys.
        for (T mapKey : movieFieldRBT.keys())
        {
            // If the passed in field (rbtKey) is greater than the red black tree key currently being compared.
            if(mapKey.compareTo(rbtKey) != 0)
            {
                // Grab all values of current red black tree key and store into temporary has set.
                for (int value : movieFieldRBT.get(mapKey))
                {
                    tempHashSet.add(value);
                }
            }
        }

        // Return temporary hash set.
        return tempHashSet;    }
}
