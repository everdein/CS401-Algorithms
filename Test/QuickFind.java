public class Sort
{
    public static void insertionSort(comparable[] a)
    {
        for(int i = 0; i < a.length - 1; i++)
        {
            for(int j = 1; j < a.length - 1; i++)
            {
                if(a[i] > a[j])
                {
                    a[j] = a[i];
                    a[i] = a[j];
                }
            }
        }
    }
    public static bubbleSort(comparable[] a)
    {
        for(int i = a.length - 1; i > 0; i --)
        {
            for(int j = a.length - 2; j > 0; j--)
            {
                if(a[i] < a[j])
                {
                    a[i-1] = a[j];
                    a[i] = a[j];
                }
            }
        }
    }
}