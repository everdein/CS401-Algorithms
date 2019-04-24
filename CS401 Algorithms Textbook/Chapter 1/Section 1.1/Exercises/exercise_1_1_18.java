// 1.1.18 Consider the following recursive function:

class exercise_1_1_18
{
    public static void main(String[] args)
    {
        int a = 2;
        int b = 25;
        // int a = 3;
        // int b = 11;

        int result = mystery(a,b);
        System.out.println(result);
    }
    public static int mystery(int a, int b)
    {
        if (b == 0) return 0;
        if (b % 2 == 0) return mystery(a+a, b/2);
        return mystery(a+a, b/2) + a;
    }
}

/* What are the values of mystery(2, 25) and mystery(3, 11)? Given positive integers
a and b, describe what value mystery(a, b) computes. Answer the same question, but
replace + with * and replace return 0 with return 1. */