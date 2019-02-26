/* 1.1.11 Write a code fragment that prints the contents of a two-dimensional boolean array, 
using * to represent true and a space to represent false. Includ row and column numbers. */

class exercise_1_1_11
{
    public static void main(String[] args)
    {
        boolean[][] doubleBooleanArray = {{true, false, true, false}, {false, true, false, true}};
        printArray(doubleBooleanArray);
    }    
    public static void printArray(boolean[][] doubleBooleanArray)
    {
        int rowsArray = doubleBooleanArray.length;
        int columnsArray = doubleBooleanArray[0].length;
        
        System.out.print("Columns: ");
        for(int column = 1; column <= doubleBooleanArray[0].length; column++)
        {
            System.out.print(column);
        }
        System.out.println();
        
        int row = 1;
        for(int i = 0; i < rowsArray; i++)
        {
            System.out.print("Rows " + row + ":  ");
            for(int j = 0; j < columnsArray; j++)
            {
                if(doubleBooleanArray[i][j])
                {
                    System.out.print("*");
                }
                else
                {
                    System.out.print("-");
                }
            }
            row++;
            System.out.println();
        }
    }
}