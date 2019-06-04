/**
//                            //
////    Logic For Buttons   ////
//                            //
**/

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller
{

    // GUI objects - components, buttons, etc.
    private JButton startBtn;
    private JButton unsortedBtn;
    private JButton sortedBtn;
    private static JLabel timeLabel;
    private JComboBox comboBox1;
    private static JTextArea welcomeTA;
    private JTextField textField1;
    private JLabel sizeLabel;
    private JLabel algLabel;
    private JLabel sortLabel;
    private int size;
    private boolean sorted;
    private int alg;

    // Flags determine flow of GUI and guide user to fill required fields.
    private boolean algFlag = false;
    private boolean sortFlag = false;
    private boolean sizeFlag = false;

    private Model model = new Model(comboBox1,  startBtn,  welcomeTA,  textField1,  unsortedBtn,  sortedBtn,  sizeLabel,
                                    algLabel,  sortLabel,  size,  sorted,  alg, timeLabel );

    public Controller(JButton startBtn, JTextArea welcomeTA, JComboBox comboBox1, JTextField textField1,
                      JButton unsortedBtn, JButton sortedBtn, JLabel sortLabel, JLabel sizeLabel, JLabel algLabel,
                      JLabel timeLabel)
    {
        this.startBtn = startBtn;
        this.unsortedBtn = unsortedBtn;
        this.sortedBtn = sortedBtn;
        this.comboBox1 = comboBox1;
        this.welcomeTA = welcomeTA;
        this.textField1 = textField1;
        this.sizeLabel = sizeLabel;
        this.algLabel = algLabel;
        this.sortLabel = sortLabel;
        this.timeLabel = timeLabel;
        initListeners();
    }

    // Sets time.
    public static void setTime(double time)
    {
        timeLabel.setText("Time: " + time);
        welcomeTA.setText("It took " + time + " seconds to sort your data set.");
    }

    // Initializes all listeners.
    public void initListeners()
    {
        startBtn.addActionListener(new StartBtnListener());
        comboBox1.addActionListener(new ComboBoxListener());
        textField1.addActionListener(new TextFieldListener());
        unsortedBtn.addActionListener(new UnsortedBtnListener());
        sortedBtn.addActionListener(new SortedBtnListener());
    }

    // Sorted data set button.
    private class SortedBtnListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            sorted = true;
            sortLabel.setText("Sorted/Unsorted: Sorted");
            sortFlag = true;
        }
    }

    // Unsorted data set button.
    private class UnsortedBtnListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            sorted = false;
            sortLabel.setText("Sorted/Unsorted: Unsorted");
            sortFlag = true;
        }
    }

    // Text box for entering desired size of data set.
    private class TextFieldListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String s = textField1.getText();
            welcomeTA.append("n = " + s + "\n");
            try
            {
                size = Integer.parseInt(s);
                if(size > 500000)
                {
                    size = 500000;
                    s = "500000";
                    System.out.println("got here");
                }
                sizeLabel.setText("Size = " + s);
                sizeFlag = true;
                //model.setSize(size);
            }
            catch (NumberFormatException ex)
            {
                welcomeTA.append("I didn't understand that number. Please try again.\n");
                sizeFlag = false;
            }
        }
    }

    // The run button checks all data fields are filled. If not, the user is directed to the appropriate prompt.
    private class StartBtnListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(!algFlag)
            {
                promptAlg();
            }
            else if (!sizeFlag)
            {
                promptSize();
            }
            else if (!sortFlag)
            {
                promptSort();
            }
            else
            {
                welcomeTA.setText("Running...");
                model.runSort(size, sorted, alg, welcomeTA, timeLabel);
            }
        }
    }

    // Sets chosen algorithm from combo box.
    private class ComboBoxListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            alg = comboBox1.getSelectedIndex() + 1;
            switch (alg)
            {
                case 1:
                    System.out.println("You chose bubble sort."); // Testing
                    welcomeTA.append("You chose bubble sort.\n");
                    algLabel.setText("Algorithm: Bubble Sort");
                    alg = 1;
                    break;
                case 2:
                    System.out.println("You chose heap sort.");
                    welcomeTA.append("You chose heap sort.\n");
                    algLabel.setText("Algorithm: Heap Sort");
                    alg = 2;
                    break;
                case 3:
                    System.out.println("You chose insertion sort.");
                    welcomeTA.append("You chose insertion sort.\n");
                    algLabel.setText("Algorithm: Insertion Sort");
                    alg = 3;
                    break;
                case 4:
                    System.out.println("You chose merge sort.");
                    welcomeTA.append("You chose merge sort.\n");
                    algLabel.setText("Algorithm: Merge Sort");
                    alg = 4;
                    break;
                case 5:
                    System.out.println("You chose selection sort.");
                    welcomeTA.append("You chose selection sort.\n");
                    algLabel.setText("Algorithm: Selection Sort");
                    alg = 5;
                    break;

                case 6:
                    System.out.println("You chose shell sort.");
                    welcomeTA.append("You chose shell sort.\n");
                    algLabel.setText("Algorithm: Shell Sort");
                    alg = 6;
                    break;
                case 7:
                    System.out.println("You chose quick sort.");
                    welcomeTA.append("You chose quick sort.\n");
                    algLabel.setText("Algorithm: Quick Sort");
                    alg = 7;
                    break;
                default:
                    System.out.println("Error: Could not compute.\n");
                    break;
            }
            algFlag = true;
        }

    }

    // Prompts user to select an algorithm from combo box.
    public void promptAlg()
    {
        this.welcomeTA.setText("n = " + size + "\nPlease choose which sorting algorithm you'd like to use on the data" +
                "from the dropdown box above.\n");
    }

    // Prompts user to enter size of data set.
    public void promptSize()
    {
        this.welcomeTA.setText("What size data set would you like?\nPlease enter a number between 0 and 10000 \n" +
                "in the text box below and then press Enter.\n");
    }

    // Prompts user to select sorted or unsorted data set.
    public void promptSort()
    {
        this.welcomeTA.setText("Please choose Sorted or Unsorted data.\n");
    }
}
