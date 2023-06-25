/*
This implementation of FileProcessor header file, defines all functions and variables
*/

#include "FileProcessor.h"
#include "Simulator.h"
#include "Populator.h"
using namespace std;

/*
FileProcessor
Constructor for the FileProcessor Class
@param none
@return void
*/
FileProcessor :: FileProcessor(){
  rows = 0;
  columns = 0;
  sizeCheck = 0;
  cellInfo = "";
}

/*
FileProcessor
Destructor for the FileProcessor Class
@param none
@return void
*/
FileProcessor :: ~FileProcessor(){
  cout << "File Processor Destroyed" <<endl;
}

/*
takeInFile
Function takes in a string for input file and Sets
relevant object variables
@param string inputFile
@return void
*/
void FileProcessor :: takeInFile(string inputFile){

  ifstream inFile;
  string line;
  inFile.open(inputFile);

  getline(inFile,line);
  rows = stoi(line);
  getline(inFile,line);
  columns = stoi(line);
  //Reads through each line of the file and outputs to output text file
  while(getline(inFile,line)){
    cellInfo += line;
  }
  inFile.close();
}
/*
outPutToFile
Function outputs a string to a file
It also spells the word output funny
@param string outputFile, string gridInfo
@return void
*/
void FileProcessor::outPutToFile(string outputFile, string gridInfo){
  ofstream outFile;
  outFile.open(outputFile, ios::out | ios::app);
  outFile << gridInfo << endl;
  outFile.close();
}
/*
getRows
Function returns number of rows as an int
@param none
@return int
*/
int FileProcessor::getRows(){
  return rows;
}
/*
getColumns
Function returns number of columns as an int
@param none
@return int
*/
int FileProcessor::getColumns(){
  return columns;
}
/*
getCellInfo
Function returns a string, of the grid
@param none
@return string
*/
string FileProcessor::getCellInfo(){
  return cellInfo;
}
