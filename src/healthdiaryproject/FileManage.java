package healthdiaryproject;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/*
 * Description: This class is for managing the data.txt file with methods to input/output.
 * Reads from the data.txt file to loads the ArrayList with DiaryRecord objects at
 * startup. We initializing a static variable for the records ArrayList so that you
 * can call on it using className[dot]variableName,
 *
 * @author SL, MS
 */

public class FileManage
{

   //Static/class variable

   public static ArrayList<DiaryRecord> records = new ArrayList<DiaryRecord>();

   // Methods


   public void readTextFile () throws FileNotFoundException, IOException
   {

      // Create a File instance
      File file = new File("data.txt");
      if (file.exists()) {
         FileReader myFileReader = new FileReader(file);
         BufferedReader myBufferReader = new BufferedReader(myFileReader);
         // Read data from a file
         String lineFromFile;
         while ((lineFromFile = myBufferReader.readLine()) != null) {
            String[] parts = lineFromFile.split("~", 16);
            DiaryRecord abc = new DiaryRecord(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), parts[3], parts[4], Integer.parseInt(parts[5]), Integer.parseInt(parts[6]), parts[7], parts[8], parts[9], parts[10], Integer.parseInt(parts[11]), Integer.parseInt(parts[12]), Integer.parseInt(parts[13]), parts[14], parts[15]);
            records.add(abc);
         }
         // Close the file
         myFileReader.close();
         myBufferReader.close();
      }
   }

   public void saveTextFile () throws Exception
   {
      File file = new File("data.txt");
      PrintWriter outputFile = new PrintWriter(file);

      for (int i = 0; i < records.size(); i++) {
         String line = records.get(i).toString();
         outputFile.println(line);
      }
      outputFile.close();
   }


   public ArrayList<DiaryRecord> getRecords ()
   {
      return this.records;
   }
}
