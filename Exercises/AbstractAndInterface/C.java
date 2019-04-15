public class C implements A, D
{
    @Override
    public void op1()
    {

    }

    @Override
    public int op2()
    {
        return 0;
    }

    @Override
    public void op3()
    {
        A.super.op3();
        System.out.println("C");
    }
}