/*
This header file for the FileProcessor class which takes care of
getting input from a file and outputting info to a file
*/
#include <string>
#include <iostream>
#include <fstream>
using namespace std;

class FileProcessor{
public:
  FileProcessor();
  ~FileProcessor();
  void takeInFile(string inputFile);
  void outPutToFile(string outputFile, string gridInfo);
  int getRows();
  int getColumns();
  string getCellInfo();

private:
  int rows;
  int columns;
  int sizeCheck;
  string cellInfo;
};
