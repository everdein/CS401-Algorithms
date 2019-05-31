import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main
{
    public static Student student;
    public static void main(String[] args) 
    {
//        List<Student> list = new ArrayList<Student>();
        Set<Student> list = new HashSet<Student>();
        Student std1 = new Student(123, "Michael");
        Student std2 = new Student(234, "Matthew");
        Student std3 = new Student(234, "Matthew");
//        Student std3 = new Student(321, "Brett");
        list.add(std1);
        list.add(std2);
        list.add(std3);
        System.out.println("List Size: " + list.size() + "\n");
        System.out.println("Contains: " + std1.getId() + " " + std1.getName() + " = " + list.contains(new Student(123, "Michael")) + "\n");

        int count = 0;
        for (Student x : list)
        {
            count++;
            System.out.println("Student " + count + ": \n" + "ID: " + x.getId() + "\nName: " + x.getName() + "\n");
        }

    }
}