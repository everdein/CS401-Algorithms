import edu.princeton.cs.algs4.StopwatchCPU;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class MainFrameController
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

    private int size;
    private boolean sorted;
    private int alg;
    private double startTime;
    private double endTime;

    // Flags determine flow of GUI and guide user to fill required fields.
    private boolean algFlag = false;
    private boolean sortFlag = false;
    private boolean sizeFlag = false;

    // Initializes components and listeners.
    public MainFrameController()
    {
        initComponents();
        initListeners();
    }

    public void showMainFrameWindow()
    {
        mainFrame.setVisible(true);
    }

    // Initializes components.
    public void initComponents()
    {
        mainFrame = new MainFrame();

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

    // Runs program once all requirements are fulfilled.
    public void runSort()
    {
        Comparable[] a = new Comparable[size];
        StopwatchCPU stopwatchCPU = new StopwatchCPU();

        // Constructs the file name.
        String filename;
        int element;
        if(sorted)
        {
            filename = "sorted";
        }
        else
        {
            filename = "unsorted";
        }
        filename += size + ".txt";

        // Creates elements and adds elements to array.
        if (sorted)
        {
            for (int i = 0; i < size; i++)
            {
                a[i] = i+1;
            }
        }
        else
        {
            Random rand = new Random();
            for (int i = 0; i < size; i++)
            {
                element = rand.nextInt(size * 10) + 1;
                a[i] = element;
            }
        }

        // Times the sorting of the data.
        switch (alg)
        {
            case 1:
                startTime = stopwatchCPU.elapsedTime();
                SelectionSort.selectionSort(a);
                endTime = stopwatchCPU.elapsedTime();
                break;
            case 2:
                startTime = stopwatchCPU.elapsedTime();
                InsertionSort.insertionSort(a);
                endTime = stopwatchCPU.elapsedTime();
                break;
            case 3:
                startTime = stopwatchCPU.elapsedTime();
                ShellSort.shellSort(a);
                endTime = stopwatchCPU.elapsedTime();
                break;
            case 4:
                startTime = stopwatchCPU.elapsedTime();
                BubbleSort.bubbleSort(a);
                endTime = stopwatchCPU.elapsedTime();
                break;
            case 5:
                startTime = stopwatchCPU.elapsedTime();
                MergeSort.mergeSort(a, 0, a.length-1);
                endTime = stopwatchCPU.elapsedTime();
                break;
            case 6:
                startTime = stopwatchCPU.elapsedTime();
                QuickSort.quickSort(a, 0, a.length-1);
                endTime = stopwatchCPU.elapsedTime();
                break;
            case 7:
                startTime = stopwatchCPU.elapsedTime();
                HeapSort.heapSort(a);
                endTime = stopwatchCPU.elapsedTime();
                break;
            default:
                System.out.println("Error: Could not compute.");
                break;
        }

        // Determines elapsed time from sorting.
        endTime -= startTime;
        timeLabel.setText("Time: " + endTime);
        welcomeTA.setText("It took " + endTime + " seconds to sort your data set.");

        // Generates sorted data set file.
        File file = new File (filename);
        try
        {
            PrintWriter writer = new PrintWriter(file, "UTF-8");
            for (Comparable i:a)
            {
                writer.println(i);
            }
        }
        catch (IOException err)
        {
            System.out.println(err.getMessage());
        }

        // Prints sorted data to console.
        System.out.println("\nSorted Array: ");
        for(int i = 0; i < a.length; i++)
        {
            System.out.println("i: " + i + "\telement: " + a[i]);
        }

    }

    // Prompts user to select an algorithm from combo box.
    public void promptAlg()
    {
        welcomeTA.setText("n = " + size + "\nPlease choose which sorting algorithm you'd like to use on the data" +
                "from the dropdown box above.\n");
    }

    // Prompts user to enter size of data set.
    public void promptSize()
    {
        welcomeTA.setText("What size data set would you like?\nPlease enter a number between 0 and 10000 \n" +
                          "in the text box below and then press Enter.\n");
    }

    // Prompts user to select sorted or unsorted data set.
    public void promptSort()
    {
        welcomeTA.setText("Please choose Sorted or Unsorted data.\n");
    }

    // Initializes all listeners.
    private void initListeners()
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
            }
            catch (NumberFormatException ex)
            {
                welcomeTA.append("I didn't understand that number. Please try again.\n");
                sizeFlag = false;
            }
        }
    }

    // The run button checks all data fields are filled. If not, the user is
    // directed to the appropriate prompt.
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
                runSort();
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
}