import edu.princeton.cs.algs4.RedBlackBST;

import java.util.HashSet;
import java.util.Map;

public class EqualTo <T extends Comparable<T>> // extends UnaryExpression
{
    private RedBlackBST<T, HashSet<Integer>> movieFieldRBT = new RedBlackBST<>();

    T mapKey;
    T rbtKey;

    public EqualTo(T mapKey, T rbtKey)
    {
//        super(mapKey, rbtKey);
        this.mapKey = mapKey;
        this.rbtKey = rbtKey;
    }


//    @Override
    public HashSet<Integer> execute(Map<String, RedBlackBST<T, HashSet<Integer>>> movieFieldsRBTMap)
    {
        movieFieldRBT = movieFieldsRBTMap.get(mapKey);
        return movieFieldRBT.get(rbtKey);
    }

//    @Override
//    public HashSet<Integer> execute(Map movieFieldsRBTMap)
//    {
//        movieFieldRBT = movieFieldsRBTMap.get(mapKey);
//        return movieFieldRBT.get(rbtKey);
//    }
}

//    HashSet<Integer> execute(Map<String, RedBlackBST<String, HashSet<Integer>>> movieFieldsRBTMap)