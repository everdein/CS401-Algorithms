/* 1.1.29 Equal keys. Add to BinarySearch a static method rank() that takes a key and
a sorted array of int values (some of which may be equal) as arguments and returns the
number of elements that are smaller than the key and a similar method count() that
returns the number of elements equal to the key. Note : If i and j are the values returned
by rank(key, a) and count(key, a) respectively, then a[i..i+j-1] are the values in
the array that are equal to key. */

import java.util.Arrays;

class exercise_1_1_29
{
    public static void main(String[] args) 
    {
        int[] whitelist = {1, 2, 3, 4, 5, 6, 7};
		int[] input = {1, 4 , 5, 9, 10};

        // Read whitelist
        // int[] whitelist = inw.readAllInts();
        Arrays.sort(whitelist);
        System.out.printf("%11s:", "Rank");
        for(int i = 0; i < whitelist.length; i++) 
        {
            System.out.printf("%4d", i);
        }
        System.out.printf("\n%11s:", "Whitelist");
        for(int i = 0; i < whitelist.length; i++) 
        {
            System.out.printf("%4d", whitelist[i]);
        }
        System.out.println();

        // Print rank and count for each input
        System.out.printf("\n%5s %5s %5s  %s\n", "Input", "Rank", "Count", "Values");
        for(int key : input) 
        {
            int r = rank(key, whitelist);
            int c = count(key, whitelist);
            System.out.printf("%4d: %5d %5d  %s\n",
                    key, r, c, Arrays.toString(Arrays.copyOfRange(whitelist, r, r + c)));
        }
    }    
    
    public static int rank(int key, int[] a) 
    {
        return rank(key, a, 0, a.length - 1);
    }
    // returns the number of elements that are smaller than the key
    public static int rank(int key, int[] a, int lo, int hi) 
    {
        if(lo > hi) return lo;
        int mid = lo + (hi - lo) / 2;
        if(key < a[mid]) 
        {
            return rank(key, a, lo, mid - 1);
        }
        else if(key > a[mid]) 
        {
            return rank(key, a, mid + 1, hi);
        }
        else 
        {
            while(mid >= 0 && a[mid] == key) 
            {
                mid--;
            }
            return mid + 1;
        }
    }

    // returns the number of elements equal to the key
    public static int count(int key, int[] a) 
    {
        return rank(key + 1, a, 0, a.length - 1) - rank(key, a, 0, a.length - 1);
    }
}