class recursion
{
    public static void main(String[] args)
    {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int lo = 1;
        int hi = 10;
        int key = 11;
        int output1 = indexOf(a, key);
        indexOf(a, key, lo, hi);
        System.out.println(output1);
    }
    public static int indexOf(int[] a, int key)
    {
        return indexOf(a, key, 0, a.length - 1);
    }
    public static int indexOf(int[] a, int key, int lo, int hi)
    {
        if (lo > hi)
        {
            return -1;
        }
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid])
        {
            return indexOf(a, key, lo, mid -1);
        }
        else if (key > a[mid])
        {
            return indexOf(a, key, mid + 1, hi);
        }
        else
        {
            return mid;
        }
    }
}