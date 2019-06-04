import edu.princeton.cs.algs4.RedBlackBST;
import java.util.HashSet;
import java.util.Map;

public class GTE<T extends Comparable<T>> extends UnaryExpression<T> {

    public GTE (String field, T value) {
        super(field, value);
    }

    @Override
    public HashSet<Integer> execute(Map<String, RedBlackBST<T, HashSet<Integer>>> indexTreeMap) {

        RedBlackBST<T, HashSet<Integer>> RBT = new RedBlackBST<>();
        RBT = indexTreeMap.get(field);

        HashSet<Integer> temp = new HashSet<>();

        // same as GT, we just add the =
        for (T s: RBT.keys()) {
            if(s.compareTo(value) >= 0) {
                temp.addAll(RBT.get(s));
            }
        }
        return temp;
    }

    @Override
    public String getField() {
        return field;
    }
}
