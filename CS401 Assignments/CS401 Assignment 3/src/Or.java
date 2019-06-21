//              :   General Layout:
//              :   Query (interface) -> And, Or, Not, UnaryExpression
//              :       -execute, getField
//              :   UnaryExpression (abstract) -> Equal, GT, GTE, LT, LTE, NotEqual
//              :       -execute, field, value, getField

import edu.princeton.cs.algs4.RedBlackBST;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

public class Or<T extends Comparable<T>> implements Query<T> {

    private ArrayList<Query> queries = new ArrayList<Query>();

    public Or(Query... queries) {
        this.queries = new ArrayList<Query>();
        this.queries.addAll(Arrays.asList(queries));
    }

    @Override
    public HashSet<Integer> execute(Map<String, RedBlackBST<T, HashSet<Integer>>> indexTreeMap) {

        HashSet<Integer> orResult = new HashSet<>();

        // combines all query results
        for(int i = 0; i < queries.size(); i++) {
            Query temp = queries.get(i);
            HashSet<Integer> tempHS = temp.execute(indexTreeMap);
            orResult.addAll(tempHS);
        }

        return orResult;
    }

    @Override
    public String getField() {
        return null;
    }
}