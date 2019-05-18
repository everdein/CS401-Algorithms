// Matthew Clark
// CS401 Algorithms - Assignment 1 Part 2

// 4. a. Design and implement an algorithm in Java that performs substring pattern matching.
// Your algorithm needs to determine if the text contains the given pattern and returns position of the pattern.

// Input: A text string t and a pattern string p.
// Output: Does t contain the pattern p as a substring, and if so where?

// b. What is the complexity of your algorithm. Please show your work.

// Algorithm Analysis: O(n^2) Worst Case

// Create class.
class Part2Q4
{
    // Main method.
    public static void main (String[] args)
    {
        // Test Case 1: Meets Requirements
        String string = "matthew";
        String substring = "thew";

        // Test Case 2: Meets Requirements
//        String string = "this is a test";
//        String substring = "tell";

        //Calls compareFunction
        compareFunction(string, substring);
    }

    // Compares indexOf and myIndexOf.
    public static void compareFunction(String string, String substring)
    {
        // Attempts to locate the substring within the string by calling stringContainsSubstring method.
        int stringContainsSubstring = stringContainsSubstring(string.toCharArray(), substring.toCharArray());
        if(stringContainsSubstring == -1)
        {
            // Prints the substring is not contained within the string.
            System.out.println("The substring is not contained within the string.");
        }
        else
        {
            // Prints the index the substring is found within the string.
            System.out.println("The substring '" + substring + "' was found within string '" + string +
                    "' at index " + stringContainsSubstring + ".");
        }
    }

    // Checks if string contains substring and returns the index it is found at, or returns -1 if not found.
    public static int stringContainsSubstring(char[] string, char[] subString)
    {
        // Stores string length into int variable.
        int stringLength = string.length;

        // Stores substring length into int variable.
        int stringSubLength = subString.length;

        // Declares count.
        int count = 0;

        // Checks if substring is greater than string and return -1.
        if (stringSubLength > stringLength)
        {
            return -1;
        }
        // Iterates the size of the string minus the sub string.
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
                else
                {
                    // Sets count to 0 and breaks.
                    count = 0;
                    break;
                }
            }
        }
        // Returns -1 if sub string isn't found.
        return -1;
    }
}