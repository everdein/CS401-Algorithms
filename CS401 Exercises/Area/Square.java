public class Square extends Shape
{
    private void op1()
    {
        System.out.println("Hey");
    }
    
    public static int op2()
    {
        return 10;
    }

    @Override
    public double area(int side)
    {
        return side*side;
    }
}