/* 1.1.23 Add to the BinarySearch test client the ability to respond to a second argument:
+ to print numbers from standard input that are not in the whitelist, - to print
numbers that are in the whitelist. */

import java.util.ArrayList;
import java.util.Arrays;

// BufferReader stores file data as String.
class exercise_1_1_23
{
	public static void main(String[] args) 
    {
		int[] whitelist = {1, 2, 3, 4, 5, 6, 7};
		int[] numbers = {1, 4 , 5, 9, 10};

		binarySearch(whitelist, numbers, '+');
		binarySearch(whitelist, numbers, '-');
	}
	
	private static void binarySearch(int[] whitelist, int[] numbers, char operation) 
    {
		if(operation == '+') 
        {
			System.out.println("Numbers NOT in whitelist:");
		} 
        else 
        {
			System.out.println("Numbers IN whitelist:");
		}
		
		int count = 0;
		for(int i = 0; i < numbers.length; i++) 
        {	
			int index = rank(numbers[i], whitelist, 0, whitelist.length-1);
			if(operation == '+' && index == -1) 
            {
				if(count != 0) 
                {
					System.out.print(", ");
				}
				System.out.print(numbers[i]);
				count++;
			} 
            else if(operation == '-' && index != -1) 
            {
				if(count != 0) 
                {
					System.out.print(", ");
				}
				System.out.print(numbers[i]);
				count++;
			}
		}
        System.out.println();
	}

	private static int rank(int key, int[] whitelist, int lo, int hi) 
    {	
		if(lo <= hi) 
        {
			int mid = lo + (hi - lo) / 2;
			if(key < whitelist[mid]) 
            {
				return rank(key, whitelist, lo, mid-1);
			} 
            else if(key > whitelist[mid]) 
            {
				return rank(key, whitelist, mid+1, hi);
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