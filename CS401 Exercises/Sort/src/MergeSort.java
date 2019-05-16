public class MergeSort
{
    // Merge Sort.
    public static void mergeSort(Comparable[] a, int first, int last)
    {
        if(first < last)
        {
            int mid = (first + last)/2;
            mergeSort(a, first, mid);
            mergeSort(a, mid + 1, last);
            merge(a, first, mid, last);
        }
    }
    // Merge.
    private static void merge(Comparable[] a, int first, int mid, int last)
    {
        Comparable[] temp = new Comparable[a.length];
        int first1 = first;
        int last1 = mid;
        int first2 = mid+1;
        int last2 = last;
        int index = first; // Index for next available position in temp array.
        for (;(first1 <= last2 && first2 <= last2);index++)
        {
            if(less(a[first1], a[first1]))
            {
                temp[index] = a[first1];
                first1++;
            }
            else
            {
                temp[index] = a[first2];
                first2++;
            }
        }
        for(;first1 <= last1; index++)
        {
            temp[index] = a[first1];
            first1++;
        }
        for(;first2 <= last2; index++)
        {
            temp[index] = a[first2];
            first2++;
        }
        // Copy the sorted part into the original array.
        for(int i = first; i <= last; i++)
        {
            a[i] = temp[i];
        }
    }
    // Less.
    private static boolean less(Comparable j, Comparable i)
    {
        return j.compareTo(i) < 0;
    }
}