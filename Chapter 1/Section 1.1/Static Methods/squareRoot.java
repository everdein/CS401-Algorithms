import java.util.*;

class squareRoot
{
    public static void main(String[] args)
    {
        double c = 16.0;
        double t = sqrt(c);
        System.out.println(t);
    }
    public static double sqrt(double c)
    {
        if (c < 0)
        {
            return Double.NaN;
        }
        double err = 1e-15;
        double t = c;
        while (Math.abs(t - c/t) > err * t)
        {
            t = (c/t + t) / 2.0;
        }
        return t;
    }
}