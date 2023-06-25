/** ChapmanAffiliates.java
*
* This is an abstract ChapmanAffiliates class
* @author Thomas Ogawa
* @author Student ID: 2370770
* @author togawa@chapman.edu
* CPSC 231-02 - Prof. Stevens
* Programing Mastery Project 4a: Inheritance, Interfaces, & Abstract Classes - Oh My!
* @version 1.0
*/

abstract class ChapmanAffiliates implements Comparable<ChapmanAffiliates>,Printable{

/** Name of Chapman Affiliate */
private String m_name;
/** Age of Chapman Affiliate */
private int m_age;
/** Address of Chapman Affiliate */
private String m_address;
/** Phone Number of Chapman Affiliate */
private long m_phoneNumber;
/** ID number of Chapman Affiliate */
private int m_id;
/** Entry year of Chapman Affiliate */
private int m_entryYear;

/**The default constructor - sets name to null, age to -1, address to -1, phone number to -1, ID to -1, and entry year to -1
 */
public ChapmanAffiliates(){
  m_name = null;
  m_age = -1;
  m_address = null;
  m_phoneNumber = -1;
  m_id = -1;
  m_entryYear = -1;
}

/** Overloaded Constructor -creates a Chapman Affiliate given name, age, address, phonenumber, ID, and entry year.
*@param name String representing affiliate's name
*@param age int representing affiliate's age
*@param address String representing affiliate's address
*@param phoneNumber long representing affiliate's phone number
*@param id int representing affiliate's ID number
*@param entryYear int representing affiliate's entry year
*/
public ChapmanAffiliates(String name, int age, String address, long phoneNumber, int id, int entryYear){
  m_name = name;
  m_age = age;
  m_address = address;
  m_phoneNumber = phoneNumber;
  m_id = id;
  m_entryYear = entryYear;
}

/** Returns the name.
* @return A String representing representing affiliate's name
*/
public String getName(){
  return m_name;
}

/** Returns the age.
* @return An int representing representing affiliate's age
*/
public int getAge(){
  return m_age;
}

/** Returns the address.
* @return A String representing representing affiliate's address
*/
public String getAddress(){
  return m_address;
}

/** Returns the phoneNumber.
* @return An long representing representing affiliate's phone number
*/
public long getPhoneNumber(){
  return m_phoneNumber;
}

/** Returns the ID.
* @return An int representing representing affiliate's ID number
*/
public int getID(){
  return m_id;
}

/** Returns the entryYear.
* @return An int representing representing affiliate's entry year
*/
public int getEntryYear(){
  return m_entryYear;
}

/** Sets the name.
* @param name The name of affiliate
*/
public void setName(String name){
  m_name = name;
}

/** Sets the age.
* @param age The age of affiliate
*/
public void setAge(int age){
  m_age = age;
}

/** Sets the address.
* @param address The address of affiliate
*/
public void setAddress(String address){
  m_address = address;
}

/** Sets the phoneNumber.
* @param phoneNumber The phone number of affiliate
*/
public void setPhoneNumber(long phoneNumber){
  m_phoneNumber = phoneNumber;
}

/** Sets the ID.
* @param id The ID number of affiliate
*/
public void setID(int id){
  m_id = id;
}

/** Sets the entryYear.
* @param entryYear The entry year of affiliate
*/
public void setEntryYear(int entryYear){
  m_entryYear = entryYear;
}

/** Method compares two affiliates, specifically the entry year.
* @param o the ChapmanAffiliate to compare to
* @return an int value representating whether the entry year is the same(0), greater than(1), or less than(-1).
*/
public int compareTo(ChapmanAffiliates o){
  int retval = -2;
  if(m_entryYear == o.getEntryYear()){
    retval = 0;
  }
  else if(m_entryYear > o.getEntryYear()){
    retval = 1;
  }
  else{
    retval = -1;
  }
  return retval;
}

/** Method prints out the information of the Chapman Affiliate.
*/
public void print(){
  String s = "";
  s += "Name: " + m_name;
  s += ", Age: " + m_age;
  s += ", Address: " + m_address;
  s += ", Phone Number: " + m_phoneNumber;
  s += ", ID: " + m_id;
  s += ", Entry Year: " + m_entryYear;
  System.out.print(s);
}




}
