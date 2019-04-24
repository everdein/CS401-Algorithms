class absoluteValueOfIntValue
{
    public static void main(String[] args)
    {
        int x = -100;
        int absoluteValue = abs(x);
        System.out.println(absoluteValue);
    }
    public static int abs(int x)
    {
        if (x < 0)
        {
            return -x;
        }
        else
        {
            return x;
        }
    }
}