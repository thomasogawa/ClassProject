/*
This header file for the Simulator class, which is responsible for
simulating the game of life given different modes and
user preferences
*/
#include<string>
#include<chrono>
#include<thread>
using namespace std;
class Simulator{
public:
  Simulator();
  ~Simulator();
  void SimulateClassic(int rows, int columns, float density);
  void SimulateClassic(int rows, int columns, string s);
  void SimulateClassicToFile(int rows, int columns, float density, string fileName);
  void SimulateClassicToFile(int rows, int columns, string s, string fileName);

  void SimulateDonut(int rows, int columns, float density);
  void SimulateDonut(int rows, int columns, string s);
  void SimulateDonutToFile(int rows, int columns, float density, string fileName);
  void SimulateDonutToFile(int rows, int columns, string s, string fileName);

  void SimulateMirror(int rows, int columns, float density);
  void SimulateMirror(int rows, int columns, string s);
  void SimulateMirrorToFile(int rows, int columns, float density, string fileName);
    void SimulateMirrorToFile(int rows, int columns, string s, string fileName);

  void PauseGame();
  void SetEvaluateBriefPauseTrue();
  void SetEvaluateEnterPauseTrue();

private:
  int currGen;
  bool evaluateBriefPause;
  bool evaluateEnterPause;
};
