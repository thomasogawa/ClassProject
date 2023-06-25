/** Undergraduate.java
*
* This is a Undergraduate class that extends the Student class
* @author Thomas Ogawa
* @author Student ID: 2370770
* @author togawa@chapman.edu
* CPSC 231-02 - Prof. Stevens
* Programing Mastery Project 4a: Inheritance, Interfaces, & Abstract Classes - Oh My!
* @version 1.0
*/
public class Undergraduate extends Student{

/** Number of Courses taken by Undergraduate */
protected int m_numOfCourses;
/** Scholarship amount of Undergraduate */
protected int m_scholarshipAmt;

/**The default constructor - sets numOfCourses to -1 and scholarshipAmt to -1.
 */
public Undergraduate(){
  super();
  m_numOfCourses = -1;
  m_scholarshipAmt = -1;
}

/** Overloaded Constructor -creates an Undergraduate given name, age, address, phonenumber, ID, entry year, major, minor, classStanding, number of courses taken, and scholarship amount.
*@param name String representing affiliate's name
*@param age int representing affiliate's age
*@param address String representing affiliate's address
*@param phoneNumber long representing affiliate's phone number
*@param id int representing affiliate's ID number
*@param entryYear int representing affiliate's entry year
*@param major String representing student's major
*@param minor String representing student's minor
*@param classStanding String representing student's class standing
*@param numOfCourses int representing Number of Courses taken by Undergraduate
*@param scholarshipAmt int representing scholarship amount of Undergraduate
*/
public Undergraduate(String name, int age, String address, long phoneNumber, int id, int entryYear, String major,
 String minor, String classStanding, int numOfCourses, int scholarshipAmt){
  super(name, age, address, phoneNumber, id, entryYear, major, minor, classStanding);
  m_numOfCourses = numOfCourses;
  m_scholarshipAmt = scholarshipAmt;
}

/** Returns the numOfCourses.
* @return An int representing the Number of Courses taken by Undergraduate
*/
public int getNumOfCourses(){
  return m_numOfCourses;
}

/** Returns the scholarshipAmt.
* @return An int representing the scholarship amount of the Undergraduate
*/
public int getScholarshipAmt(){
  return m_scholarshipAmt;
}

/** Sets the numOfCourses.
* @param numOfCourses The Number of Courses taken by Undergraduate
*/
public void setNumOfCourses(int numOfCourses){
  m_numOfCourses = numOfCourses;
}

/** Sets the scholarshipAmts.
* @param scholarshipAmt The scholarship amount of the Undergraduate
*/
public void setScholarshipAmt(int scholarshipAmt){
  m_scholarshipAmt = scholarshipAmt;
}

/** Method prints out the information of the Undergraduate.
*/
public void print(){
  super.print();
  String s = "";
  s += ", Number of Courses Taken: " + m_numOfCourses;
  s += ", Scholarship Amount: $" + m_scholarshipAmt;
  System.out.print(s);
}


}
