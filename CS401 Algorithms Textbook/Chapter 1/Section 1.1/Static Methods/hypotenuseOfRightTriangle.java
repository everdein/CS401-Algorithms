class hypotenuseOfRightTriangle
{
    public static void main(String[] args)
    {
        double a = 4.0;
        double b = 4.0;
        double value = hypotenuse(a, b);
        System.out.println(value);
    }
    public static double hypotenuse(double a, double b)
    {
        return Math.sqrt(a * a + b * b);
    }
}