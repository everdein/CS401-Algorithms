import edu.princeton.cs.algs4.RedBlackBST;
import java.util.HashSet;
import java.util.Map;

public class GT<T extends Comparable<T>> extends UnaryExpression<T> {

    public GT(String field, T value) {
        super(field, value);
    }

    @Override
    public HashSet<Integer> execute(Map<String, RedBlackBST<T, HashSet<Integer>>> indexTreeMap) {

        RedBlackBST<T, HashSet<Integer>> RBT = new RedBlackBST<>();
        RBT = indexTreeMap.get(field);

        HashSet<Integer> temp = new HashSet<>();

        // if compareTo is greater than, then you
        for (T s: RBT.keys()) {
            if(s.compareTo(value) > 0) {
                temp.addAll(RBT.get(s));
                // this works as well
//                for (int value : RBT.get(s)) {
//                    temp.add(value);
//                }
            }
        }
        return temp;
    }

    @Override
    public String getField() {
        return field;
    }
}
