// Write a program that takes three integer command-line arguments and 
// prints equal if all three are equal, and not equal otherwise.

class exercise_1_1_03
{
    public static void main(String[] args)
    {
        int a = 69;
        int b = 69;
        int c = 68;
        check(a, b, c);
    }
    public static void check(int a, int b, int c)
    {
        if(a == b && b == c)
        {
            System.out.println("Equal");
        }
        else
        {
            System.out.println("Not equal");
        }
    }
}