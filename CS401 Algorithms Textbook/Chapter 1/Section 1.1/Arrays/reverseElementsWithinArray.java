class reverseElementsWithinArray 
{
    public static void main(String[] args)
    {
        int a[] = {1, 2, 3, 4, 5, 6};
        int N = a.length;
        for (int i = 0; i < N/2; i++)
        {
            int temp = a[i];
            a[i] = a[N - 1 - i];
            a[N - i -1] = temp;
        }
        for (int j = 0; j < a.length; j ++)
        {
            System.out.println(a[j]);
        }
    }
}