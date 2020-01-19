package healthdiaryproject;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/*
 * Description: This class is has the main method and has the start() method entry point for JavaFX application to define the user interface setting the stage and scene containers. When user exits, there is a call to save the ArrayList records to data.txt file.
 *
 * @author SL, MS
 */


public class HealthDiaryProject extends Application
{

   //Fields
   @FXML
   AnchorPane main;
   public static FileManage fileManage = new FileManage();

   //Methods

   @Override
   public void start (Stage stage) throws Exception
   {
      Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

      Scene scene = new Scene(root);
      stage.setScene(scene);
      stage.show();

      fileManage.readTextFile();

   }

   @Override
   public void stop () throws Exception
   {
      System.out.println("Stage is closing. Saving File");
      // Save file
      fileManage.saveTextFile();
      super.stop();
   }

   /**
    * @param args the command line arguments
    */
   public static void main (String[] args)
   {
      launch(args);
   }



}
