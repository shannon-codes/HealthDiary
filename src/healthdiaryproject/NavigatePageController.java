/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthdiaryproject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 *
 * Description: This is a Controller class for managing the Navigate Page (View) containing the logic for handling events
 *
 * @author SL, MS
 */

public class NavigatePageController implements Initializable
{

   //Fields

   @FXML
   private Label label;
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
   private Label changesSavedLabel;


   int counter = 0;

   //Methods

   @FXML
   private void NextButtonPressed (ActionEvent event)
   {
      if (counter < (FileManage.records.size() - 1)) {
         counter++;
         display(counter);
      }
      else {
         counter = 0;
         display(counter);
      }


   }

   @FXML
   private void PreviousButtonPressed (ActionEvent event)
   {
      if (counter > 0) {
         counter--;
         display(counter);
      }
      else {
         counter = (FileManage.records.size() - 1);
         display(counter);
      }
   }

   @FXML
   private void FirstButtonPressed (ActionEvent event)
   {
      counter = 0;
      display(counter);
   }

   @FXML
   private void LastButtonPressed (ActionEvent event)
   {
      counter = FileManage.records.size() - 1;
      display(counter);

   }

   @FXML
   private void SaveChangesButtonPressed (ActionEvent event)
   {

      FileManage.records.get(counter).setDate(dateBox.getText());
      FileManage.records.get(counter).setHoursOfSleep(Integer.parseInt(sleepBox.getText()));
      FileManage.records.get(counter).setWeight(Integer.parseInt(weightBox.getText()));
      FileManage.records.get(counter).setBloodPressure(bloodPressureBox.getText());
      FileManage.records.get(counter).setMealName(mealNameBox.getText());
      FileManage.records.get(counter).setFullnessLevel(Integer.parseInt(levelOfFullnessBox.getText()));
      FileManage.records.get(counter).setCaloriesConsumed(Integer.parseInt(caloriesConsumedBox.getText()));
      FileManage.records.get(counter).setAmPM(ampmComboBox.getValue());
      FileManage.records.get(counter).setTime(timeBox.getText());
      FileManage.records.get(counter).setExercise(exerciseBox.getText());

      FileManage.records.get(counter).setIntensity(leiComboBox.getValue());

      FileManage.records.get(counter).setDuration(Integer.parseInt(exDurationBox.getText()));

      FileManage.records.get(counter).setCaloriesBurned(Integer.parseInt(caloriesBurnedBox.getText()));

      FileManage.records.get(counter).setGlassesOfWater(Integer.parseInt(glassesOfWaterBox.getText()));

      FileManage.records.get(counter).setMood(moodBox.getText());

      FileManage.records.get(counter).setReflection(reflectionBox.getText());
      JOptionPane.showMessageDialog(null, "Saved your updates!");
   }

   public void display (int i)
   {
      changesSavedLabel.setText(null);
      dateBox.setText(FileManage.records.get(i).getDate());
      sleepBox.setText(FileManage.records.get(i).getHoursOfSleep() + "");
      weightBox.setText(FileManage.records.get(i).getWeight() + "");
      bloodPressureBox.setText(FileManage.records.get(i).getBloodPressure());
      mealNameBox.setText(FileManage.records.get(i).getMealName());
      levelOfFullnessBox.setText(FileManage.records.get(i).getFullnessLevel() + "");
      caloriesConsumedBox.setText(FileManage.records.get(i).getCaloriesConsumed() + "");
      ampmComboBox.setValue(FileManage.records.get(i).getAmPM());
      timeBox.setText(FileManage.records.get(i).getTime());
      exerciseBox.setText(FileManage.records.get(i).getExercise());
      leiComboBox.setValue(FileManage.records.get(i).getIntensity());
      exDurationBox.setText(FileManage.records.get(i).getDuration() + "");
      caloriesBurnedBox.setText(FileManage.records.get(i).getCaloriesBurned() + "");
      glassesOfWaterBox.setText(FileManage.records.get(i).getGlassesOfWater() + "");
      moodBox.setText(FileManage.records.get(i).getMood());
      reflectionBox.setText(FileManage.records.get(i).getReflection());
   }

   /**
    * Initializes the controller class.
    *
    * @param url
    * @param rb
    */
   @Override
   public void initialize (URL url, ResourceBundle rb)
   {
      ampmComboBox.getItems().addAll("AM", "PM");
      leiComboBox.getItems().addAll("Low", "Medium", "High");
      //ampmComboBox.getValue();
      counter = 0;
      display(counter);
   }

}
