public class BinarySearchRecursion
{
    // Recursive binary search algorithm.
    public static int binarySearch(Comparable[] a, Comparable key, int left, int right)
    {
        if(left <= right)
        {
            int midPoint = (left + right) / 2;
            int compare = key.compareTo(a[midPoint]);
            if(compare == 0)
            {
                return midPoint;
            }
            else if(compare < 0)
            {
                binarySearch(a, key, left, midPoint - 1);
            }
            else
            {
                binarySearch(a, key, midPoint + 1, right);
            }
        }
        return -1;
    }
}
