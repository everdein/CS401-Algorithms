class averageOfArrayValues{
    public static void main(String[] args)
    {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int N = a.length;
        double sum = 0.0;
        for (int i = 0; i < N; i++)
        {
            sum += a[i];
        }
        double average = sum / N;
        System.out.println(average);
    }
}