public abstract class UnaryExpression <T extends Comparable<T>> implements Query
{

    protected String mapKey;
    protected T rbtKey;

    public UnaryExpression(String mapKey, T rbtKey)
    {
        this.mapKey = mapKey;
        this.rbtKey = rbtKey;
    }

}