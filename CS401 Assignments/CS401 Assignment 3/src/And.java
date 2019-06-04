import edu.princeton.cs.algs4.RedBlackBST;
import java.util.*;

public class And<T extends Comparable<T>> implements Query<T> {

    private ArrayList<Query> queries = new ArrayList<Query>();
    private ArrayList<HashSet<Integer>> hashSets = new ArrayList<>();

    public And(Query... queries) {
        this.queries = new ArrayList<Query>();
        this.queries.addAll(Arrays.asList(queries));
    }

    @Override
    public HashSet<Integer> execute(Map<String, RedBlackBST<T, HashSet<Integer>>> indexTreeMap) {

        // add all the hashsets from the queries
        for (int i = 0; i < queries.size(); i++) {
            Query temp = queries.get(i);
            hashSets.add(temp.execute(indexTreeMap));
        }


        // i don't know why this code doesn't work...
//        HashSet<Integer> andResult = hashSets.get(0);
//
//        for(int i = 1; i < hashSets.size(); i++) {
//            HashSet<Integer> tempHS = hashSets.get(i);
//            for (int j : hashSets.get(0)) {
//                if(!tempHS.contains(j)) {
//                    andResult.remove(j);
//                }
//            }
//        }

        HashSet<Integer> andResult = hashSets.get(0);

        // retainAll grabs the intersection
        for (int i = 1; i < hashSets.size(); i++) {
            andResult.retainAll(hashSets.get(i));
        }

        return andResult;
    }

    @Override
    public String getField() {
        return null;
    }
}