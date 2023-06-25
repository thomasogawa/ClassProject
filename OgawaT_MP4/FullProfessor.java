/** FullProfessor.java
*
* This is an FullProfessor class that extends the Faculty class
* @author Thomas Ogawa
* @author Student ID: 2370770
* @author togawa@chapman.edu
* CPSC 231-02 - Prof. Stevens
* Programing Mastery Project 4a: Inheritance, Interfaces, & Abstract Classes - Oh My!
* @version 1.0
*/
public class FullProfessor extends Faculty{

/** Years Until Retire of Full Professor */
protected int m_yearsUntilRetire;

/**The default constructor - sets yearsUntilRetire to -1
 */
public FullProfessor(){
  super();
  m_yearsUntilRetire = -1;
}

/** Overloaded Constructor -creates a FullProfessor given name, age, address, phonenumber, ID, entry year, department, yearly salary, number of papers written, and years until retirement.
*@param name String representing affiliate's name
*@param age int representing affiliate's age
*@param address String representing affiliate's address
*@param phoneNumber long representing affiliate's phone number
*@param id int representing affiliate's ID number
*@param entryYear int representing affiliate's entry year
*@param department String representing faculty's department
*@param yearlySalary int representing faculty's yearly salary
*@param numOfPapers int representing faculty's number of papers written
*@param yearsUntilRetire int representing Full Professors years until retirement
*/
public FullProfessor(String name, int age, String address, long phoneNumber, int id, int entryYear, String department,
int yearlySalary, int numOfPapers,int yearsUntilRetire){
  super(name, age, address, phoneNumber, id, entryYear, department, yearlySalary, numOfPapers);
  m_yearsUntilRetire = yearsUntilRetire;
}

/** Returns the yearsUntilRetire.
* @return An int representing Full Professor's years until retirement
*/
public int getYearsUntilRetire(){
  return m_yearsUntilRetire;
}

/** Sets the yearsUntilRetire.
* @param yearsUntilRetire The number of years until retirement for Full Professor
*/
public void setYearsUntilRetire(int yearsUntilRetire){
  m_yearsUntilRetire = yearsUntilRetire;
}

/** Method prints out the information of the Full Professor.
*/
public void print(){
  super.print();
  String s = "";
  s += ", Years Until Retirement: " + m_yearsUntilRetire;
  System.out.print(s);

}


}
