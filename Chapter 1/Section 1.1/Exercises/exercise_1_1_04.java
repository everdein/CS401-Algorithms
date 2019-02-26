// What (if anything) is wrong with each of the following statements?

class exercise_1_1_04
{
    // a. then is not syntax.
    // public static void main(String[] args)
    // {
    //     int a = 2;
    //     int b = 2;
    //     int c = 1;
    //     if(a>b) then c=0;
    // }

    // b. Missing parentheses 
    // public static void main(String[] args)
    // {
    //     int a = 2;
    //     int b = 2;
    //     int c = 1;
    //     if a>b
    //     {
    //         c=0;
    //     }
    // }

    // c. Nothing is wrong with this code.
    // public static void main(String[] args)
    // {
    //     int a = 3;
    //     int b = 2;
    //     int c = 1;
    //     if(a>b) c = 0;
    // }

    // d. Nothing is wrong with this code.
    public static void main(String[] args)
    {
        int a = 2;
        int b = 2;
        int c = 1;
        if(a>b) c=0; else b=0;
        System.out.println(b);
    }
}