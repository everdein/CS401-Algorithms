import edu.princeton.cs.algs4.RedBlackBST;

import java.util.HashSet;
import java.util.Map;

public interface Query
{
    HashSet<Integer> execute(Map<String, RedBlackBST<String, HashSet<Integer>>> movieFieldsRBTMap);

}
