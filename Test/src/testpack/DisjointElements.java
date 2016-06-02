package testpack;

/* Java program to check if two sets are distinct or not */
import java.util.*;

public class DisjointElements
{
    // This function prints all distinct elements
    static boolean areDisjoint(int set1[], int set2[])
    {
        // Creates an empty hashset
        HashSet<Integer> set = new HashSet<>();
        System.out.println(set);
        // Traverse the first set and store its elements in hash
        for (int i=0; i<set1.length; i++)
            set.add(set1[i]);
        System.out.println(set);
        // Traverse the second set and check if any element of it
        // is already in hash or not.
        for (int i=0; i<set2.length; i++)
            if (set.contains(set2[i]))
                return false;
 
        return true;
    }
 
    // Driver method to test above method
    public static void main (String[] args)
    {
        int set1[] = {10, 5, 3, 4, 6};
        int set2[] = {8, 7, 9};
        
        if (areDisjoint(set1, set2))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}