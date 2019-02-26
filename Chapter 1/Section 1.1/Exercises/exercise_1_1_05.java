// Write a code fragment that prints true if the double variables 
// x and y are both strictly between 0 and 1 and false otherwise.

class exercise_1_1_05
{
    public static void main(String[] args)
    {
        double x = 0.0;
        double y = 1.0;
        boolean strict = check(x,y);
        System.out.println(strict);
    }
    public static boolean check(double x, double y)
    {
        if(x<0.0 || x>1.0 && y<0.0 || y>1.0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}