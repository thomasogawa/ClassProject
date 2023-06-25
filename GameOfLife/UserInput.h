/*
This header file for the UserInput class which takes care of getting user input
and ultimately connecting all elements of the program
*/
#include<iostream>
#include<sstream>
using namespace std;

class UserInput{
public:
  UserInput();
  ~UserInput();
  void getConfig();
  void getGameMode();
  void getOutputSelect();
  void getParametersRandomMode();
  void getInputFileNames();
  void getOutputFileNames();
  void runSimulation();
  void endSimulation();
private:
int configuration;
int gameMode;
int outputSelect;
int rows;
int columns;
float density;
string inputFile;
string outputFile;
};
