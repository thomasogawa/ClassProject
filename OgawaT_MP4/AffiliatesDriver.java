import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.PrintStream;
import java.io.File;
/** AffiliatesDriver.java
*
* This is a AffiliatesDriver class
* @author Thomas Ogawa
* @author Student ID: 2370770
* @author togawa@chapman.edu
* CPSC 231-02 - Prof. Stevens
* Programing Mastery Project 4b: Files, Exceptions, & HashMaps –Oh my!
* @version 1.0
*/
public class AffiliatesDriver{

/** Method takes in a user's string accounting for user error.
*@return A String representing the user's entered String
*/
public static String getString(){
  Scanner scnr = new Scanner(System.in);
  while(true){
    try {
      return scnr.next();
    } catch(java.util.InputMismatchException e) {
      scnr.next();
      System.out.println("Not a valid string try again.");
    }
  }
}

/** Method takes in a user's int accounting for user error.
*@return An int representing the user's entered int
*/
public static int getInt(){
  Scanner scnr = new Scanner(System.in);
  while(true){
    try {
      return scnr.nextInt();
    } catch(java.util.InputMismatchException e) {
      scnr.next();
      System.out.println("Not a valid integer try again.");
    }
  }
}

/** Method takes in a user's long accounting for user error.
*@return A long representing the user's entered long
*/
public static long getLong(){
  Scanner scnr = new Scanner(System.in);
  while(true){
    try {
      return scnr.nextLong();
    } catch(java.util.InputMismatchException e) {
      scnr.next();
      System.out.println("Not a valid long try again.");
    }
  }
}

/** Method takes in a user's double accounting for user error.
*@return A double representing the user's entered double
*/
public static double getDouble(){
  Scanner scnr = new Scanner(System.in);
  while(true){
    try {
      return scnr.nextDouble();
    } catch(java.util.InputMismatchException e) {
      scnr.next();
      System.out.println("Not a valid Double try again.");
    }
  }
}

/** The main method. Exercises the Database's Classes functionality.
* @param args The command line arguments (not used)
*/
public static void main(String[] args) {
  ArrayList<ChapmanAffiliates> affiliateRec = new ArrayList<ChapmanAffiliates>();// Creates New database
  Scanner scnr = new Scanner(System.in);//Creates scanner object
  int userinput = 8;//Creats and sets user input to 8
  System.out.println("This program creates a University Database");//Informs User of Program

   //While loop to keep prompting user for info
   while(userinput != 6){
     System.out.println("What do you want to do?\n"); //Informs user with options of what to do
     System.out.println("1) Create an affiliate record");
     System.out.println("2) Print infomation for an Affiliate gived ID");
     System.out.println("3) List all affiliates in order of seniority");
     System.out.println("4) Delete Record given ID");
     System.out.println("5) Save your Database to a file");
     System.out.println("6) Exit");
     try{//Error Handling incase user enters invalid integer
       userinput = scnr.nextInt();
     }
     catch(java.util.InputMismatchException e){
       scnr.next();
       System.out.println("Invalid Input Please Enter a Number 1-6");

     }

     //Option 1 if user wants to add to database
     if(userinput == 1){
       int affType = 0;

       //Informs user of possible Affiliates and prompts them for which affiliate they want to add to database, also has an exit option.
       while(affType != 8){
         try{
           System.out.println("What type of Chapman Affiliate Record do you want to make?");
           System.out.println("1) Associate Professor");
           System.out.println("2) Assistant Professor");
           System.out.println("3) Full Professor");
           System.out.println("4) Graduate Student");
           System.out.println("5) Undergraduate Student");
           System.out.println("6) FullTime Staff");
           System.out.println("7) PartTime Staff");
           System.out.println("8) Go back");
           affType = scnr.nextInt();
         }
         catch(java.util.InputMismatchException e){
           scnr.next();
           System.out.println("Invalid Input Please Enter a Number 1-8");
         }

         //Or Prompts User infromation regarding an AssociateProfessor
         if(affType == 1){

           System.out.println("Enter a name: ");
           String name = getString();
           System.out.println("Enter Age: ");
           int age = getInt();
           System.out.println("Enter Address: (No Spaces)");
           String address = getString();
           System.out.println("Enter Phone Number: ");
           long phoneNumber = getLong();
           System.out.println("Enter ID: ");
           int id = getInt();
           System.out.println("Enter Entry Year: ");
           int entryYear = getInt();
           System.out.println("Enter Department: ");
           String department = getString();
           System.out.println("Enter Yearly Salary: ");
           int yearlySalary = getInt();
           System.out.println("Enter Number of Papers: ");
           int numOfPapers = getInt();
           System.out.println("Enter Years Since Tenure: ");
           int yearsSinceTenure = getInt();

           AssociateProfessor ap = new AssociateProfessor(name, age, address, phoneNumber, id, entryYear, department,
            yearlySalary, numOfPapers, yearsSinceTenure);

           affiliateRec.add(ap);

         }
         //Or Prompts User infromation regarding an AssistantProfessor
         else if(affType == 2){

           System.out.println("Enter a name: ");
           String name = getString();
           System.out.println("Enter Age: ");
           int age = getInt();
           System.out.println("Enter Address: (No Spaces)");
           String address = getString();
           System.out.println("Enter Phone Number: ");
           long phoneNumber = getLong();
           System.out.println("Enter ID: ");
           int id = getInt();
           System.out.println("Enter Entry Year: ");
           int entryYear = getInt();
           System.out.println("Enter Department: ");
           String department = getString();
           System.out.println("Enter Yearly Salary: ");
           int yearlySalary = getInt();
           System.out.println("Enter Number of Papers: ");
           int numOfPapers = getInt();
           System.out.println("Enter Years Until Tenure: ");
           int yearsUntilTenure = getInt();

           AssistantProfessor ap = new AssistantProfessor(name, age, address, phoneNumber, id, entryYear, department,
            yearlySalary, numOfPapers, yearsUntilTenure);

           affiliateRec.add(ap);

         }

         //Or Prompts User infromation regarding an FullProfessor
         else if(affType == 3){

           System.out.println("Enter a name: ");
           String name = getString();
           System.out.println("Enter Age: ");
           int age = getInt();
           System.out.println("Enter Address: (No Spaces)");
           String address = getString();
           System.out.println("Enter Phone Number: ");
           long phoneNumber = getLong();
           System.out.println("Enter ID: ");
           int id = getInt();
           System.out.println("Enter Entry Year: ");
           int entryYear = getInt();
           System.out.println("Enter Department: ");
           String department = getString();
           System.out.println("Enter Yearly Salary: ");
           int yearlySalary = getInt();
           System.out.println("Enter Number of Papers: ");
           int numOfPapers = getInt();
           System.out.println("Enter Years Until Retire: ");
           int yearsUntilRetire = getInt();

           FullProfessor fp = new FullProfessor(name, age, address, phoneNumber, id, entryYear, department,
            yearlySalary, numOfPapers, yearsUntilRetire);

           affiliateRec.add(fp);

         }

         //Or Prompts User infromation regarding a Graduate Student
         else if(affType == 4){

           System.out.println("Enter a name: ");
           String name = getString();
           System.out.println("Enter Age: ");
           int age = getInt();
           System.out.println("Enter Address: (No Spaces)");
           String address = getString();
           System.out.println("Enter Phone Number: ");
           long phoneNumber = getLong();
           System.out.println("Enter ID: ");
           int id = getInt();
           System.out.println("Enter Entry Year: ");
           int entryYear = getInt();
           System.out.println("Enter Major: ");
           String major = getString();
           System.out.println("Enter Minor: ");
           String minor = getString();
           System.out.println("Enter Class Standing: ");
           String classStanding = getString();
           System.out.println("Enter Number of Papers: ");
           int numOfPapers = getInt();
           System.out.println("Thesis Advisor: ");
           String thesisAdv = getString();


           Graduate g = new Graduate(name, age, address, phoneNumber, id, entryYear,
           major, minor, classStanding, numOfPapers, thesisAdv);

           affiliateRec.add(g);

         }

         //Or Prompts User infromation regarding a Undergraduate Student
         else if(affType == 5){

           System.out.println("Enter a name: ");
           String name = getString();
           System.out.println("Enter Age: ");
           int age = getInt();
           System.out.println("Enter Address: (No Spaces)");
           String address = getString();
           System.out.println("Enter Phone Number: ");
           long phoneNumber = getLong();
           System.out.println("Enter ID: ");
           int id = getInt();
           System.out.println("Enter Entry Year: ");
           int entryYear = getInt();
           System.out.println("Enter Major: ");
           String major = getString();
           System.out.println("Enter Minor: ");
           String minor = getString();
           System.out.println("Enter Class Standing: ");
           String classStanding = getString();
           System.out.println("Enter Number of Courses ");
           int numOfCourses = getInt();
           System.out.println("Scholarship Amount: $");
           int scholarshipAmt = getInt();

           Undergraduate u = new Undergraduate(name, age, address, phoneNumber, id, entryYear,
           major, minor, classStanding, numOfCourses, scholarshipAmt);

           affiliateRec.add(u);

         }

         //Or Prompts User infromation regarding a FullTime Staff
         else if(affType == 6){

           System.out.println("Enter a name: ");
           String name = getString();
           System.out.println("Enter Age: ");
           int age = getInt();
           System.out.println("Enter Address: (No Spaces)");
           String address = getString();
           System.out.println("Enter Phone Number: ");
           long phoneNumber = getLong();
           System.out.println("Enter ID: ");
           int id = getInt();
           System.out.println("Enter Entry Year: ");
           int entryYear = getInt();
           System.out.println("Enter Building: ");
           String building = getString();
           System.out.println("Enter Title: ");
           String title = getString();
           System.out.println("Enter Yearly Salary: ");
           int yearlySalary = getInt();

           FullTime fs = new FullTime(name, age, address, phoneNumber, id,
           entryYear, title, building, yearlySalary);

           affiliateRec.add(fs);

         }
         //Or Prompts User infromation regarding a PartTime Staff
         else if(affType == 7){

           System.out.println("Enter a name: ");
           String name = getString();
           System.out.println("Enter Age: ");
           int age = getInt();
           System.out.println("Enter Address: (No Spaces)");
           String address = getString();
           System.out.println("Enter Phone Number: ");
           long phoneNumber = getLong();
           System.out.println("Enter ID: ");
           int id = getInt();
           System.out.println("Enter Entry Year: ");
           int entryYear = getInt();
           System.out.println("Enter Building: ");
           String building = getString();
           System.out.println("Enter Title: ");
           String title = getString();
           System.out.println("Enter Hourly Salary: ");
           double hourlySalary = getDouble();

           PartTime ps = new PartTime(name, age, address, phoneNumber, id,
           entryYear, title, building, hourlySalary);

           affiliateRec.add(ps);

         }
         else if(affType == 8){
           System.out.println("\nSuccesfully went back\n");
         }
       }
     }
     //Option 2 if user wants to print out information of affiliate using thier ID number
     else if(userinput == 2){
       boolean validID = false;
       while(validID == false){
         System.out.println("Enter ID number: ");
         int userID = getInt();
         for(ChapmanAffiliates i: affiliateRec){
           if(i.getID() == userID){
             i.print();
             validID = true;
           }
         }
         if(validID == false){
           System.out.println("Cannot find an affiliate with this ID, Try Again or type '911' to go back");
         }
         if(userID == 911){
           System.out.println("\nSuccesfully went back\n");
           break;
         }
       }

     }

     //Option 3 if user wants to sort list by seniority, also prints out list of affiliates
     else if (userinput == 3){
       Collections.sort(affiliateRec);
       for(ChapmanAffiliates i : affiliateRec){
         i.print();
         System.out.println("");
       }
     }

     else if(userinput == 4){
       boolean validID = false;
       while(validID == false){
         System.out.println("Enter ID number: ");
         int userID = getInt();

         for(int i = 0; i < affiliateRec.size(); ++i){
           if(affiliateRec.get(i).getID() == userID){
             System.out.println("\nAffiliate with ID: " + affiliateRec.get(i).getID() + " successfully removed.\n");
             affiliateRec.remove(i);

             validID = true;
           }
         }

         if(validID == false){
           System.out.println("Cannot find an affiliate with this ID, Try Again or type '911' to go back");
         }
         if(userID == 911){
           System.out.println("\nSuccesfully went back\n");
           break;
         }
       }
     }

     //Option 5 if User wants to output database to a file
     else if(userinput == 5){
       PrintStream ps = null;
       String userFile = "";
       //Prompts User for name of output file
       System.out.println("Enter Name for output File: ");
       userFile = getString();
       //prints database to output file
       try{
         ps = new PrintStream(new File(userFile));
         PrintStream console = System.out;
         System.setOut(ps);
         for(ChapmanAffiliates i : affiliateRec){
           String caType = "";
           caType = i.getClass() + ", ";
           caType = caType.replace("class ","");
           System.out.print(caType);
           i.print();
           System.out.println("");
         }
         System.setOut(console);
         System.out.println("\nData Stored in File: " + userFile + "\n");
       }catch(IOException e){
         System.err.println("Write error!");
         System.err.println(e.getMessage());
       }finally{
         if(ps != null){
           ps.close();
         }

       }
     }

     //Option 6 exits the programs
     else if (userinput == 6){
       System.out.println("\nSuccesfully Exited");
     }

     //If invalid number is entered informs user
     else{
       System.out.println("\nInvalid Input Please Enter a Number 1-6\n");
     }


   }
}
}
