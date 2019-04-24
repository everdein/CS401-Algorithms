class primalityTest
{
    public static void main(String[] args)
    {
        int N = 15;
        boolean primeNumber = isPrime(N);
        System.out.println(primeNumber);
    }
    public static boolean isPrime(int N)    
    {
        if (N < 2)
        {
            return false;
        }
        for (int i = 2; i * i <= N; i++)
        {
            if (N % i == 0)
            {
                return false;
            }
        }
        return true;
    }
}