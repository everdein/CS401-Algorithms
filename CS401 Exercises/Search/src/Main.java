// Binary search, not binary search tree.
// Kind of like opening a book and searching for a page.

public class Main {

    public static void main(String[] args)
    {
        System.out.println("Hello World!");
//        BinarySearchTree<String, Integer> bst = new BinarySearchTree<String, Integer>();


        RedBlackTree<String, Integer> rbt = new RedBlackTree<>();
        rbt.put("S", 1);
        rbt.put("E", 5);
        rbt.put("A", 7);
        rbt.put("R", 10);
        rbt.put("C", 8);
        rbt.put("H", 5);

        for(String key: rbt.keys())
        {
            System.out.println("key" + ":" + rbt.get(key)) ;
        }

    }

//    // Recursive binary search algorithm.
//    public static int binarySearch(Comparable[] a, Comparable key, int left, int right)
//    {
//        if(left <= right)
//        {
//            int midPoint = (left + right) / 2;
//            int compare = key.compareTo(a[midPoint]);
//            if(compare == 0)
//            {
//                return midPoint;
//            }
//            else if(compare < 0)
//            {
//                binarySearch(a, key, left, midPoint - 1);
//            }
//            else
//            {
//                binarySearch(a, key, midPoint + 1, right);
//            }
//        }
//        return -1;
//    }

//    // Non recursive binary search algorithm.
//    public static int binarySearch(Comparable[] a, Comparable key, int left, int right)
//    {
//        while(left <= right)
//        {
//            int midPoint = (left + right) / 2;
//            int compare = key.compareTo(a[midPoint]);
//            if(compare == 0)
//            {
//                return midPoint;
//            }
//            else if(compare < 0)
//            {
//                right = midPoint - 1;
//            }
//            else
//            {
//                left = midPoint + 1;
//            }
//        }
//        return -1;
//    }

}
