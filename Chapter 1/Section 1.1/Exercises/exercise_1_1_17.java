// 1.1.17 Criticize the following recursive function:

class exercise_1_1_17
{
    public static void main(String[] args)
    {
        int n = 3;
        String s = exR2(n);
        System.out.println(s);
    }
    public static String exR2(int n)
    {
        String s = exR2(n-3) + n + exR2(n-2) + n;
        if (n <= 0) return "";
        return s;
    }
}