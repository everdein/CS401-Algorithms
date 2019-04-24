import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Client
{
    public static void main(String[] args) 
    {
        // List<Student> list = new ArrayList<Student>();
        Set<Student> list = new HashSet<Student>();
        Student std1 = new Student(123, "Michael");
        Student std2 = new Student(234, "Matthew");
        list.add(std1);
        list.add(std2);
        System.out.println(list.size());
        System.out.println(list.contains(new Student(123, "Michael")));
    }   
}