// 1.1.19 Run the following program on your computer:
/* What is the largest value of N for which this program takes less 1 hour to compute the
value of F(N)? Develop a better implementation of F(N) that saves computed values in
an array. */

class exercise_1_1_19
{
    // public static void main(String[] args)
    // {
    //     for (int N = 0; N < 100; N++)
    //     System.out.println(N + " " + F(N));
    // } 
    // public static long F(int N)
    // {
    //     if (N == 0) return 0;
    //     if (N == 1) return 1;
    //     return F(N-1) + F(N-2);
    // }

    public static void main(String[] args) 
    {
        for (int n = 0; n < 90; n++) 
        {
            int[] arr;
                    
            if (n == 0 || n == 1) 
            {
                arr = new int[2];
            } 
            else 
            {
                arr = new int[n+1];
            }    
            arr[0] = 0;
            arr[1] = 1;
            System.out.println(n + " - " + enhancedF(n, arr));
        }
    }
            
    private static int enhancedF(int n, int[] arr) 
    {
        if (n == 0) return arr[0];
        if (n == 1) return arr[1];        
        for (int i = 2; i <= n; i++) 
        {
            arr[i] = arr[i-2] + arr[i-1];
        }
        return arr[n];
    }
}