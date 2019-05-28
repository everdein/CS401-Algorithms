import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

public abstract class And <T extends Comparable<T>> implements Query
{
    private ArrayList<Query> queries;

    public And(Query... queries)
    {
        this.queries = new ArrayList<>();
        for(Query query : queries)
        {
            this.queries.add(query);
        }
    }

    @Override
    public HashSet<Integer> execute(Map redBlackBSTMap)
    {
        HashSet<Integer> andResult = new HashSet<>();
        for(int i = 0; i < queries.size(); i++)
        {
            Query temp = queries.get(i);
            HashSet<Integer> tempHashSet = temp.execute(redBlackBSTMap);
            andResult.addAll(tempHashSet);
        }
        return andResult;
    }

}
