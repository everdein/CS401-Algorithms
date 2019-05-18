// Matthew Clark
// CS401 Algorithms - Assignment 1 Part 2

// 2. Write a program that, given two sorted arrays of n int values, prints all elements that appear
// in both arrays, in sorted order. The running time of your program should be proportional to
// n in the worst case (Exercise 1.4.12)

// Algorithm Analysis: O(n) Worst Case

// Create class.
public class Part2Q2
{
    // Main method.
    public static void main(String[] args)
    {
        // Test Case 1: Meets requirements
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {1, 2, 6, 7, 8};

        // Test Case 2: Meets requirements
//        int[] array1 = {1,2,3,4,5,6,7,8,9};
//        int[] array2 = {6,7,8,9,10,11,12,13};

        // Test Case 3: Meets requirements
//        int[] array1 = {0, 1, 1, 1, 1, 1, 3, 3, 3, 3, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6};
//        int[] array2 = {0, 2, 2, 3, 4, 4, 6, 6, 6};

        // Call compare method.
        compare(array1, array2);
    }

    // Compares two arrays and prints matching values with no duplicates.
    public static void compare(int[] array1, int[] array2)
    {
        // Tracks array indices.
        int array1Index = 0;
        int array2Index = 0;

        // Compares array indices while length of arrays haven't been reached.
        while(array1Index != array1.length && array2Index != array2.length)
        {
            // Checks if array 1 index is less than array 2 index.
            if(array1[array1Index] < array2[array2Index])
            {
                // Ensures array 1 index doesn't exceed array 1 length.
                if(array1Index < array1.length)
                {
                    // Increment array 1 index.
                    array1Index++;
                }
            }
            // Checks if array 1 index is greater than array 2 index.
            else if(array1[array1Index] > array2[array2Index])
            {
                // Ensures array 2 index doesn't exceed array 2 length.
                if(array2Index < array2.length)
                {
                    // Increment array 2 index.
                    array2Index++;
                }
            }
            // Prints matching value from array 1 and array 2 indices and increments both array indices.
            else
            {
                // Prints matching compared indices.
                System.out.println(array1[array1Index]);
                // Ensures array 1 index doesn't exceed array 1 length.
                if(array1Index < array1.length)
                {
                    // Increment array 1 index.
                    array1Index++;
                    // Skips duplicate values within array 1.
                    while(array1Index < array1.length && array1[array1Index - 1] == array1[array1Index])
                    {
                        // Increment array 1 index.
                        array1Index++;
                    }
                }

                // Ensures array 2 index doesn't exceed array 2 length.
                if(array2Index < array2.length)
                {
                    // Increment array 2 index.
                    array2Index++;
                    // Skips duplicate values within array 1.
                    while(array2Index < array2.length && array2[array2Index - 1] == array2[array2Index])
                    {
                        // Increment array 2 index.
                        array2Index++;
                    }
                }
            }
        }
    }
}