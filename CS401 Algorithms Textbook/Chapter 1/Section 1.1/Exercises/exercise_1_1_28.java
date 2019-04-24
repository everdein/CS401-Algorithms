/* 1.1.28 Remove duplicates. Modify the test client in BinarySearch to remove any 
duplicate keys in the whitelist after the sort. */

import java.util.Arrays;

public class exercise_1_1_28 
{
    public static void main(String[] args)
    {	
		int[] whitelist = {2, 3, 5, 6, 6, 7, 7, 8};
        int[] keys = {1, 4 , 5, 7, 9, 10};	
		Arrays.sort(whitelist);
        int[] compactWhitelist = removeDuplicates(whitelist);
        for(int i = 0; i < compactWhitelist.length; i++)
        {
            System.out.print(compactWhitelist[i]);
        }
        System.out.println();
        binarySearch(compactWhitelist, keys);
        System.out.println();
	}

    private static int[] removeDuplicates(int[] whitelist)
    {
		int[] newWhitelist = new int[whitelist.length];
		
		newWhitelist[0] = whitelist[0];
		int count = 0;
		
        for(int i = 1; i < whitelist.length; i++)
        {
            if(whitelist[i] != newWhitelist[count])
            {
				count++;
				
				newWhitelist[count] = whitelist[i];
			}
		}
		count++;
		int[] compactNewWhitelist = new int[count];
		System.arraycopy(newWhitelist, 0, compactNewWhitelist, 0, count);
		return compactNewWhitelist;
	}

    private static void binarySearch(int[] whitelist, int[] keys) 
    {
		int numbersCount = 0;	
        for(int i = 0; i < keys.length; i++) 
        {
			int index = rank(keys[i], whitelist, 0, whitelist.length-1);
            if(index == -1) 
            {
                if(numbersCount != 0) 
                {
					System.out.print(", ");
				}
				System.out.print(keys[i]);
				numbersCount++;
			}
		}
	}

    private static int rank(int key, int[] arr, int lo, int hi) 
    {
        if(lo <= hi)
        {
			int mid = lo + (hi - lo) / 2;
            if(key < arr[mid])
            {
				return rank(key, arr, lo, mid - 1);
            } 
            else if(key > arr[mid])
            {
				return rank(key, arr, mid + 1, hi);
            } 
            else 
            {
				return mid;
			}
        } 
        else
        {
			return -1;
		}
	}
}