import java.io.*;
import java.util.ArrayList;

public class Part1
{
    //Returns a BufferedReader for the file
    public static BufferedReader readFile() throws FileNotFoundException
    {
        String file = new File("").getAbsolutePath();
        file = file.concat("\\src\\InputData.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        return bufferedReader;
    }
    public static void main(String args[]) throws IOException
    {
        int total = 0;
        String line = "";
        BufferedReader reader = readFile();
        while ((line = reader.readLine()) != null)
        {
            ArrayList<Integer> firstHalf = new ArrayList<>();
            ArrayList<Integer> secondHalf = new ArrayList<>();
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
                if(firstHalf.size() < line.length()/2)
                {
                    firstHalf.add(iItem);
                }
                else
                {
                    secondHalf.add(iItem);
                }
            }
            firstHalf.retainAll(secondHalf);
            total = total + firstHalf.get(0);
        }
        System.out.println("Sum of priorities: " + total);
    }
}
