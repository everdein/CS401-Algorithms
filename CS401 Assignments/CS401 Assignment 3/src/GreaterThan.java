import edu.princeton.cs.algs4.RedBlackBST;

import java.util.HashSet;
import java.util.Map;

public class GreaterThan <T extends Comparable<T>>
{

    private RedBlackBST<T, HashSet<Integer>> movieFieldRBT = new RedBlackBST<>();

    T mapKey;
    T rbtKey;

    public GreaterThan(T mapKey, T rbtKey)
    {
//        super(mapKey, rbtKey);
        this.mapKey = mapKey;
        this.rbtKey = rbtKey;

    }

//    @Override
    public HashSet<Integer> execute(Map<T, RedBlackBST<T, HashSet<Integer>>> movieFieldsRBTMap)
    {
        // Gets and stores field red black tree.
        movieFieldRBT = movieFieldsRBTMap.get(mapKey);

        // Creates temporary hash set.
        HashSet<Integer> tempHashSet = new HashSet<>();

        // For each iterates through all red black tree keys.
        for (T mapKey : movieFieldRBT.keys())
        {
            // If the passed in field (rbtKey) is greater than the red black tree key currently being compared.
            if(mapKey.compareTo(rbtKey) > 0)
            {
                // Grab all values of current red black tree key and store into temporary has set.
                for (int value : movieFieldRBT.get(mapKey))
                {
                    tempHashSet.add(value);
                }
            }
        }

        // Return temporary hash set.
        return tempHashSet;
    }
}