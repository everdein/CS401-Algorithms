import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

public abstract class Or <T extends Comparable<T>> implements Query
{
    private ArrayList<Query> queries;

    public Or(Query... queries)
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
        HashSet<Integer> orResult = new HashSet<>();
        for(int i = 0; i < queries.size(); i++)
        {
            Query temp = queries.get(i);
            HashSet<Integer> tempHashSet = temp.execute(redBlackBSTMap);
            orResult.addAll(tempHashSet);
        }
        return orResult;
    }

}
