public class Edge
{
    private int v;
    private int w;
    private double weight;

    public Edge(int v, int w, double weight)
    {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    // Will return first created node.
    public int either()
    {
        return v;
    }

    // Will return opposite node.
    public int other(int vertex)
    {
        if(vertex == this.v)
        {
            return w;
        }
        else if(vertex == this.w)
        {
            return v;
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }

    // Will return edge weight.
    public double weight()
    {
        return weight;
    }

    @Override
    public String toString()
    {
        return v + "-" + w + " " + weight + " ";
    }
}
