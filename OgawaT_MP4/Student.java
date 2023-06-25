/** Student.java
*
* This is an abstract Student class that extends the ChapmanAffiliate class
* @author Thomas Ogawa
* @author Student ID: 2370770
* @author togawa@chapman.edu
* CPSC 231-02 - Prof. Stevens
* Programing Mastery Project 4a: Inheritance, Interfaces, & Abstract Classes - Oh My!
* @version 1.0
*/
abstract class Student extends ChapmanAffiliates{

/** Major of Student */
protected String m_major;
/** Minor of Student */
protected String m_minor;
/** Class Standing of Student */
protected String m_classStanding;

/**The default constructor - sets major to null, minor to null, and classStanding to null.
 */
public Student(){
  super();
  m_major = null;
  m_minor = null;
  m_classStanding = null;
}

/** Overloaded Constructor -creates a Student given name, age, address, phonenumber, ID, entry year, major, minor, and classStanding.
*@param name String representing affiliate's name
*@param age int representing affiliate's age
*@param address String representing affiliate's address
*@param phoneNumber long representing affiliate's phone number
*@param id int representing affiliate's ID number
*@param entryYear int representing affiliate's entry year
*@param major String representing student's major
*@param minor String representing student's minor
*@param classStanding String representing student's class standing
*/
public Student(String name, int age, String address, long phoneNumber, int id, int entryYear, String major, String minor, String classStanding){
  super(name, age, address, phoneNumber, id, entryYear);
  m_major = major;
  m_minor = minor;
  m_classStanding = classStanding;
}

/** Returns the major.
* @return A String representing the Student's major
*/
public String getMajor(){
  return m_major;
}
/** Returns the minor.
* @return A String representing the Student's minor
*/
public String getMinor(){
  return m_minor;
}
/** Returns the classStanding.
* @return A String representing the Student's class standing
*/
public String getClassStanding(){
  return m_classStanding;
}

/** Sets the major.
* @param major The major of the Student
*/
public void setMajor(String major){
  m_major = major;
}

/** Sets the minor.
* @param minor The minor of the Student
*/
public void setMinor(String minor){
  m_minor = minor;
}

/** Sets the classStanding.
* @param classStanding The class standing of the Student
*/
public void setClassStanding(String classStanding){
  m_classStanding = classStanding;
}

/** Method prints out the information of the Student.
*/
public void print(){
  super.print();
  String s = "";
  s += ", Major: " + m_major;
  s += ", Minor: " + m_minor;
  s += ", Class Standing: " + m_classStanding;
  System.out.print(s);

}


}
