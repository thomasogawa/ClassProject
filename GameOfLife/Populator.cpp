/*
This implementation of Populator header file, defines all functions and variables
*/

#include "Populator.h"
using namespace std;

Populator::Populator(){
  cout << "Populator Constructed" << endl;
}

/*
Populator
Constructor for the Populator Class
@param int rows, int columns, float density
@return void
*/
Populator::Populator(int rows, int columns, float density){
  this->rows = rows;
  this->columns = columns;
  this->density = density;

  grid = new char*[rows + 2];
  for(int i = 0; i < rows + 2; i++){
    grid[i] = new char[columns + 2];
  }

  gridTemp = new char*[rows + 2];
  for(int i = 0; i < rows + 2; i++){
    gridTemp[i] = new char[columns + 2];
  }
}

/*
Populator
Overloaded Constructor for the Populator Class for file input
@param int rows, int columns, string s
@return void
*/
Populator::Populator(int rows, int columns, string s){
  this->rows = rows;
  this->columns = columns;

  grid = new char*[rows + 2];
  for(int i = 0; i < rows + 2; i++){
    grid[i] = new char[columns + 2];
  }

  gridTemp = new char*[rows + 2];
  for(int i = 0; i < rows + 2; i++){
    gridTemp[i] = new char[columns + 2];
  }

  for(int i = 0; i < rows + 2; i++){
    for(int j = 0; j < columns + 2; j++){
      grid[i][j] = '0';
    }
  }

  int strCnt = 0;
  for(int f = 1; f <= rows; f++){
    for(int k = 1; k <= columns; k++){
      grid[f][k] = s[strCnt];
      strCnt++;
    }
  }
}

/*
~Populator
Destructor for the Populator Class
@param none
@return void
*/
Populator::~Populator(){
  cout << "Populator Destroyed" << endl;
}

/*
Randomize
Function randomly fills in grid visible to user
@param none
@return void
*/
void Populator::Randomize(){
  srand(time (NULL));//like minecraft to get new random each time
  for(int i = 1; i <= rows; i++){
    for(int j = 1; j <= columns; j++){
      int randomNum = (rand() % 100) + 1;
      // cout << randomNum << endl;
      if(randomNum < (density*100))
      grid[i][j] = 'x';
      else
      grid[i][j] = '-';
    }
  }
}

/*
CopyGrid
Function copies the grid to a temporary grid,
only par of grid visible to user
@param none
@return void
*/
void Populator::CopyGrid(){
  for(int i = 1; i <= rows; i++){
    for(int j = 1; j <= columns; j++){
      gridTemp[i][j] = grid[i][j];
    }
  }
}

/*
CopyWholeGrid
Function copies the whole grid to a temporary grid,
including outer edge not visible to user
@param none
@return void
*/
void Populator::CopyWholeGrid(){
  for(int i = 0; i < rows + 2; i++){
    for(int j = 0; j < columns + 2; j++){
      gridTemp[i][j] = grid[i][j];
    }
  }
}

/*
NextGen
Function looks at copied temporary grid and makes
changes to the original grid based upon game
of life rules
@param none
@return void
*/
void Populator::NextGen(){
  for(int i = 1; i <= rows; i++){
    for(int j = 1; j <= columns; j++){
      int neighborsCnt = 0;
      if(gridTemp[i+1][j] == 'x'){
        neighborsCnt++;
      }
      if(gridTemp[i][j+1] == 'x'){
        neighborsCnt++;
      }
      if(gridTemp[i+1][j+1] == 'x'){
        neighborsCnt++;
      }
      if(gridTemp[i-1][j] == 'x'){
        neighborsCnt++;
      }
      if(gridTemp[i][j-1] == 'x'){
        neighborsCnt++;
      }
      if(gridTemp[i-1][j+1] == 'x'){
        neighborsCnt++;
      }
      if(gridTemp[i+1][j-1] == 'x'){
        neighborsCnt++;
      }
      if(gridTemp[i-1][j-1] == 'x'){
        neighborsCnt++;
      }
      if((neighborsCnt <= 1) && (gridTemp[i][j] == 'x')){
        grid[i][j] = '-';
      }
      else if((4 <= neighborsCnt) && (gridTemp[i][j] == 'x')){
        grid[i][j] = '-';
      }
      else if((neighborsCnt == 3) && (gridTemp[i][j] == '-')){
        grid[i][j] = 'x';
      }
    }
  }
}

