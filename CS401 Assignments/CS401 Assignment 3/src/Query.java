//              :   General Layout:
//              :   Query (interface) -> And, Or, Not, UnaryExpression
//              :       -execute, getField
//              :   UnaryExpression (abstract) -> Equal, GT, GTE, LT, LTE, NotEqual
//              :       -execute, field, value, getField

import edu.princeton.cs.algs4.RedBlackBST;
import java.util.HashSet;
import java.util.Map;

// interface that all query operation classes will implement
// must have execute and getField
// getField is only required in a few of them.
public interface Query<T extends Comparable<T>> {
    HashSet<Integer> execute(Map<String, RedBlackBST<T, HashSet<Integer>>> indexTreeMap);
    String getField();
}
