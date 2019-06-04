/**
//               //
////    Data   ////
//               //
**/

import edu.princeton.cs.algs4.StopwatchCPU;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class Model
{
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

    // Contructor sets variables.
    public Model(JComboBox comboBox1, JButton startBtn, JTextArea welcomeTA, JTextField textField1, JButton unsortedBtn,
                 JButton sortedBtn, JLabel sizeLabel, JLabel algLabel, JLabel sortLabel, int size, boolean sorted,
                 int alg, JLabel timeLabel)
    {
        this.comboBox1 = comboBox1;
        this.startBtn = startBtn;
        this.welcomeTA = welcomeTA;
        this.textField1 = textField1;
        this.unsortedBtn = unsortedBtn;
        this.sortedBtn = sortedBtn;
        this.sizeLabel = sizeLabel;
        this.algLabel = algLabel;
        this.sortLabel = sortLabel;
        this.size = size;
        this.sorted = sorted;
        this.alg = alg;
        this.timeLabel = timeLabel;
    }

    // Runs program once all requirements are fulfilled.
    public void runSort(int size, boolean sorted, int alg, JTextArea welcomeTA, JLabel timeLabel)
    {
        // When all the information is gathered this runs the sorting algorithm.
        Comparable[] a = new Comparable[this.size];
        StopwatchCPU stopwatchCPU = new StopwatchCPU();

        // Constructs the file name.
        String filename;
        int element;
        if (sorted) {
            filename = "sorted";
        } else {
            filename = "unsorted";
        }
        filename += this.size + ".txt";

        // Creates elements and adds elements to array.
        if (sorted) {
            for (int i = 0; i < this.size; i++) {
                a[i] = i + 1;
            }
        } else {
            Random rand = new Random();
            for (int i = 0; i < this.size; i++) {
                element = rand.nextInt(this.size * 10) + 1;
                a[i] = element;
            }
        }

        // Times the sorting of the data.
        switch (alg) {
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
                MergeSort.mergeSort(a, 0, a.length - 1);
                endTime = stopwatchCPU.elapsedTime();
                break;
            case 6:
                startTime = stopwatchCPU.elapsedTime();
                QuickSort.quickSort(a, 0, a.length - 1);
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
        System.out.println("end time: " + endTime);
        System.out.println("start time: " + startTime);

        // Determines elapsed time from sorting.
        endTime -= startTime;
        Controller.setTime(endTime);

        // Generates sorted data set file.
        File file = new File(filename);
        try
        {
            PrintWriter writer = new PrintWriter(file, "UTF-8");
            for (Comparable i : a)
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
        for (int i = 0; i < a.length; i++) {
            System.out.println("i: " + i + "\telement: " + a[i]);
        }

    }
}
