package healthdiaryproject;
/*
 * Description: This class models a record (diary entry) in the file
 *
 * @author SL, MS
 */

public class DiaryRecord
{

   //Fields

   private String date;
   private int hoursOfSleep;
   private int weight;
   private String bloodPressure;
   private String mealName;
   private int fullnessLevel;
   private int caloriesConsumed;
   private String amPM;
   private String time;
   private String exercise;
   private String intensity;
   private int duration;
   private int caloriesBurned;
   private int glassesOfWater;
   private String mood;
   private String reflection;

   //Constructor

   public DiaryRecord (String date, int hoursOfSleep, int weight, String bloodPressure, String mealName, int fullnessLevel, int caloriesConsumed, String amPM, String time, String exercise, String intensity, int duration, int caloriesBurned, int glassesOfWater, String mood, String reflection)
   {
      this.date = date;
      this.hoursOfSleep = hoursOfSleep;
      this.weight = weight;
      this.bloodPressure = bloodPressure;
      this.mealName = mealName;
      this.fullnessLevel = fullnessLevel;
      this.caloriesConsumed = caloriesConsumed;
      this.amPM = amPM;
      this.time = time;
      this.exercise = exercise;
      this.intensity = intensity;
      this.duration = duration;
      this.caloriesBurned = caloriesBurned;
      this.glassesOfWater = glassesOfWater;
      this.mood = mood;
      this.reflection = reflection;
   }

   //Methods: Getters and Setters

   public String getDate ()
   {
      return date;
   }

   public int getHoursOfSleep ()
   {
      return hoursOfSleep;
   }

   public int getWeight ()
   {
      return weight;
   }

   public String getBloodPressure ()
   {
      return bloodPressure;
   }


   public String getMealName ()
   {
      return mealName;
   }

   public int getFullnessLevel ()
   {
      return fullnessLevel;
   }

   public int getCaloriesConsumed ()
   {
      return caloriesConsumed;
   }

   public String getAmPM ()
   {
      return amPM;
   }

   public String getTime ()
   {
      return time;
   }

   public String getExercise ()
   {
      return exercise;
   }

   public String getIntensity ()
   {
      return intensity;
   }

   public int getDuration ()
   {
      return duration;
   }

   public int getCaloriesBurned ()
   {
      return caloriesBurned;
   }

   public int getGlassesOfWater ()
   {
      return glassesOfWater;
   }

   public String getMood ()
   {
      return mood;
   }

   public String getReflection ()
   {
      return reflection;
   }

   public void setDate (String date)
   {
      this.date = date;
   }

   public void setHoursOfSleep (int hoursOfSleep)
   {
      this.hoursOfSleep = hoursOfSleep;
   }

   public void setWeight (int weight)
   {
      this.weight = weight;
   }

   public void setBloodPressure (String bloodPressure)
   {
      this.bloodPressure = bloodPressure;
   }

   public void setMealName (String mealName)
   {
      this.mealName = mealName;
   }

   public void setFullnessLevel (int fullnessLevel)
   {
      this.fullnessLevel = fullnessLevel;
   }

   public void setCaloriesConsumed (int caloriesConsumed)
   {
      this.caloriesConsumed = caloriesConsumed;
   }

   public void setTime (String time)
   {
      this.time = time;
   }

   public void setAmPM (String amPM)
   {
      this.amPM = amPM;
   }

   public void setIntensity (String intensity)
   {
      this.intensity = intensity;
   }

   public void setExercise (String exercise)
   {
      this.exercise = exercise;
   }

   public void setDuration (int duration)
   {
      this.duration = duration;
   }

   public void setCaloriesBurned (int caloriesBurned)
   {
      this.caloriesBurned = caloriesBurned;
   }

   public void setGlassesOfWater (int glassesOfWater)
   {
      this.glassesOfWater = glassesOfWater;
   }

   public void setMood (String mood)
   {
      this.mood = mood;
   }

   public void setReflection (String reflection)
   {
      this.reflection = reflection;
   }

   @Override
   public String toString ()
   {
      return (String.format("%s~%s~%s~%s~%s~%s~%s~%s~%s~%s~%s~%s~%s~%s~%s~%s", this.date, this.hoursOfSleep, weight, bloodPressure, mealName, fullnessLevel, caloriesConsumed, amPM, time, exercise, intensity, duration, caloriesBurned, glassesOfWater, mood, reflection));

   }
   //printwriter

   public boolean checkDate (String date)
   {
      return this.date.toLowerCase().contains(date.toLowerCase());
   }

   /* ArrayList results;
    * if(arr.get(i).checkDate(userString)){
    * results.add(att.get(i));
    * } */

}
