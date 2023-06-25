/** Staff.java
*
* This is an abstract Staff class that extends the ChapmanAffiliate class
* @author Thomas Ogawa
* @author Student ID: 2370770
* @author togawa@chapman.edu
* CPSC 231-02 - Prof. Stevens
* Programing Mastery Project 4a: Inheritance, Interfaces, & Abstract Classes - Oh My!
* @version 1.0
*/
abstract class Staff extends ChapmanAffiliates{

/** Title of Staff */
protected String m_title;
/** Building of Staff */
protected String m_building;

/**The default constructor - sets title to null and building to null.
 */
public Staff(){
  super();
  m_title = null;
  m_building = null;
}

/** Overloaded Constructor -creates a Staff given name, age, address, phonenumber, ID, entry year, title, and building.
*@param name String representing affiliate's name
*@param age int representing affiliate's age
*@param address String representing affiliate's address
*@param phoneNumber long representing affiliate's phone number
*@param id int representing affiliate's ID number
*@param entryYear int representing affiliate's entry year
*@param title String representing staff's title
*@param building String representing staff's building
*/
public Staff(String name, int age, String address, long phoneNumber, int id, int entryYear, String title, String building){
  super(name, age, address, phoneNumber, id, entryYear);
  m_title = title;
  m_building = building;
}

/** Returns the title.
* @return A String representing the Staff's title
*/
public String getTitle(){
  return m_title;
}

/** Returns the building.
* @return A String representing the Staff's building
*/
public String getBuilding(){
  return m_building;
}

/** Sets the title.
* @param title The Staff's title
*/
public void setTitle(String title){
  m_title = title;
}

/** Sets the building.
* @param building The Staff's building
*/
public void setBuilding(String building){
  m_building = building;
}

/** Method prints out the information of the Staff.
*/
public void print(){
  super.print();
  String s = "";
  s += ", Title: " + m_title;
  s += ", Building: " + m_building;
  System.out.print(s);;
}


}
