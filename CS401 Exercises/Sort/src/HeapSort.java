public class HeapSort
{
    // Heap sort.
    public static void heapSort(Comparable[] a)
    {
        int n = a.length;
        for (int i = n / 2 - 1; i >= 0; i--)
        {
            heapTime(a, n, i);
        }
        for (int i = n - 1; i >= 0; i--)
        {
            Comparable temp = a[0];
            a[0] = a[i];
            a[i] = temp;

            heapTime(a, i, 0);
        }
    }
    // Heap time.
    private static void heapTime(Comparable[] a, int n, int i)
    {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && less(a[largest], a[l]))
        {
            largest = l;
        }

        if (r < n && less(a[largest], a[r]))
        {
            largest = r;
        }

        if (largest != i)
        {
            Comparable swap = a[i];
            a[i] = a[largest];
            a[largest] = swap;

            heapTime(a, n, largest);
        }
    }
    // Less.
    private static boolean less(Comparable i, Comparable j)
    {
        return i.compareTo(j) < 0;
    }

}
