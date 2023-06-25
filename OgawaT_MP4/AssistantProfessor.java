/** AssistantProfessor.java
*
* This is an AssistantProfessor class that extends the Faculty class
* @author Thomas Ogawa
* @author Student ID: 2370770
* @author togawa@chapman.edu
* CPSC 231-02 - Prof. Stevens
* Programing Mastery Project 4a: Inheritance, Interfaces, & Abstract Classes - Oh My!
* @version 1.0
*/
public class AssistantProfessor extends Faculty{

/** Years Until Tenure of Assistant Professor*/
protected int m_yearsUntilTenure;

/**The default constructor - sets yearsUntilTenure to -1
 */
public AssistantProfessor(){
  super();
  m_yearsUntilTenure = -1;
}

/** Overloaded Constructor -creates a AssistantProfessor given name, age, address, phonenumber, ID, entry year, department, yearly salary, number of papers written, and years until tenure.
*@param name String representing affiliate's name
*@param age int representing affiliate's age
*@param address String representing affiliate's address
*@param phoneNumber long representing affiliate's phone number
*@param id int representing affiliate's ID number
*@param entryYear int representing affiliate's entry year
*@param department String representing faculty's department
*@param yearlySalary int representing faculty's yearly salary
*@param numOfPapers int representing faculty's number of papers written
*@param yearsUntilTenure int representing Assistant Professors years until tenure
*/
public AssistantProfessor(String name, int age, String address, long phoneNumber, int id, int entryYear, String department,
 int yearlySalary, int numOfPapers,int yearsUntilTenure){
  super(name, age, address, phoneNumber, id, entryYear, department, yearlySalary, numOfPapers);
  m_yearsUntilTenure = yearsUntilTenure;
}

/** Returns the yearsUntilTenure.
* @return An int representing representing Assistant Professor's years until tenure
*/
public int getYearsUntilTenure(){
  return m_yearsUntilTenure;
}

/** Sets the yearsUntilTenure.
* @param yearsUntilTenure The number of years until tenure for Assistant Professor
*/
public void setYearsUntilTenure(int yearsUntilTenure){
  m_yearsUntilTenure = yearsUntilTenure;
}

/** Method prints out the information of the Assistant Professor.
*/
public void print(){
  super.print();
  String s = "";
  s += ", Years Until Tenure: " + m_yearsUntilTenure;
  System.out.print(s);

}


}
