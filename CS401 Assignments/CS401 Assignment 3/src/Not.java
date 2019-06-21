//              :   General Layout:
//              :   Query (interface) -> And, Or, Not, UnaryExpression
//              :       -execute, getField
//              :   UnaryExpression (abstract) -> Equal, GT, GTE, LT, LTE, NotEqual
//              :       -execute, field, value, getField

import edu.princeton.cs.algs4.RedBlackBST;
import java.util.HashSet;
import java.util.Map;

public class Not<T extends Comparable<T>> implements Query<T> {

    // Not should only accept 1 query
    Query query;

    public Not(Query query) {
        this.query = query;
    }

    @Override
    public HashSet<Integer> execute(Map<String, RedBlackBST<T, HashSet<Integer>>> indexTreeMap) {

        String field = query.getField();

        // this is everything we don't want
        HashSet<Integer> equals = query.execute(indexTreeMap);


        // this is everything
        HashSet<Integer> notEquals = new HashSet<>();
        for (T s:indexTreeMap.get(field).keys()) {
            notEquals.addAll(indexTreeMap.get(field).get(s));
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
        return null;
    }
}
