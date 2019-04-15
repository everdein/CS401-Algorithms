// Matthew Clark
// CS401 Algorithms - Assignment 1 Part 2

// 1. Write a method in Java that returns the total number of trailing zeroes for all integers from 1
// to its parameter n; given 5, it returns 0 + 1 + 0 + 2 + 0 = 3. The trailing zeroes of an
// integer a are the zeroes following the last 1 in a's binary representation (ex: 0100 ->2; 0101-
// >0). Using big-O notation in terms of its parameter n and provide the time complexity of your
// algorithm.

// Create class
public class Part2Q1
{
    // Main Method
    public static void main(String[] args)
    {
        // Int Variable
        int n = 10;
        // Print Statment
        System.out.println(Count(n));
    }
    // Count Method
    public static int Count(int n)
    {
        // Int Variable
        int count = 0;
        // For loop that handles 1 to n strings.
        for(int i = 1; i<= n; i++)
        {
            // Convert integer to binary string.
            String binary = Integer.toBinaryString(i);
            // For loop that handles iterating through binary string backwards.
            for(int j = binary.length() - 1; j>= 0; j--)
            {
                // If character at index is zero count plus plus.
                if(binary.charAt(j) == '0')
                {
                    // Count plus plus.
                    count++;
                }
                // Else
                else
                {
                    // Break
                    break;
                }
            }
        }
        // Return number of zeroes.
        return count;
    }
}