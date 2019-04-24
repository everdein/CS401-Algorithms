/* 1.1.14 Write a static method lg() that takes an int value N as an argument and returns
the largest int not larger than the base-2 logarithm of N. Do not use Math.*/

class exercise_1_1_14
{
    public static void main(String[] args)
    {
        int n = 4;
        int conversion = lg(n);
        System.out.println(conversion);
    }

    public static int lg(int n)
    {
        int count = 0;
        while(n>0)
        {
            count++;
            n /= 2;
        }
        return count -1;
    }
    
    // This is the solution with Math.
    // public static double lg(double n)
    // {
    //     double conversion = (Math.log(n) / Math.log(2));
    //     return conversion;
    // }
}