public class Main {

    public static void main(String[] args)
    {
        // Hello world
        System.out.println("Hello World!");

        // Student array.
        Student[] students = new Student[4];

        // Loads array.
        students[0] = new Student(12, "A", 3.4);
        students[1] = new Student(22, "B", 1.4);
        students[2] = new Student(34, "C", 3.7);
        students[3] = new Student(10, "D", 2.6);

        // Accesses sorting algorithms via individual classes
//        BubbleSort.bubbleSort(students);
//        InsertionSort.insertionSort(students);
//        MergeSort.mergeSort(students, 0, students.length - 1);
        SelectionSort.selectionSort(students);


        // Accesses sorting algorithms via Sort class.
//        Sort.bubbleSort(students);
//        Sort.insertionSort(students);
//        Sort.selectionSort(students);
//        Sort.mergeSort(students, 0, students.length - 1);
//        Sort.quickSort(students, 0, students.length -1);

        // Prints students ID, name, and GPA.
        for(Student s: students)
        {
            System.out.println(s);
        }
    }
}