public class BinarySearch
{
    // Non recursive binary search algorithm.
    public static int binarySearch(Comparable[] a, Comparable key, int left, int right)
    {
        while(left <= right)
        {
            int midPoint = (left + right) / 2;
            int compare = key.compareTo(a[midPoint]);
            if(compare == 0)
            {
                return midPoint;
            }
            else if(compare < 0)
            {
                right = midPoint - 1;
            }
            else
            {
                left = midPoint + 1;
            }
        }
        return -1;
    }
}
