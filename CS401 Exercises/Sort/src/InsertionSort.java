public class InsertionSort
{
    // Insertion sort.
    public static void insertionSort(Comparable[] a)
    {
        for(int i = 1; i < a.length; i++)
        {
            for(int j = i; j > 0 && less(a[j], a[j - 1]); j--)
            {
                swap(a, j, j - 1);
            }
        }
    }
    // Swap.
    private static void swap(Comparable[] a, int i, int j)
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






















































//public class InsertionSort
//{
//    // Insertion Sort
//    public static void insertionSort(Comparable[] a)
//    {
//        for(int i = 1; i < a.length; i++)
//        {
//            for(int j = i; j > 0 && less(a[j], a[j - 1]); j--)
//            {
//                swap(a, j, j - 1);
//            }
//        }
//    }
//    // Swap
//    public static void swap(Comparable[] a, int i, int j)
//    {
//        Comparable temp = a[j];
//        a[j] = a[i];
//        a[i] = temp;
//    }
//    // Less
//    private static boolean less(Comparable j, Comparable i)
//    {
//        return j.compareTo(i) < 0;
//    }
//}