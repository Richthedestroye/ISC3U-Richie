package week5;

import java.util.Scanner;

public class crosscountry {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        processRunner(in);
        processRunner(in);
        processRunner(in);
        in.close();
        // these code segmants run the process runner to get the information from the user and close it 
     }
  

     private static void processRunner(Scanner in) {
      String firstName, lastName;
      String mileTwo, finishTime;
      String splitTwo, splitThree;
      String mileOne;


      // the following code segmants take input from the user to use the data 
        System.out.print("Please enter your first name: ");
        firstName = in.nextLine();

        System.out.print("Please enter your last name: ");
        lastName = in.nextLine();

        System.out.print("Please enter your 1 mile time: ");
        mileOne = in.nextLine();

        System.out.print("Please enter your 2 mile time: ");
        mileTwo = in.nextLine();

        System.out.print("Please enter your finishing time: ");
        finishTime = in.nextLine();

        


       splitTwo = subtractTimes(mileTwo, mileOne);
       splitThree = subtractTimes(finishTime, mileTwo);


       // Display a summary for the runner
       System.out.println("Name: " + firstName + " " + lastName);
System.out.println("Mile 1: " + mileOne);
System.out.println("Split 2: " + splitTwo);
System.out.println("Split 3: " + splitThree);
System.out.println("Finish Time: " + finishTime);
   }

  
     private static String subtractTimes(String endTime, String startTime) {
        double endInSeconds = convertToSeconds(endTime);
        double startInSeconds = convertToSeconds(startTime);
  
        double diffInSeconds = endInSeconds - startInSeconds;
  
        return convertToTime(diffInSeconds);
  //subtracts the times from eachother
      }
  
     private static String convertToTime(double diffInSeconds) {
        // used to get it back into the string format ex 6:02.232
   int getMinutes = (int)diffInSeconds / 60; 
   double getSeconds = diffInSeconds % 60;



        return String.format("%d:%06.3f", getMinutes, getSeconds);
  
        // create getMinutes and getSeconds functions to use
     }
  //String.format("%d:%06.3f", minutes, seconds); 
 //indexOf(":"); use to get everything before : so can multiply for seconds and add to everything after 
     private static double convertToSeconds(String endTime) {
     // used to make the minutes into seconds and add them so they can be subtracted by each other in subtract times 
      String minutes = endTime.substring(0, endTime.indexOf(":")); // gets the back part of the string
      String seconds = endTime.substring(endTime.indexOf(":") + 1); //gets the front part of the string 
      int minutes1 = Integer.parseInt(minutes);      
      double seconds1 = Double.parseDouble(seconds);

      return (minutes1 * 60) + seconds1;

     }
    }
   
   