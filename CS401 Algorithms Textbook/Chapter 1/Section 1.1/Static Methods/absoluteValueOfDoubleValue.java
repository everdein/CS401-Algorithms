class absoluteValueOfDoubleValue
{
    public static void main(String[] args)
    {
        double x = -100.0;
        double absoluteValue = abs(x);
        System.out.println(absoluteValue);
    }
    public static double abs(double x)
    {
        if (x < 0.0)
        {
            return -x;
        }
        else
        {
            return x;
        }
    }
}