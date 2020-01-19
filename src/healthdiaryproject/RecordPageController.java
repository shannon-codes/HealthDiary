package healthdiaryproject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 *
 * Description: This is a Controller class for managing the Add New Record Page (View) containing the logic for handling events
 *
 * @author SL, MS
 */

public class RecordPageController implements Initializable
{
   //Fields
   @FXML
   private Button addButton;
   @FXML
   private TextField dateBox;
   @FXML
   private TextField sleepBox;
   @FXML
   private TextField weightBox;
   @FXML
   private TextField bloodPressureBox;
   @FXML
   private TextField mealNameBox;
   @FXML
   private TextField levelOfFullnessBox;
   @FXML
   private TextField caloriesConsumedBox;
   @FXML
   private ComboBox<String> ampmComboBox;
   @FXML
   private TextField timeBox;
   @FXML
   private TextField exerciseBox;
   @FXML
   private ComboBox<String> leiComboBox;
   @FXML
   private TextField exDurationBox;
   @FXML
   private TextField caloriesBurnedBox;
   @FXML
   private TextField glassesOfWaterBox;
   @FXML
   private TextField moodBox;
   @FXML
   private TextArea reflectionBox;
   @FXML
   private Button resetButton;

//Methods
   @FXML
   private void AddButtonAction (ActionEvent event)
   {

      try {

         if (dateBox.getText() != null
                 && sleepBox.getText() != null
                 && weightBox.getText() != null
                 && bloodPressureBox.getText() != null
                 && mealNameBox.getText() != null
                 && levelOfFullnessBox.getText() != null
                 && caloriesConsumedBox.getText() != null
                 && ampmComboBox.getValue() != null
                 && timeBox.getText() != null
                 && exerciseBox.getText() != null
                 && leiComboBox.getValue() != null
                 && exDurationBox.getText() != null
                 && caloriesBurnedBox.getText() != null
                 && glassesOfWaterBox.getText() != null
                 && moodBox.getText() != null
                 && reflectionBox.getText() != null) {

            DiaryRecord myRecord = new DiaryRecord(dateBox.getText(), Integer.parseInt(sleepBox.getText().trim()), Integer.parseInt(weightBox.getText().trim()), bloodPressureBox.getText(), mealNameBox.getText(), Integer.parseInt(levelOfFullnessBox.getText().trim()), Integer.parseInt(caloriesConsumedBox.getText().trim()), ampmComboBox.getValue(), timeBox.getText(), exerciseBox.getText(), leiComboBox.getValue(), Integer.parseInt(exDurationBox.getText().trim()), Integer.parseInt(caloriesBurnedBox.getText().trim()), Integer.parseInt(glassesOfWaterBox.getText().trim()), moodBox.getText(), reflectionBox.getText());
            FileManage.records.add(myRecord);
            JOptionPane.showMessageDialog(null, "Added Successfully!");
            clearFields();
         }
         else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Attention");
            alert.setHeaderText("Correct your input data");
            alert.setContentText("Fields cannot be empty");
            alert.showAndWait();
         }
      }
      catch (NumberFormatException ex) {
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Attention");
         alert.setHeaderText("Correct your input data");
         alert.setContentText("Enter only integer digit value(s) where appropriate");
         alert.showAndWait();
      }
   }

   @Override
   public void initialize (URL url, ResourceBundle rb)
   {
      ampmComboBox.getItems().addAll("AM", "PM");
      leiComboBox.getItems().addAll("Low", "Medium", "High");

   }

   @FXML
   private void clearFields ()
   {
      dateBox.setText(null);
      sleepBox.setText(null);
      weightBox.setText(null);
      bloodPressureBox.setText(null);
      mealNameBox.setText(null);
      levelOfFullnessBox.setText(null);
      caloriesConsumedBox.setText(null);
      ampmComboBox.setValue(null);
      timeBox.setText(null);
      exerciseBox.setText(null);
      leiComboBox.setValue(null);
      exDurationBox.setText(null);
      caloriesBurnedBox.setText(null);
      glassesOfWaterBox.setText(null);
      moodBox.setText(null);
      reflectionBox.setText(null);
   }
}
