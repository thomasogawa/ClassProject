/*
This implementation of UserInput header file, defines all functions and variables
*/
#include "UserInput.h"
#include "FileProcessor.h"
#include "Simulator.h"
using namespace std;
/*
UserInput
Constructor for the UserInput Class
@param none
@return void
*/
UserInput::UserInput(){
  configuration = 0;
  gameMode = 0;
  outputSelect = 0;
  rows = 0;
  columns = 0;
  density = 0.0;
}
/*
~UserInput
Constructor for the UserInput Class
@param none
@return void
*/
UserInput::~UserInput(){
  cout << "UserInput Destroyed" << endl;
}
/*
getConfig
Function gets game configuration from user
@param none
@return void
*/
void UserInput::getConfig(){
  while(true){
    string input;
    cout << "Select a Game Mode Configuration!" << endl;
    cout << "Enter '1' for random configuration or '2' for flat file configuration: ";
    getline(cin,input);
    stringstream strm(input);
    strm >> configuration;
    if(strm.fail())
      cout << "Incorrect input, Please Enter an '1' or '2'\n";
    else if(2 < configuration || configuration < 1){
      cout << "Incorrect input, Please Enter an '1' or '2'\n";
    }
    else
      break;
  }
  cout <<"Configuration is: " << configuration<<endl;
}
/*
getGameMode
Function gets game mode from user
@param none
@return void
*/
void UserInput::getGameMode(){
  while(true){
    string input;
    cout << "Select a Game Mode Configuration!" << endl;
    cout << "Enter '1' for Classic-Mode, '2' for Donut-Mode, '3' for Mirror mode: ";
    getline(cin,input);
    stringstream strm(input);
    strm >> gameMode;
    if(strm.fail())
      cout << "Incorrect input, Please Enter an '1', '2', or '3'\n";
    else if(3 < gameMode || gameMode < 1){
      cout << "Incorrect input, Please Enter an '1', '2', or '3'\n";
    }
    else
      break;
  }
  cout <<"Game Mode is: " << gameMode <<endl;
}
/*
getOutputSelect
Function gets output selection from user ex. to a file
or brief pauses between generations
@param none
@return void
*/
void UserInput::getOutputSelect(){
  while(true){
    string input;
    cout << "Select a Output Configuration!" << endl;
    cout << "Enter '1' for a brief pause between generations " << endl;
    cout << "Enter '2' for ability to press 'Enter' to move to next gen" << endl;
    cout << "Enter '3' to output generations to a file" << endl;
    getline(cin,input);
    stringstream strm(input);
    strm >> outputSelect;
    if(strm.fail())
      cout << "Incorrect input, Please Enter an '1', '2', or '3'\n";
    else if(3 < outputSelect || outputSelect < 1){
      cout << "Incorrect input, Please Enter an '1', '2', or '3'\n";
    }
    else
      break;
  }
  cout <<"outputSelect is: " << outputSelect <<endl;
}
/*
getParametersRandomMode
Function gets parameters selection from user such as "number of rows"
@param none
@return void
*/
void UserInput::getParametersRandomMode(){
  while(true){
    string input;
    cout << "Enter number of rows: ";
    getline(cin,input);
    stringstream strm(input);
    strm >> rows;
    if(strm.fail())
      cout << "Incorrect input, Please Enter an integer \n";
    else
      break;
  }
  while(true){
    string input;
    cout << "Enter number of columns: ";
    getline(cin,input);
    stringstream strm(input);
    strm >> columns;
    if(strm.fail())
      cout << "Incorrect input, Please Enter an integer \n";
    else
      break;
  }
  while(true){
    string input;
    cout << "Enter randomized density as a decimal (ex. '0.4'): ";
    getline(cin,input);
    stringstream strm(input);
    strm >> density;
    if(strm.fail())
      cout << "Incorrect input, Please Enter a valid density \n";
    else
      break;
  }
}
/*
getInputFileNames
Function gets name of input file from user
@param none
@return void
*/
void UserInput::getInputFileNames(){

  while(true){
    string input;
    cout << "Enter file name to input to (ex. input.txt): ";
    getline(cin,input);
    stringstream strm(input);
    strm >> inputFile;
    if(strm.fail())
      cout << "Incorrect input, Please Enter a valid filename \n";
    else
      break;
  }
}
/*
getOutputFileNames
Function gets name of output file from user
@param none
@return void
*/
void UserInput::getOutputFileNames(){
  while(true){
    string input;
    cout << "Enter file name to output to (ex. output.txt): ";
    getline(cin,input);
    stringstream strm(input);
    strm >> outputFile;
    if(strm.fail())
      cout << "Incorrect input, Please Enter a valid filename \n";
    else
      break;
  }
}
/*
runSimulation
Function runs the simulation by prompting user for info and then
makes decisions accordingly allowing user to a select and run
through a variety of EXCITING AND INTERACTIVE GAME MODES...not
@param none
@return void
*/
void UserInput::runSimulation(){
  UserInput u;
  Simulator s;
  u.getConfig();
  u.getGameMode();
  if(u.configuration == 1){
    u.getParametersRandomMode();
    u.getOutputSelect();

    if(u.gameMode == 1){
      cout << "Playing Classic Mode" << endl;
      if(u.outputSelect == 1){
        s.SetEvaluateBriefPauseTrue();
        s.SimulateClassic(u.rows, u.columns, u.density);
      }
      if(u.outputSelect == 2){
        s.SetEvaluateEnterPauseTrue();
        s.SimulateClassic(u.rows, u.columns, u.density);
      }
      if(u.outputSelect == 3){
        u.getOutputFileNames();
        cout<<u.outputFile<<endl;
        s.SimulateClassicToFile(u.rows, u.columns, u.density, u.outputFile);
      }
    }
    else if(u.gameMode == 2){
      cout << "Playing Donut Mode" << endl;
      if(u.outputSelect == 1){
        s.SetEvaluateBriefPauseTrue();
        s.SimulateDonut(u.rows, u.columns, u.density);
      }
      if(u.outputSelect == 2){
        s.SetEvaluateEnterPauseTrue();
        s.SimulateDonut(u.rows, u.columns, u.density);
      }
      if(u.outputSelect == 3){
        u.getOutputFileNames();
        cout<<u.outputFile<<endl;
        s.SimulateDonutToFile(u.rows, u.columns, u.density, u.outputFile);
      }
    }
    else if(u.gameMode == 3){
      cout << "Playing Mirror Mode" << endl;
      cout << "Playing Donut Mode" << endl;
      if(u.outputSelect == 1){
        s.SetEvaluateBriefPauseTrue();
        s.SimulateMirror(u.rows, u.columns, u.density);
      }
      if(u.outputSelect == 2){
        s.SetEvaluateEnterPauseTrue();
        s.SimulateMirror(u.rows, u.columns, u.density);
      }
      if(u.outputSelect == 3){
        u.getOutputFileNames();
        cout<<u.outputFile<<endl;
        s.SimulateMirrorToFile(u.rows, u.columns, u.density, u.outputFile);
      }
    }
  }

  else if(u.configuration == 2){
    u.getInputFileNames();
    u.getOutputSelect();
    FileProcessor f;
    f.takeInFile(u.inputFile);

    if(u.gameMode == 1){
      cout << "Playing Classic Mode" << endl;
      if(u.outputSelect == 1){
        s.SetEvaluateBriefPauseTrue();
        s.SimulateClassic(f.getRows(), f.getColumns(), f.getCellInfo());
      }
      if(u.outputSelect == 2){
        s.SetEvaluateEnterPauseTrue();
        s.SimulateClassic(f.getRows(), f.getColumns(), f.getCellInfo());
      }
      if(u.outputSelect == 3){
        u.getOutputFileNames();
        s.SimulateClassicToFile(f.getRows(), f.getColumns(), f.getCellInfo(), u.outputFile);
      }
    }
    else if(u.gameMode == 2){
      cout << "Playing Donut Mode" << endl;
      if(u.outputSelect == 1){
        s.SetEvaluateBriefPauseTrue();
        s.SimulateDonut(f.getRows(), f.getColumns(), f.getCellInfo());
      }
      if(u.outputSelect == 2){
        s.SetEvaluateEnterPauseTrue();
        s.SimulateDonut(f.getRows(), f.getColumns(), f.getCellInfo());
      }
      if(u.outputSelect == 3){
        u.getOutputFileNames();
        s.SimulateDonutToFile(f.getRows(), f.getColumns(), f.getCellInfo(), u.outputFile);
      }
    }
    else if(u.gameMode == 3){
      cout << "Playing Mirror Mode" << endl;
        if(u.outputSelect == 1){
          s.SetEvaluateBriefPauseTrue();
          s.SimulateMirror(f.getRows(), f.getColumns(), f.getCellInfo());
        }
        if(u.outputSelect == 2){
          s.SetEvaluateEnterPauseTrue();
          s.SimulateMirror(f.getRows(), f.getColumns(), f.getCellInfo());
        }
        if(u.outputSelect == 3){
          u.getOutputFileNames();
          s.SimulateMirrorToFile(f.getRows(), f.getColumns(), f.getCellInfo(), u.outputFile);
        }
      }
    }
  }
/*
endSimulation
Function Prompts for user input and ends simulation
@param none
@return void
*/
void UserInput::endSimulation(){
  cout << "Press *ENTER* to exit the simulation:" << endl;
  getchar();
  exit(1);
}
