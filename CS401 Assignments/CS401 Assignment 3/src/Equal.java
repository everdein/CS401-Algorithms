import edu.princeton.cs.algs4.RedBlackBST;

import java.util.HashSet;
import java.util.Map;

public class Equal<T extends Comparable<T>> extends UnaryExpression<T>
{
    private RedBlackBST<T, HashSet<Integer>> movieFieldRBT = new RedBlackBST<>();

    public Equal(String mapKey, T rbtKey)
    {
        super(mapKey, rbtKey);
    }

    @Override
    public HashSet<Integer> execute(Map movieFieldsRBTMap)
    {
        movieFieldRBT = (RedBlackBST<T, HashSet<Integer>>) movieFieldsRBTMap.get(mapKey);
        return movieFieldRBT.get(rbtKey);
    }

}