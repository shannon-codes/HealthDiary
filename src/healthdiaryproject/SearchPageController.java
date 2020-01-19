package healthdiaryproject;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javax.swing.JOptionPane;

/**
 *
 * Description: This is a Controller class for managing the Search Page (View) containing the logic for handling events
 *
 * @author SL, MS
 */

public class SearchPageController implements Initializable
{

   //Fields

   @FXML
   private TableView<DiaryRecord> tableView;
   @FXML
   private TableColumn<DiaryRecord, String> dateColumn;
   @FXML
   private TableColumn<DiaryRecord, String> hoursOfSleepColumn;
   @FXML
   private TableColumn<DiaryRecord, String> weightColumn;
   @FXML
   private TableColumn<DiaryRecord, String> bloodPressureColumn;
   @FXML
   private TableColumn<DiaryRecord, String> mealNameColumn;
   @FXML
   private TableColumn<DiaryRecord, String> fullnessLevelColumn;
   @FXML
   private TableColumn<DiaryRecord, String> caloriesConsumedColumn;
   @FXML
   private TableColumn<DiaryRecord, String> amPmColumn;
   @FXML
   private TableColumn<DiaryRecord, String> timeColumn;
   @FXML
   private TableColumn<DiaryRecord, String> exerciseColumn;
   @FXML
   private TableColumn<DiaryRecord, String> intensityColumn;
   @FXML
   private TableColumn<DiaryRecord, String> durationColumn;
   @FXML
   private TableColumn<DiaryRecord, String> caloriesBurnedColumn;
   @FXML
   private TableColumn<DiaryRecord, String> glassesOfWaterColumn;
   @FXML
   private TableColumn<DiaryRecord, String> moodColumn;
   @FXML
   private TableColumn<DiaryRecord, String> reflectionColumn;
   @FXML
   Label myLabel;
   @FXML
   TextField searchData;
   ArrayList<DiaryRecord> results = new ArrayList<>();
   //@FXML
   //ListView listViewBox;
   @FXML
   Label errorLabel;
   @FXML
   private Button deleteButton;

//Methods

   @Override
   public void initialize (URL url, ResourceBundle rb)
   {

      dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
      hoursOfSleepColumn.setCellValueFactory(new PropertyValueFactory<>("hoursOfSleep"));
      weightColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));
      bloodPressureColumn.setCellValueFactory(new PropertyValueFactory<>("bloodPressure"));
      mealNameColumn.setCellValueFactory(new PropertyValueFactory<>("mealName"));
      fullnessLevelColumn.setCellValueFactory(new PropertyValueFactory<>("fullnessLevel"));
      caloriesConsumedColumn.setCellValueFactory(new PropertyValueFactory<>("caloriesConsumed"));
      amPmColumn.setCellValueFactory(new PropertyValueFactory<>("amPM"));
      timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
      exerciseColumn.setCellValueFactory(new PropertyValueFactory<>("exercise"));
      intensityColumn.setCellValueFactory(new PropertyValueFactory<>("intensity"));
      durationColumn.setCellValueFactory(new PropertyValueFactory<>("duration"));
      caloriesBurnedColumn.setCellValueFactory(new PropertyValueFactory<>("caloriesBurned"));
      glassesOfWaterColumn.setCellValueFactory(new PropertyValueFactory<>("glassesOfWater"));
      moodColumn.setCellValueFactory(new PropertyValueFactory<>("mood"));
      reflectionColumn.setCellValueFactory(new PropertyValueFactory<>("reflection"));

      tableView.setItems(FXCollections.observableList(FileManage.records));
   }

   @FXML
   private void searchButtonPressed (ActionEvent event)
   {
      results.clear();
      tableView.setItems(FXCollections.observableList(results));
      errorLabel.setText("");

      String keyword = searchData.getText().trim();

      if (!keyword.isEmpty()) {
         for (int i = 0; i < FileManage.records.size(); i++) {
            if (FileManage.records.get(i).checkDate(keyword)) {
               results.add(FileManage.records.get(i));
            }
         }
         tableView.setItems(FXCollections.observableList(results));
         myLabel.setText(results.size() + " records found");
         myLabel.setTextFill(new Color(0, 0, 0, 1));
      }
      else {
         errorLabel.setText("Empty. Please fill in search.");
         errorLabel.setTextFill(new Color(1, 0, 0, 1));
      }

   }

   @FXML
   private void resetSearchButtonPressed (ActionEvent event)
   {
      searchData.setText(null);
      errorLabel.setText(null);
      myLabel.setText("All records shown");
      myLabel.setTextFill(new Color(0, 0, 0, 1));
      tableView.setItems(FXCollections.observableList(FileManage.records));
   }

   public void deleteButtonPushed ()
   {
      ObservableList<DiaryRecord> selectedRows, allRecords;
      allRecords = tableView.getItems();

      selectedRows = tableView.getSelectionModel().getSelectedItems();
      //loop over the selected rows and remove the DiaryRecord objects from the table
      for (DiaryRecord date : selectedRows) {
         allRecords.remove(date);
         FileManage.records.remove(date);
         JOptionPane.showMessageDialog(null, "Deleted Successfully!");
      }
   }
}
