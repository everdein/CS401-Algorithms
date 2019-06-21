//              :   General Layout:
//              :   Query (interface) -> And, Or, Not, UnaryExpression
//              :       -execute, getField
//              :   UnaryExpression (abstract) -> Equal, GT, GTE, LT, LTE, NotEqual
//              :       -execute, field, value, getField

import edu.princeton.cs.algs4.RedBlackBST;
import java.util.HashSet;
import java.util.Map;

public class Equal<T extends Comparable<T>> extends UnaryExpression<T> {

    public Equal(String field, T value) {
        super(field, value);
    }

    // probably the simplest operation. Just returns the value of the given key.
    @Override
    public HashSet<Integer> execute(Map<String, RedBlackBST<T, HashSet<Integer>>> indexTreeMap) {

        RedBlackBST<T, HashSet<Integer>> RBT = new RedBlackBST<>();
        RBT = indexTreeMap.get(field);

        return RBT.get(value);
    }

    // returns field from super class UnaryExpression
    @Override
    public String getField() {
        return field;
    }
}
