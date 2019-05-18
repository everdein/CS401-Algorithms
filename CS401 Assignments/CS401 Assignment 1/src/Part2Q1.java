// Matthew Clark
// CS401 Algorithms - Assignment 1 Part 2

// 1. Write a method in Java that returns the total number of trailing zeroes for all integers from 1
// to its parameter n; given 5, it returns 0 + 1 + 0 + 2 + 0 = 3. The trailing zeroes of an
// integer a are the zeroes following the last 1 in a's binary representation (ex: 0100 ->2; 0101 ->0).
// Using big-O notation in terms of its parameter n and provide the time complexity of your algorithm.

// Algorithm Analysis: O(nlogn) Worst Case

// Create class
public class Part2Q1
{
    // Main Method
    public static void main(String[] args)
    {
        // Declaration of n variable.
        int n = 10;
        // Prints total number of trailing zeroes from 1 to n.
        System.out.println(Count(n));

//        // Trailing zeroes for one integer.
//        int number = 10;
//        System.out.println(trailingZeroes(number));
    }

    // Counts trialing zeroes for every number from 1 to n.
    public static int Count(int n)
    {
        // Int Variable
        int count = 0;
        // For loop that handles 1 to n strings.
        for(int i = 1; i <= n; i++)
        {
            // Convert integer to binary string.
            String binary = Integer.toBinaryString(i);
            // For loop that handles iterating through binary string backwards.
            for(int j = binary.length() - 1; j >= 0; j--)
            {
                // If character at index is zero count plus plus.
                if(binary.charAt(j) == '0')
                {
                    // Count plus plus.
                    count++;
                }
                else
                {
                    break;
                }
            }
        }
        // Return number of zeroes.
        return count;
    }

//    // Counts trialing zeroes for one integer.
//    public static int trailingZeroes(int number)
//    {
//        if (number == 0)
//        {
//            return 0;
//        }
//        int count = 0;
//        while(number % 10 == 0)
//        {
//            count++;
//            number /= 10;
//        }
//        return count;
//    }
}