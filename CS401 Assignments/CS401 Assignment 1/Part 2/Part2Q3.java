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

public class Part2Q3
{
    public static void main(String[] args) 
    {
        // int[] array = {5, -4, 10, 16, 11, 20, 24, -10}; // 11
        // int[] array = {5, -4, 10, 16, 17, 20, 24, -10}; // -4
        // int[] array = {-8, -6, 18, 19, 20, 4, 40}; // 8
        int[] array = {-8, -6, 18, 19, 20, 21, 40}; // -8
        // int[] array = {1, 2, 3, 4, 5, 6, 7, 8}; // 1
        // int[] array = {8, 7, 6, 5, 4, 3, 2, 1}; // 1
        findSmallest(array);
    }
    public static void findSmallest(int[] array)
    {
        // Checks if middle index is local minimum.
        if(array[array.length/2] < array[(array.length/2)-1] && array[(array.length/2)/2] < array[(array.length/2)+1])
        {
            System.out.println(array[array.length/2]);
        }
        // Checks if left index is local minimum.
        if(array[(array.length/2)] > array[(array.length/2)-1] && array[(array.length/2)+1] > array[(array.length/2)-1])
        {
            // Iterates the array from left to right middle.
            for(int i = 0; i < (array.length/2) - 1; i--)
            {
                // Locates local minimum.
                if(array[i] < array[i + 1])
                {
                    // Prints local minimum.
                    System.out.println(array[i]);
                    // Breaks if statement.
                    break;
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
                    // Prints local minimum.
                    System.out.println(array[i]);
                    // Breaks if  statement.
                    break;
                }
            }
        }
    }
}


// First Attempt
// // Create class.
// public class Part2Q3
// {
//     // Main Method
//     public static void main(String[] args) 
//     {
//         // Create integer array.
//         int[] array = {1, 2, 4, 3, 5, 6};
//         // Calls method and passes array.
//         findSmallest(array);
//     }
//     // Finds the smallest numbers with two neighbors that are greater.
//     public static void findSmallest(int[] array)
//     {
//         // For loop iterates through array.
//         for(int i = 1; i < array.length - 1; i++)
//         {
//             // Checks if the neighbors of i are greater.
//             if(array[i-1] > array[i] && array[i] < array[i+1])
//             {
//                 // Prints i.
//                 System.out.println(i);
//             }
//         }
//     }
// }