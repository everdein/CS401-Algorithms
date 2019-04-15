// public abstract class A
// {

// }

public interface A
{
    // Everything is by public by default
    int x = 10; // Static by default
    void op1();
    int op2();
    static void op4()
    {

    }
    default void op3()
    {
        System.out.println("A");
    }
}