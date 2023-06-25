/** PartTime.java
*
* This is an PartTime class that extends the Staff class
* @author Thomas Ogawa
* @author Student ID: 2370770
* @author togawa@chapman.edu
* CPSC 231-02 - Prof. Stevens
* Programing Mastery Project 4a: Inheritance, Interfaces, & Abstract Classes - Oh My!
* @version 1.0
*/
public class PartTime extends Staff{

/** Hourly Salary of PartTime */
protected double m_hourlySalary;

/**The default constructor - sets hourlySalary to -1.
 */
public PartTime(){
  super();
  m_hourlySalary = -1;
}

/** Overloaded Constructor -creates a FullTime given name, age, address, phonenumber, ID, entry year, title, building, and hourly salary.
*@param name String representing affiliate's name
*@param age int representing affiliate's age
*@param address String representing affiliate's address
*@param phoneNumber long representing affiliate's phone number
*@param id int representing affiliate's ID number
*@param entryYear int representing affiliate's entry year
*@param title String representing staff's title
*@param building String representing staff's building
*@param hourlySalary double representing the PartTime's hourlySalary
*/
public PartTime(String name, int age, String address, long phoneNumber, int id, int entryYear, String title, String building, double hourlySalary){
  super(name, age, address, phoneNumber, id, entryYear, title, building);
  m_hourlySalary = hourlySalary;
}

/** Returns the hourlySalary.
* @return An double representing the PartTime's Hourly Salary
*/
public double getHourlySalary(){
  return m_hourlySalary;
}

/** Sets the hourlySalary.
* @param hourlySalary The PartTime's Hourly Salary
*/
public void setHourlySalary(double hourlySalary){
  m_hourlySalary = hourlySalary;
}

/** Method prints out the information of the PartTime.
*/
public void print(){
  super.print();
  String s = "";
  s += ", Hourly Salary: $" + m_hourlySalary;
  System.out.print(s);;
}


}
