import edu.princeton.cs.algs4.RedBlackBST;

import java.util.HashSet;
import java.util.Map;

public class EqualTo implements Query
{
    private String string1;
    private String string2;
    private RedBlackBST<String, HashSet<Integer>> movieFieldRBT = new RedBlackBST<>();

    public EqualTo(String string1, String string2)
    {
        this.string1 = string1;
        this.string2 = string2;
    }

    @Override
    public HashSet<Integer> execute(Map<String, RedBlackBST<String, HashSet<Integer>>> movieFieldsRBTMap)
    {
        movieFieldRBT = movieFieldsRBTMap.get(string1);
        return movieFieldRBT.get(string2);
    }
}
