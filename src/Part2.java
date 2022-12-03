import java.io.*;
import java.util.ArrayList;

public class Part2
{
    public static ArrayList<ArrayList<Integer>> lines = new ArrayList<>();
    //Returns a BufferedReader for the file
    public static BufferedReader readFile() throws FileNotFoundException
    {
        String file = new File("").getAbsolutePath();
        file = file.concat("\\src\\InputData.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        return bufferedReader;
    }

    //Finds the priority in a list of 3 lines
    public static int findPriority(ArrayList<Integer> line)
    {
        lines.add(line);
        if(lines.size() == 3)
        {
            lines.get(0).retainAll(lines.get(1));
            lines.get(0).retainAll(lines.get(2));
            int item = lines.get(0).get(0);
            lines.clear();
            return item;
        }
        return 0;
    }

    public static void main(String args[]) throws IOException
    {
        int total = 0;
        String line = "";
        BufferedReader reader = readFile();
        while ((line = reader.readLine()) != null)
        {
            ArrayList<Integer> intLine = new ArrayList<>();
            for (char item: line.toCharArray())
            {
                int iItem = 0;
                //Subtract
                if(Character.getType(item) == Character.UPPERCASE_LETTER)
                {
                    iItem = ((int)(item) - 38);
                }
                else
                {
                    iItem = ((int)(item) - 96);
                }
                intLine.add(iItem);
            }
            total = total + findPriority(intLine);
        }
        System.out.println("Sum of priorities: " + total);
    }
}
