import edu.princeton.cs.algs4.RedBlackBST;
import java.util.HashSet;
import java.util.Map;

public interface Query<T extends Comparable<T>> {
    HashSet<Integer> execute(Map<String, RedBlackBST<T, HashSet<Integer>>> indexTreeMap);
    String getField();
}
