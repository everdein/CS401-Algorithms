public class ShellSort
{
    // Shell sort.
    public static void shellSort(Comparable[] a)
    {
        int n = a.length;

        for(int gap = n/2; gap > 0; gap /= 2)
        {
            for (int i = gap; i < n; i += 1)
            {
                Comparable temp = a[i];
                int j;
                for(j = i; j >= gap && less(temp, a[j - gap]); j -= gap)
                {
                    a[j] = a[j - gap];
                }
                a[j] = temp;
            }
        }
    }
    // Less.
    private static boolean less(Comparable i, Comparable j)
    {
        return i.compareTo(j) < 0;
    }
}
