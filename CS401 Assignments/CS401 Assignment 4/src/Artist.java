// Implements interface comparable.
class Artist implements Comparable<Artist>
{
    // Creates variables.
    private int id;
    private String name;
    private double weight;

    // Sets variables.
    public Artist()
    {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    // Getters & Setters.
    public int getID()
    {
        return id;
    }

    public void setID(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getWeight()
    {
        return weight;
    }

    public void setWeight(double weight)
    {
        this.weight = weight;
    }

    // Compares the weight of two artists.
    @Override
    public int compareTo(Artist artist)
    {
        Double weight1 = this.weight;
        Double weight2 = artist.weight;
        return weight1.compareTo(weight2);
    }
}

