/** AssociateProfessor.java
*
* This is an AssociateProfessor class that extends the Faculty class
* @author Thomas Ogawa
* @author Student ID: 2370770
* @author togawa@chapman.edu
* CPSC 231-02 - Prof. Stevens
* Programing Mastery Project 4a: Inheritance, Interfaces, & Abstract Classes - Oh My!
* @version 1.0
*/
public class AssociateProfessor extends Faculty{

/** Years Since Tenure of Associate Professor */
protected int m_yearsSinceTenure;

/**The default constructor - sets yearsSinceTenure to -1
 */
public AssociateProfessor(){
  super();
  m_yearsSinceTenure = -1;
}

/** Overloaded Constructor -creates a AssociateProfessor given name, age, address, phonenumber, ID, entry year, department, yearly salary, number of papers written, and years since tenure.
*@param name String representing affiliate's name
*@param age int representing affiliate's age
*@param address String representing affiliate's address
*@param phoneNumber long representing affiliate's phone number
*@param id int representing affiliate's ID number
*@param entryYear int representing affiliate's entry year
*@param department String representing faculty's department
*@param yearlySalary int representing faculty's yearly salary
*@param numOfPapers int representing faculty's number of papers written
*@param yearsSinceTenure int representing Associate Professors years since tenure
*/
public AssociateProfessor(String name, int age, String address, long phoneNumber, int id, int entryYear, String department,
 int yearlySalary, int numOfPapers,int yearsSinceTenure){
  super(name, age, address, phoneNumber, id, entryYear, department, yearlySalary, numOfPapers);
  m_yearsSinceTenure = yearsSinceTenure;
}

/** Returns the yearsSinceTenure.
* @return An int representing representing Associate Professor's years since tenure
*/
public int getYearsSinceTenure(){
  return m_yearsSinceTenure;
}

/** Sets the yearsSinceTenure.
* @param yearsSinceTenure The number of years until tenure for Associate Professor
*/
public void setYearsSinceTenure(int yearsSinceTenure){
  m_yearsSinceTenure = yearsSinceTenure;
}

/** Method prints out the information of the Assistant Professor.
*/
public void print(){
  super.print();
  String s = "";
  s += ", Years Since Tenure: " + m_yearsSinceTenure;
  System.out.print(s);;

}


}
