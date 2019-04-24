// 1.1.9 Write a code gragment that puts the binary representation of a positive integer n into a String s.

class exercise_1_1_09
{
    public static void main(String[] args)
    {
        int n = 10;
        String s = "";
        for(int k = n; k > 0; k /= 2)
        {
            s = (k % 2) + s;
        }
        System.out.println(s);
    }
}