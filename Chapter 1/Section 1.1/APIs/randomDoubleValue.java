import java.util.Random;

class randomDoubleValue
{
    public static void main(String[] args)
    {
        double a = 0.0;
        double b = 1.0;

        double randomDoubleValue = uniform(a, b);
        System.out.println(randomDoubleValue);

    }
    public static double uniform(double a, double b)
    {
        // StdRandom -- cannot find value
        return a + StdRandom.uniform() * (b - a);
    }
}