/*
SetUpForDonutMode
Function sets up the grid for "donut" game mode
basically fills in outer edges accordingly
to follow "donut" game mode rules
of life rules
@param none
@return void
*/
void Populator::SetUpForDonutMode(){
  for(int i = 0; i < rows + 2; i++){
    for(int j = 0; j < columns + 2; j++){
      //top-left corner
      if(i == 0 && j == 0){
        grid[i][j] = grid[rows][columns];
      }
      //top right corner
      if(i == 0 && j == columns + 1){
        grid[i][j] = grid[rows][1];
      }
      //bottom left corner
      if(i == rows + 1 && j == 0){
        grid[i][j] = grid[1][columns];
      }
      //bottom right corner
      if(i == rows + 1 && j == columns + 1){
        grid[i][j] = grid[1][1];
      }
      //top row
      if(i == 0 && (j!=0) && (j!=columns+1)){
        grid[i][j] = grid[rows][j];
      }
      //bottom row
      if(i == rows+1 && (j!=0) && (j!=columns+1)){
        grid[i][j] = grid[1][j];
      }
      //left column
      if(j == 0 && (i!=0) && (i!=rows+1)){
        grid[i][j] = grid[i][columns];
      }
      //right column
      if(j == columns + 1 && (i!=0) && (i!=rows+1)){
        grid[i][j] = grid[i][1];

      }
    }
  }
}

/*
SetUpForMirrorMode
Function sets up the grid for "Mirror" game mode
basically fills in outer edges accordingly
to follow "donut" game mode rules
of life rules
@param none
@return void
*/
void Populator::SetUpForMirrorMode(){
  for(int i = 0; i < rows + 2; i++){
    for(int j = 0; j < columns + 2; j++){
      //top-left corner
      if(i == 0 && j == 0){
        grid[i][j] = grid[1][1];
      }
      //top right corner
      if(i == 0 && j == columns + 1){
        grid[i][j] = grid[1][columns];
      }
      //bottom left corner
      if(i == rows + 1 && j == 0){
        grid[i][j] = grid[rows][1];
      }
      //bottom right corner
      if(i == rows + 1 && j == columns + 1){
        grid[i][j] = grid[rows][columns];
      }
      //top row
      if(i == 0 && (j!=0) && (j!=columns+1)){
        grid[i][j] = grid[1][j];
      }
      //bottom row
      if(i == rows+1 && (j!=0) && (j!=columns+1)){
        grid[i][j] = grid[rows][j];
      }
      //left column
      if(j == 0 && (i!=0) && (i!=rows+1)){
        grid[i][j] = grid[i][1];
      }
      //right column
      if(j == columns + 1 && (i!=0) && (i!=rows+1)){
        grid[i][j] = grid[i][columns];
      }
    }
  }
}
/*
PrintGrid
Function prints out grid visible to user
@param none
@return void
*/
void Populator::PrintGrid(){
  for(int i = 1; i <= rows; i++){
    for(int j = 1; j <= columns; j++){
      cout << grid[i][j];
    }
    cout << endl;
  }
}
/*
PrintWholeGrid
Function prints out the whole grid including edges not visible to user
@param none
@return void
*/
void Populator::PrintWholeGrid(){
  for(int i = 0; i < rows + 2; i++){
    for(int j = 0; j < columns + 2; j++){
      cout << grid[i][j];
    }
    cout << endl;
  }
}
/*
PrintGrid
Function prints out temp grid visible to user
Used mainly for testing
@param none
@return void
*/
void Populator::PrintTempGrid(){
  for(int i = 1; i <= rows; i++){
    for(int j = 1; j <= columns; j++){
      cout << gridTemp[i][j];
    }
    cout << endl;
  }
}
/*
PrintWholeTempGrid
Function prints out the whole grid including edges not visible to user
Mainly used for testing
@param none
@return void
*/
void Populator::PrintWholeTempGrid(){
  for(int i = 0; i < rows + 2; i++){
    for(int j = 0; j < columns + 2; j++){
      cout << gridTemp[i][j];
    }
    cout << endl;
  }
}

/*
LemmeSeeShit
Function enables the developer to better visualize grid
by filling the whole gride w/'0's
@param none
@return void
*/
void Populator::LemmeSeeShit(){
  for(int i = 0; i < rows + 2; i++){
    for(int j = 0; j < columns + 2; j++){
      grid[i][j] = '0';
    }
  }
}

/*
CompareGrid
Function compares two grids and returns true if
grids are the same and false if they are different
@param none
@return bool
*/
bool Populator::CompareGrid(){
  bool isSame = true;
  for(int i = 1; i <= rows; i++){
    for(int j = 1; j <= columns; j++){
      if(gridTemp[i][j] != grid[i][j])
      isSame = false;
    }
  }
  return isSame;
}
/*
returnGridString
Function returns the grid in string form
@param none
@return string
*/
string Populator::returnGridString(){
  string gridStr = "";
  for(int i = 1; i <= rows; i++){
    for(int j = 1; j <= columns; j++){
      gridStr = gridStr + grid[i][j];
    }
    gridStr = gridStr + "\n";
  }
  return gridStr;
}
