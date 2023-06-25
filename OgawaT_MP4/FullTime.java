/** FullTime.java
*
* This is an FullTime class that extends the Staff class
* @author Thomas Ogawa
* @author Student ID: 2370770
* @author togawa@chapman.edu
* CPSC 231-02 - Prof. Stevens
* Programing Mastery Project 4a: Inheritance, Interfaces, & Abstract Classes - Oh My!
* @version 1.0
*/
public class FullTime extends Staff{

/** Yearly Salary of FullTime */
protected int m_yearlySalary;

/**The default constructor - sets yearlySalary to -1.
 */
public FullTime(){
  super();
  m_yearlySalary = -1;
}

/** Overloaded Constructor -creates a FullTime given name, age, address, phonenumber, ID, entry year, title, building, and yearly salary.
*@param name String representing affiliate's name
*@param age int representing affiliate's age
*@param address String representing affiliate's address
*@param phoneNumber long representing affiliate's phone number
*@param id int representing affiliate's ID number
*@param entryYear int representing affiliate's entry year
*@param title String representing staff's title
*@param building String representing staff's building
*@param yearlySalary int representing the FullTime's yearlySalary
*/
public FullTime(String name, int age, String address, long phoneNumber, int id, int entryYear, String title, String building, int yearlySalary){
  super(name, age, address, phoneNumber, id, entryYear, title, building);
  m_yearlySalary = yearlySalary;
}

/** Returns the yearlySalary.
* @return An int representing the FullTime's Yearly Salary
*/
public int getYearlySalary(){
  return m_yearlySalary;
}

/** Sets the yearlySalary.
* @param yearlySalary The FullTime's Yearly Salary
*/
public void setYearlySalary(int yearlySalary){
  m_yearlySalary = yearlySalary;
}

/** Method prints out the information of the FullTime.
*/
public void print(){
  super.print();
  String s = "";
  s += ", Yearly Salary: $" + m_yearlySalary;
  System.out.print(s);;
}


}
