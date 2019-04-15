public class App
{
    public static void main(String[] args)
    {
        Shape s = new Square();
        System.out.println(s.area(10));
        s = new Circle();
        System.out.println(s.area(10));
        System.out.println(Square.op2());
        // Square.op1(); // Error: Private method.
    }
}