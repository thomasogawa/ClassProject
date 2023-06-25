/** Graduate.java
*
* This is a Graduate class that extends the Student class
* @author Thomas Ogawa
* @author Student ID: 2370770
* @author togawa@chapman.edu
* CPSC 231-02 - Prof. Stevens
* Programing Mastery Project 4a: Inheritance, Interfaces, & Abstract Classes - Oh My!
* @version 1.0
*/
public class Graduate extends Student{

/** Number of Papers Written by Graduate */
protected int m_numOfPapers;
/** Thesis Advisor of Graduate */
protected String m_thesisAdv;

/**The default constructor - sets numOfPapers to -1 and thesisAdv to null.
 */
public Graduate(){
  super();
  m_numOfPapers = -1;
  m_thesisAdv = null;
}

/** Overloaded Constructor - creates a Graduate given name, age, address, phonenumber, ID, entry year, major, minor, classStanding, number of papers, and thesis advisor.
*@param name String representing affiliate's name
*@param age int representing affiliate's age
*@param address String representing affiliate's address
*@param phoneNumber long representing affiliate's phone number
*@param id int representing affiliate's ID number
*@param entryYear int representing affiliate's entry year
*@param major String representing student's major
*@param minor String representing student's minor
*@param classStanding String representing student's class standing
*@param numOfPapers int representing numOfPapers of the Graduate
*@param thesisAdv String representing Graduate's thesis advisor
*/
public Graduate(String name, int age, String address, long phoneNumber, int id, int entryYear, String major,
 String minor, String classStanding, int numOfPapers, String thesisAdv){
  super(name, age, address, phoneNumber, id, entryYear, major, minor, classStanding);
  m_numOfPapers = numOfPapers;
  m_thesisAdv = thesisAdv;
}

/** Returns the numOfPapers.
* @return An int representing the Number of Papers Written by Graduate
*/
public int getNumOfPapers(){
  return m_numOfPapers;
}

/** Returns the thesisAdv.
* @return A String representing the Thesis Advisor of Graduate
*/
public String getThesisAdv(){
  return m_thesisAdv;
}


/** Sets the numOfPapers.
* @param numOfPapers The Number of Papers Written by Graduate
*/
public void setNumOfPapers(int numOfPapers){
  m_numOfPapers = numOfPapers;
}

/** Sets the thesisAdv.
* @param thesisAdv The Thesis Advisor of Graduate
*/
public void setThesisAdv(String thesisAdv){
  m_thesisAdv = thesisAdv;
}

/** Method prints out the information of the Graduate.
*/
public void print(){
  super.print();
  String s = "";
  s += ", Number of Papers: " + m_numOfPapers;
  s += ", Thesis Advisor: " + m_thesisAdv;
  System.out.print(s);
}


}
