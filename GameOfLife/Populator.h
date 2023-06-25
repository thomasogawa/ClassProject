/*
This header file for the Populator class which takes care of a lot of
the grid functionality ex. populating and comparing grids
*/
#include <iostream>
#include <random>
using namespace std;

class Populator{

public:
  Populator();
  Populator(int rows, int columns, float density);
  Populator(int rows, int columns, string s);
  ~Populator();
  void Randomize();
  void CopyGrid();
  void CopyWholeGrid();
  void NextGen();
  void SetUpForDonutMode();
  void SetUpForMirrorMode();
  void PrintGrid();
  void PrintWholeGrid();
  void PrintTempGrid();
  void PrintWholeTempGrid();
  void LemmeSeeShit();
  bool CompareGrid();
  string returnGridString();

private:
  char** grid;
  char** gridTemp;
  int rows;
  int columns;
  float density;
};
