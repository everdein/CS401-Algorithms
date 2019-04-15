// Matthew Clark
// CS401 Algorithms - Assignment 1 Part 2

// 3. Write a program that, given an array a[] of n distinct integers, finds a strict local minimum:
// an entry a[i] that is strictly less than its neighbors. Each internal entry (other than a[0] and
// a[n-1] ) has 2 neighbors. Your program should use ~2(logn) compares in the worst case
// (Exercise 1.4.18). Provide tests for all possible cases.

// Sample Cases:
// Array-> {5, -4, 10, 16, 11, 20, 24, -10};
// Local minimum: -4 //it can also output 11 as local minimum
// Array-> {-8, -6, 18, 8, 20, 4, 40};
// Local minimum: 8 //it can also output -8 or 4 as local minimum 

// Create class.
public class Part2Q3
{
    // Main Method
    public static void main(String[] args) 
    {
        // Create integer array.
        int[] array = {1, 2, 4, 3, 5, 6};
        // Calls method and passes array.
        findSmallest(array);
    }
    // Finds the smallest numbers with two neighbors that are greater.
    public static void findSmallest(int[] array)
    {
        // For loop iterates through array.
        for(int i = 1; i < array.length - 1; i++)
        {
            // Checks if the neighbors of i are greater.
            if(array[i-1] > array[i] && array[i] < array[i+1])
            {
                // Prints i.
                System.out.println(i);
            }
        }
    }
}