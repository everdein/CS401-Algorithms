public class Main
{
    public static void main(String[] args)
    {
        // Hello World!
        System.out.println("Hello World!");

        // Creates MainFrameController object.
        MainFrameController mainFrameController = new MainFrameController();

        // Displays window.
        mainFrameController.showMainFrameWindow();

        // Begins first prompt to navigate user.
        mainFrameController.promptSize();
    }
}