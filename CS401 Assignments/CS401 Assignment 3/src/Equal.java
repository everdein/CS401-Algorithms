import edu.princeton.cs.algs4.RedBlackBST;
import java.util.HashSet;
import java.util.Map;

public class Equal<T extends Comparable<T>> extends UnaryExpression<T> {

    public Equal(String field, T value) {
        super(field, value);
    }

    @Override
    public HashSet<Integer> execute(Map<String, RedBlackBST<T, HashSet<Integer>>> indexTreeMap) {

        RedBlackBST<T, HashSet<Integer>> RBT = new RedBlackBST<>();
        RBT = indexTreeMap.get(field);

        return RBT.get(value);
    }

    @Override
    public String getField() {
        return field;
    }
}
