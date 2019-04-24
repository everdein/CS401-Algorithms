class copyToAnotherArray 
{
    public static void main(String[] args)
    {
        int[] a = {1, 2, 3, 4, 5};
        int N = a.length;
        double[] b = new double[N];
        for (int i = 0; i < N; i++)
        {
            b[i] = a[i];
        }
        for (int j = 0; j < b.length; j++)
        {
            System.out.println(b[j]);
        }
    }
}