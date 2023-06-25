/** Faculty.java
*
* This is an abstract Faculty class that extends the ChapmanAffiliate class
* @author Thomas Ogawa
* @author Student ID: 2370770
* @author togawa@chapman.edu
* CPSC 231-02 - Prof. Stevens
* Programing Mastery Project 4a: Inheritance, Interfaces, & Abstract Classes - Oh My!
* @version 1.0
*/
abstract class Faculty extends ChapmanAffiliates{

/** Department of Faculty */
protected String m_department;
/** Yearly Salary of Faculty */
protected int m_yearlySalary;
/** Number of papers written by Faculty */
protected int m_numOfPapers;

/**The default constructor - sets department to null, yearlySalary to -1, and numOfPapers to -1
 */
public Faculty(){
  super();
  m_department = null;
  m_yearlySalary = -1;
  m_numOfPapers = -1;
}

/** Overloaded Constructor -creates a Faculty given name, age, address, phonenumber, ID, entry year, department, yearly salary, and number of papers written.
*@param name String representing affiliate's name
*@param age int representing affiliate's age
*@param address String representing affiliate's address
*@param phoneNumber long representing affiliate's phone number
*@param id int representing affiliate's ID number
*@param entryYear int representing affiliate's entry year
*@param department String representing faculty's department
*@param yearlySalary int representing faculty's yearly salary
*@param numOfPapers int representing faculty's number of papers written
*/
public Faculty(String name, int age, String address, long phoneNumber, int id, int entryYear, String department, int yearlySalary, int numOfPapers){
  super(name, age, address, phoneNumber, id, entryYear);
  m_department = department;
  m_yearlySalary = yearlySalary;
  m_numOfPapers = numOfPapers;
}

/** Returns the department.
* @return A String representing representing facutly's department
*/
public String getDepartment(){
  return m_department;
}

/** Returns the yearlySalary.
* @return An int representing representing facutly's yearly salary
*/
public int getYearlySalary(){
  return m_yearlySalary;
}

/** Returns the numOfPapers.
* @return An int representing representing facutly's number of papers written
*/
public int getNumOfPapers(){
  return m_numOfPapers;
}

/** Sets the department.
* @param department The department of faculty
*/
public void setDepartment(String department){
  m_department = department;
}

/** Sets the yearlySalary.
* @param yearlySalary The yearly salary of faculty
*/
public void setYearlySalary(int YearlySalary){
  m_yearlySalary = YearlySalary;
}

/** Sets the numOfPapers.
* @param numOfPapers The number of papers written by faculty
*/
public void setNumOfPapers(int numOfPapers){
  m_numOfPapers = numOfPapers;
}

/** Method prints out the information of the Faculty.
*/
public void print(){
  super.print();
  String s = "";
  s += ", Department: " + m_department;
  s += ", Yearly Salary: $" + m_yearlySalary;
  s += ", Number of Papers: " + m_numOfPapers;
  System.out.print(s);
}


}
