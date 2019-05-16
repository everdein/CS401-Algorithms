public class SelectionSort
{
    // Selection sort.
    public static void selectionSort(Comparable[] a)
    {
        int temp;

        for(int i = 0; i < a.length; i++)
        {
            temp = i;
            for(int j = i + 1; j < a.length - 1; j++)
            {
                if(less(a[j], a[j - 1]))
                {
                    temp = j;
                }
            }
            swap(a, i, temp);
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


















































//public class SelectionSort
//{
//    // Selection Sort
//    public static void selectionSort(Comparable[] a)
//    {
//        int temp;
//        for(int i = 0; i < a.length; i++)
//        {
//            temp = i;
//            for(int j = i + 1; j < a.length; j++)
//            {
//                if(less(a[j], a[temp]))
//                {
//                    temp = j;
//                }
//            }
//            swap(a, i, temp);
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