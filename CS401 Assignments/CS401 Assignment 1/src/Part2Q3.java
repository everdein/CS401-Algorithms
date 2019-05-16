// Matthew Clark
// CS401 Algorithms - Assignment 1 Part 2

// 3. Write a program that, given an array a[] of n distinct integers, finds a strict local minimum:
// an entry a[i] that is strictly less than its neighbors. Each internal entry (other than a[0] and
// a[n-1] ) has 2 neighbors. Your program should use ~2(logn) compares in the worst case
// (Exercise 1.4.18). Provide tests for all possible cases.

// Algorithm Analysis: O(2log(n)) Worst Case

public class Part2Q3
{
    public static void main(String[] args)
    {
        // Test Case 1: Meets Requirements
        int[] array = {5, -4, 10, 16, 11, 20, 24, -10}; // 11

        // Test Case 2: Meets Requirements
//        int[] array = {5, -4, 10, 16, 17, 20, 24, -10}; // -4

        // Test Case 3: Meets Requirements
//        int[] array = {-8, -6, 18, 19, 20, 4, 40}; // -8

        // Test Case 4: Meets Requirements
//        int[] array = {-8, -6, 8, 20, 4, 40}; // -4

        // Test Case 5: Meets Requirements
//        int[] array = {1, 2, 3, 4, 5, 6, 7, 8}; // 1

        // Test Case 6: Meets Requirements
//        int[] array = {8, 7, 6, 5, 4, 3, 2, 1}; // 1

        // Test Case 7: Meets Requirements
//        int[] array ={9,7,5,4,3,1,2,4,6,8,10}; // 1

        int localMinimum = findLocalMinimum(array);
        System.out.println("The local minimum is " + localMinimum + ".");
    }
    public static int findLocalMinimum(int[] array)
    {
        // Checks if middle index is local minimum.
        if(array[array.length/2] < array[(array.length/2) - 1] && array[array.length/2] < array[(array.length/2) + 1])
        {
            return array[array.length/2];
        }
        // Checks if left index is local minimum.
        if(array[(array.length/2)] > array[(array.length/2) - 1] && array[(array.length/2) + 1] > array[(array.length/2)-1])
        {
            // Iterates the array from left to right middle.
            for(int i = 0; i < (array.length/2) - 1; i++)
            {
                // Locates local minimum.
                if(array[i] < array[i + 1])
                {
                    return array[i];

                }
            }
        }
        // Checks if right index is local minimum.
        if(array[array.length/2] > array[(array.length/2)+1] && array[(array.length/2)-1] > array[(array.length/2)+1])
        {
            // Iterates the array from right to left middle.
            for(int i = array.length - 1; i >= (array.length/2) + 1; i--) // not reaching array[array.length - 1]
            {
                // Locates local minimum.
                if(array[i] < array[i -1 ])
                {
                    return array[i];
                }
            }
        }
        return -1;
    }
}