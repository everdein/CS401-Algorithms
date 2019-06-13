public class BubbleSort
{
    // Bubble sort.
    public static void bubbleSort(Comparable[] a)
    {
        System.out.println("Bubble Sort");
        for(int i = 0; i < a.length; i++)
        {
            for(int j = a.length - 1; j > 0; j--)
            {
                if(less(a[j], a[j - 1]))
                {
                    swap(a, j, j - 1);
                }
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


























































//public class BubbleSort
//{
//    // Bubble Sort
//    public static void bubbleSort(Comparable[] a)
//    {
//        for(int i = 0; i < a.length; i++)
//        {
//            for(int j = a.length-1; j > i; j--)
//            {
//                if(less(a[j], a[j - 1]))
//                {
//                    swap(a, j, j - 1);
//                }
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