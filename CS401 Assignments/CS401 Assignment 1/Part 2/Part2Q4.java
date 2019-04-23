// Matthew Clark
// CS401 Algorithms - Assignment 1 Part 2

// 4. a. Design and implement an algorithm in Java that performs substring pattern matching.
// Your algorithm needs to determine if the text contains the given pattern and returns
// position of the pattern.
// Input: A text string t and a pattern string p.
// Output: Does t contain the pattern p as a substring, and if so where?

// b. What is the complexity of your algorithm. Please show your work.
// O(n^2) runtime.

// Declares class.
class Part2Q4 
{
    // Main method.
    public static void main (String[] args)
    {
        // String
        String t = "matthew";
        // Substring
        String p = "thew";
        //Calls compareFunction
        compareFunction(t, p);
    }
    // myIndexOf method which checks for a substring within a string
    // and returns the index it is found at, or returns -1 if not found.
    public static int myIndexOf(char[] string, char[] subString) 
    {
        // Declares int for string length.
        int stringLength = string.length;
        // Decalres int for sub string length.
        int stringSubLength = subString.length;
        // Declares count.
        int count = 0;
        // Returns -1 when sub string is longer than string.
        if (stringSubLength > stringLength) 
        {
            // Returns -1.
            return -1;
        }
        // Iterattes the size of the string minus the sub string.
        for (int i = 0; i < stringLength - stringSubLength + 1; i++) 
        {
            // Iterates the length of the sub string.
            for (int j = 0; j < stringSubLength; j++) 
            {
                // Compares.
                if (string[j + i] == subString[j]) 
                {
                    // Increases count.
                    count++;
                    // Checks if count is equal to sub string length.
                    if (count == stringSubLength) 
                    {
                        // Returns index.
                        return i;
                    }
                } 
                // Sets count to 0.
                else 
                {
                    count = 0;
                    break;
                }
            }
        }
        // Returns -1 if sub string isn't found.
        return -1;
    }
    // Compares indexOf and myIndexOf.
    public static boolean compareFunction(String t, String p)
    {
        // Declares indexOf int.
        int indexOf = t.indexOf(p);
        // Declares myIndexOf int and passes strings into character array.
        int myIndexOf = myIndexOf(t.toCharArray(), p.toCharArray());
        // Declares boolean and compares indexOf and myIndexOf.
        boolean bool = (indexOf == myIndexOf);
        // Print statement.
        System.out.println(bool + " for " + t + " and " + p + " indexOf: " + indexOf + " myIndexOf: " + myIndexOf);
        // Returns boolean.
        return bool;
    }
}