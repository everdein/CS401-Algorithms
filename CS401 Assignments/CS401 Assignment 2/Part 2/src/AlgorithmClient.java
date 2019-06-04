/**
 * TEAM MEMBERS: Alex Kourkoumenlis & Matthew Clark
 * CLASS:        CS401 Algorithms
 * ASSIGNMENT:   Assignment 2 Part 2
 * DESCRIPTION:  Opens an algorithms client that tests different algorithms in various states such as sorted,
 *               unsorted, data set size, and displays how quickly the sorting was done. We chose the model
 *               view controller design pattern.
**/

public class AlgorithmClient
{
    public static void main(String[] args)
    {
        View view = new View();
        view.showMainFrameWindow();
    }
}