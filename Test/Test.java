public class Test
{
    public static void main(String[] args) 
    {
        int n = 6;
        System.out.println(compute(n));
    }
    public static int compute(int n)
    {
        int total = 0;
        for(int i = 1; i < n; i++)
        {
            int k = 1;
            while(k < i)
            {
                k = k + k;
            }
            while(k > 1)
            {
                k /= 2;
            }
        }
        return total;
    }
}