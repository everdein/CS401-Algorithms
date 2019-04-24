// 1.1.20 Write a recursive static method that computes the value of ln (N !)

class exercise_1_1_20
{
    public static void main(String[] args)
    {
        System.out.println(Math.log(factorial(5)));
    }
    public static int factorial(int n)
    {
        if(n == 1) return 0;
        else return n * factorial(n-1);
    }
}