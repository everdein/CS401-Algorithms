// Algs-4 Imports.
import edu.princeton.cs.algs4.In;

// Java Imports.
import java.util.HashMap;

public class ArtistsMap
{
    // Creates hash map object.
    HashMap<Integer, String> hashMap = new HashMap<>();

    // Reads the artist.dat file and parses each line to get the artist id and name.
    // Then stores these variables into a hash map.
    public HashMap getArtists(String fileName3)
    {
        In in = new In(fileName3);
        in.readLine();
        while(!in.isEmpty())
        {
            String line = in.readLine();
            String[] parts = line.split("\\s+");
            String artist = "";
            for(int i = 1; i < parts.length - 2; i++)
            {
                artist += parts[i] + " ";
            }
            hashMap.put(Integer.parseInt(parts[0]), artist);
        }
        return hashMap;
    }
}
