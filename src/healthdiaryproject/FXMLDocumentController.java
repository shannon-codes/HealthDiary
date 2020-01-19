/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthdiaryproject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author missm
 */
public class FXMLDocumentController implements Initializable
{

   @FXML
   private Label label;

   @FXML
   AnchorPane main;

//   @FXML
//   Button recordBtn, searchBtn;

   @FXML
   private void loadRecordPage (ActionEvent event) throws IOException
   {
      AnchorPane recordPage = FXMLLoader.load(getClass().getResource("RecordPage.fxml"));
      main.getChildren().setAll(recordPage);
   }


   @FXML
   private void loadSearchPage (ActionEvent event) throws IOException
   {
      AnchorPane searchPage = FXMLLoader.load(getClass().getResource("SearchPage.fxml"));
      main.getChildren().setAll(searchPage);
   }

   @FXML
   private void loadNavigatePage (ActionEvent event) throws IOException
   {
      if (!FileManage.records.isEmpty()) {
         AnchorPane navigatePage = FXMLLoader.load(getClass().getResource("NavigatePage.fxml"));
         main.getChildren().setAll(navigatePage);
      }
      else {
         Alert alert = new Alert(AlertType.INFORMATION);
         alert.setTitle("Attention");
         alert.setHeaderText("Hey!");
         alert.setContentText("No records to navigate. Add a new record.");

         alert.showAndWait();
      }
   }

   @Override
   public void initialize (URL url, ResourceBundle rb)
   {
      // TODO
   }

}
