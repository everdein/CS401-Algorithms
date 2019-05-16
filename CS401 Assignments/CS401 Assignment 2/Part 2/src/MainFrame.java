import javax.swing.*;

public class MainFrame  extends JFrame
{

    // Display box height and width.
    public static final int HEIGHT = 800;
    public static final int WIDTH = 800;

    private JComboBox comboBox1;
    private JButton welcomeBtn;
    private JTextArea welcomeTA;
    private JPanel mainPanel;
    private JTextField textField1;
    private JButton unsortedBtn;
    private JButton sortedBtn;
    private JLabel timeLabel;
    private JLabel sizeLabel;
    private JLabel algLabel;
    private JLabel sortLabel;

    public MainFrame()
    {
        setSize(WIDTH, HEIGHT);
        setContentPane(mainPanel);
        setLocationRelativeTo(null);
    }

    public JLabel getSortLabel()
    {
        return sortLabel;
    }

    public JLabel getAlgLabel()
    {
        return algLabel;
    }

    public JLabel getTimeLabel()
    {
        return timeLabel;
    }

    public JLabel getSizeLabel()
    {
        return sizeLabel;
    }

    public JButton getSortedBtn()
    {
        return sortedBtn;
    }

    public JButton getUnsortedBtn()
    {
        return unsortedBtn;
    }

    public JComboBox getComboBox1()
    {
        return comboBox1;
    }

    public JButton getWelcomeBtn()
    {
        return welcomeBtn;
    }

    public JTextArea getWelcomeTA()
    {
        return welcomeTA;
    }

    public JTextField getTextField1()
    {
        return textField1;
    }

}
