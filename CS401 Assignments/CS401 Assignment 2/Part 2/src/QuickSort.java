public class QuickSort
{
    // Quick sort.
    public static void quickSort(Comparable[] a, int first, int last)
    {
        if (first < last)
        {
            int pivotIndex = partition(a, first, last);
            quickSort(a, first, pivotIndex-1);
            quickSort(a, pivotIndex+1, last);
        }
    }
    // Partition.
    private static int partition(Comparable[] a, int first, int last)
    {
        // choose a pivot and place it into the first element of the array
        choosePivot(a, first, last);
        int pivotIndex = first;
        Comparable pivot = a[first];
        int lastS1 = pivotIndex;
        int firstUnknown = pivotIndex + 1;
        for(;firstUnknown<=last;firstUnknown++)
        {
            if(less(a[firstUnknown],pivot))
            {
                lastS1++;
                swap(a, firstUnknown, lastS1);
            }
        }
        swap(a, pivotIndex, lastS1);
        pivotIndex = lastS1;
        return pivotIndex;
    }
    // Choose pivot point.
    private static void choosePivot(Comparable[] a, int first, int last)
    {

    }
    // Swap.
    public static void swap(Comparable[] a, int i, int j)
    {
        Comparable temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }
    // Less.
    private static boolean less(Comparable i, Comparable j)
    {
        return i.compareTo(j) < 0;
    }
}
