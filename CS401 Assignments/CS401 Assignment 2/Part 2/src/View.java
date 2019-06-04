/**
//                                  //
////    Contains GUI Components   ////
//                                  //
**/

import javax.swing.*;

public class View
{
    // GUI objects - components, buttons, etc.
    private MainFrame mainFrame;
    private JComboBox comboBox1;
    private JButton startBtn;
    private JTextArea welcomeTA;
    private JTextField textField1;
    private JButton unsortedBtn;
    private JButton sortedBtn;
    private JLabel sizeLabel;
    private JLabel algLabel;
    private JLabel sortLabel;
    private JLabel timeLabel;

    // Initializes components and listeners.
    public View()
    {
        initComponents();
        Controller controller = new Controller(startBtn, welcomeTA, comboBox1, textField1, unsortedBtn, sortedBtn,
                                               sortLabel, sizeLabel, algLabel, timeLabel);
    }

    // Displays window.
    public void showMainFrameWindow()
    {
        mainFrame.setVisible(true);
    }

    // Initializes components.
    public void initComponents()
    {
        // Creates mainframe object.
        mainFrame = new MainFrame();

        // Gets variables.
        startBtn = mainFrame.getWelcomeBtn();
        welcomeTA = mainFrame.getWelcomeTA();
        comboBox1 = mainFrame.getComboBox1();
        textField1 = mainFrame.getTextField1();
        unsortedBtn = mainFrame.getUnsortedBtn();
        sortedBtn = mainFrame.getSortedBtn();
        sortLabel = mainFrame.getSortLabel();
        sizeLabel = mainFrame.getSizeLabel();
        algLabel = mainFrame.getAlgLabel();
        timeLabel = mainFrame.getTimeLabel();

        // Adds sorting algorithms to the combo box (drop down menu).
        comboBox1.addItem("Bubble Sort");
        comboBox1.addItem("Heap Sort");
        comboBox1.addItem("Insertion Sort");
        comboBox1.addItem("Merge Sort");
        comboBox1.addItem("Selection Sort");
        comboBox1.addItem("Shell Sort");
        comboBox1.addItem("Quick Sort");
    }
}
