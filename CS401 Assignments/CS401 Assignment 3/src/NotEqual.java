import edu.princeton.cs.algs4.RedBlackBST;
import java.util.HashSet;
import java.util.Map;

public class NotEqual<T extends Comparable<T>> extends UnaryExpression<T> {


    public NotEqual(String field, T value) {
        super(field, value);
    }

    @Override
    public HashSet<Integer> execute(Map<String, RedBlackBST<T, HashSet<Integer>>> indexTreeMap) {

        RedBlackBST<T, HashSet<Integer>> RBT = new RedBlackBST<>();
        RBT = (RedBlackBST<T, HashSet<Integer>>) indexTreeMap.get(field);

        // this is everything we don't want
        HashSet<Integer> equals = RBT.get(value);

        // this is everything
        HashSet<Integer> notEquals = new HashSet<Integer>();
        for (T s: RBT.keys()) {
            notEquals.addAll(RBT.get(s));
        }

        // remove everything we don't want from everything
        for (int i : equals) {
            if(notEquals.contains(i)) {
                notEquals.remove(i);
            }
        }

        return notEquals;
    }

    @Override
    public String getField() {
        return field;
    }
}
