/*
This implementation of Simulator header file, defines all functions and variables
*/

#include "Simulator.h"
#include "Populator.h"
#include "FileProcessor.h"
using namespace std;

/*
Simulator
Constructor for the Simulator Class
@param none
@return void
*/
Simulator::Simulator(){
  currGen =0;
  evaluateBriefPause = false;
  evaluateEnterPause = false;
}
/*
~Simulator
Deconstructor for the Simulator Class
@param none
@return void
*/
Simulator::~Simulator(){
  cout<<"Simulator Destroyed"<<endl;
}
/*
SimulateClassic
Function used for for simulatting classic mode,
grid populated randomly,
and outputted to console
@param int rows, int columns, float density
@return void
*/
// //
void Simulator::SimulateClassic(int rows, int columns, float density){
  Populator p(rows,columns,density);
  p.Randomize();
  bool isStable = false;
  while(isStable == false){
    cout<<"Generation is: " << currGen <<endl;
    p.PrintGrid();
    p.CopyGrid();
    p.NextGen();
    currGen++;
    isStable = p.CompareGrid();
    PauseGame();
  }
  cout << "Last Gen is: " << currGen << endl;
  p.PrintGrid();
  cout << "Stability Achieved" << endl;
}
/*
SimulateClassic
Function used for for simulatting classic mode,
grid populated by a file,
and outputted to console
@param int rows, int columns, string s
@return void
*/
void Simulator::SimulateClassic(int rows, int columns, string s){
  Populator p(rows,columns,s);
  bool isStable = false;

  while(isStable == false){
    cout<<"Generation is: " << currGen <<endl;
    p.PrintGrid();
    cout <<"---------------"<<endl;
    p.CopyGrid();
    p.NextGen();
    currGen++;
    isStable = p.CompareGrid();
    PauseGame();
  }
  cout << "Last Gen is: " << currGen << endl;
  p.PrintGrid();
  cout << "Stability Achieved" << endl;
}
/*
SimulateClassicToFile
Function used for for simulatting classic mode,
grid populated randomly
and outputted to a file
@param int rows, int columns, float density, string fileName
@return void
*/
void Simulator::SimulateClassicToFile(int rows, int columns, float density, string fileName){
  Populator p(rows,columns,density);
  FileProcessor f;
  p.Randomize();
  string temp = "";
  bool isStable = false;
  while(isStable == false){
    temp += "Generation is:" + to_string(currGen) + "\n";
    temp += p.returnGridString();
    p.CopyGrid();
    p.NextGen();
    currGen++;
    isStable = p.CompareGrid();
  }
  temp += "Last Gen is: " + to_string(currGen) + "\n";
  temp += p.returnGridString();
  temp += "\nStability Acheived";
  f.outPutToFile(fileName, temp);
}
/*
SimulateClassicToFile
Function used for for simulatting classic mode,
grid populated by a file input
and outputted to a file
@param int rows, int columns, string s, string fileName
@return void
*/
void Simulator::SimulateClassicToFile(int rows, int columns, string s, string fileName){
  Populator p(rows,columns,s);
  FileProcessor f;
  string temp = "";
  bool isStable = false;
  while(isStable == false){
    temp += "Generation is:" + to_string(currGen) + "\n";
    temp += p.returnGridString();
    p.CopyGrid();
    p.NextGen();
    currGen++;
    isStable = p.CompareGrid();
  }
  temp += "Last Gen is: " + to_string(currGen) + "\n";
  temp += p.returnGridString();
  temp += "\nStability Acheived";
  f.outPutToFile(fileName, temp);
}
/*
SimulateDonut
Function used for for simulatting donut mode,
grid populated randomly
and outputted to the console
@param int rows, int columns, float density
@return void
*/
void Simulator::SimulateDonut(int rows, int columns, float density){
  Populator p(rows,columns,density);
  p.Randomize();
  bool isStable = false;
  while(isStable == false){
    cout<<"Generation is: " << currGen <<endl;
    p.SetUpForDonutMode();
    p.PrintGrid();
    p.CopyWholeGrid();
    p.NextGen();
    currGen++;
    isStable = p.CompareGrid();
    PauseGame();
  }
  cout << "Last Gen is: " << currGen << endl;
  p.PrintGrid();
  cout << "Stability Achieved" << endl;
}
/*
SimulateDonut
Function used for for simulatting donut mode,
grid populated by a file
and outputted to the console
@param int rows, int columns, string s
@return void
*/
void Simulator::SimulateDonut(int rows, int columns, string s){
  Populator p(rows,columns,s);
  bool isStable = false;

  while(isStable == false){
    cout<<"Generation is: " << currGen <<endl;
    p.SetUpForDonutMode();
    p.PrintGrid();
    cout<<endl;
    p.CopyWholeGrid();
    p.NextGen();
    currGen++;
    isStable = p.CompareGrid();
    PauseGame();
  }
  cout << "Last Gen is: " << currGen << endl;
  p.PrintGrid();
  cout << "Stability Achieved" << endl;
}
/*
SimulateDonutToFile
Function used for for simulatting donut mode,
grid populated randomly
and outputted to a file
@param int rows, int columns, float density, string fileName
@return void
*/
void Simulator::SimulateDonutToFile(int rows, int columns, float density, string fileName){
  Populator p(rows,columns,density);
  FileProcessor f;
  p.Randomize();
  string temp = "";
  bool isStable = false;
  while(isStable == false){
    temp += "Generation is:" + to_string(currGen) + "\n";
    p.SetUpForDonutMode();
    temp += p.returnGridString();
    p.CopyWholeGrid();
    p.NextGen();
    currGen++;
    isStable = p.CompareGrid();
  }
  temp += "Last Gen is: " + to_string(currGen) + "\n";
  temp += p.returnGridString();
  temp += "\nStability Acheived";
  f.outPutToFile(fileName, temp);
}
/*
SimulateDonutToFile
Function used for for simulatting donut mode,
grid populated by a file
and outputted to a file
@param int rows, int columns, string s, string fileName
@return void
*/
void Simulator::SimulateDonutToFile(int rows, int columns, string s, string fileName){
  Populator p(rows,columns,s);
  FileProcessor f;
  string temp = "";
  bool isStable = false;
  while(isStable == false){
    temp += "Generation is:" + to_string(currGen) + "\n";
    p.SetUpForDonutMode();
    temp += p.returnGridString();
    p.CopyWholeGrid();
    p.NextGen();
    currGen++;
    isStable = p.CompareGrid();
  }
  temp += "Last Gen is: " + to_string(currGen) + "\n";
  temp += p.returnGridString();
  temp += "\nStability Acheived";
  f.outPutToFile(fileName, temp);
}
/*
SimulateMirror
Function used for for simulatting mirror mode,
grid populated randomly
and outputted to console
@param int rows, int columns, float density
@return void
*/
void Simulator::SimulateMirror(int rows, int columns, float density){
  Populator p(rows,columns,density);
  p.Randomize();
  bool isStable = false;
  while(isStable == false){
    cout<<"Generation is: " << currGen <<endl;
    p.SetUpForMirrorMode();
    p.PrintGrid();
    p.CopyWholeGrid();
    p.NextGen();
    currGen++;
    isStable = p.CompareGrid();
    PauseGame();
  }
  cout << "Last Gen is: " << currGen << endl;
  p.PrintGrid();
  cout << "Stability Achieved" << endl;
}
/*
SimulateMirror
Function used for for simulatting mirror mode,
grid populated from a file
and outputted to console
@param int rows, int columns, string s
@return void
*/
void Simulator::SimulateMirror(int rows, int columns, string s){
  Populator p(rows,columns,s);
  bool isStable = false;
  while(isStable == false){
    cout<<"Generation is: " << currGen <<endl;
    p.SetUpForMirrorMode();
    p.PrintGrid();
    cout<<endl;
    p.CopyWholeGrid();
    p.NextGen();
    currGen++;
    isStable = p.CompareGrid();
    PauseGame();
  }
  cout << "Last Gen is: " << currGen << endl;
  p.PrintGrid();
  cout << "Stability Achieved" << endl;
}
/*
SimulateMirrorToFile
Function used for for simulatting mirror mode,
grid populated randomly
and outputted to a file
@param int rows, int columns, float density, string fileName
@return void
*/
void Simulator::SimulateMirrorToFile(int rows, int columns, float density, string fileName){
  Populator p(rows,columns,density);
  FileProcessor f;
  p.Randomize();
  string temp = "";
  bool isStable = false;
  while(isStable == false){
    temp += "Generation is:" + to_string(currGen) + "\n";
    p.SetUpForMirrorMode();
    temp += p.returnGridString();
    p.CopyWholeGrid();
    p.NextGen();
    currGen++;
    isStable = p.CompareGrid();
  }
  temp += "Last Gen is: " + to_string(currGen) + "\n";
  temp += p.returnGridString();
  temp += "\nStability Acheived";
  f.outPutToFile(fileName, temp);
}
/*
SimulateMirrorToFile
Function used for for simulatting mirror mode,
grid populated from a file
and outputted to a file
@param int rows, int columns, string s, string fileName
@return void
*/
void Simulator::SimulateMirrorToFile(int rows, int columns, string s, string fileName){
  Populator p(rows,columns,s);
  FileProcessor f;
  string temp = "";
  bool isStable = false;
  while(isStable == false){
    temp += "Generation is:" + to_string(currGen) + "\n";
    p.SetUpForMirrorMode();
    temp += p.returnGridString();
    p.CopyWholeGrid();
    p.NextGen();
    currGen++;
    isStable = p.CompareGrid();
  }
  temp += "Last Gen is: " + to_string(currGen) + "\n";
  temp += p.returnGridString();
  temp += "\nStability Acheived";
  f.outPutToFile(fileName, temp);
}

/*
PauseGame()
Function is used to either implement brief pauses
or pauses until user input
@param none
@return void
*/
void Simulator::PauseGame(){
  if(evaluateBriefPause == true){
    this_thread::sleep_for(chrono::seconds(1));
  }
  else if(evaluateEnterPause == true){
    cout << "To continue, press *Enter*" << endl;
    getchar();
  }
}
/*
SetEvaluateBriefPauseTrue()
Function sets evaluateBriefPause to true
@param none
@return void
*/
void Simulator::SetEvaluateBriefPauseTrue(){
  evaluateBriefPause = true;
}
/*
SetEvaluateEnterPauseTrue()
Function sets evaluateEnterPause to true
@param none
@return void
*/
void Simulator::SetEvaluateEnterPauseTrue(){
  evaluateEnterPause = true;
}
