#include <iostream>

class B
{
public:
  virtual int __cdecl prva() = 0;
  virtual int __cdecl druga(int) = 0;
};

class D : public B
{
public:
  virtual int __cdecl prva() { return 42; }
  //virtual int __cdecl druga(int x) { return prva() + x; }
  virtual int __cdecl druga(int x) { return prva() + x; }
};

void printVtable(B *pb)
{
  //int *vTable = *(int**)pb;
  //int *vTable = ((int**) pb)[0];
  using fun_ptr = int(*)(int);

  fun_ptr *vTable = (fun_ptr*) ((fun_ptr*) pb)[0];
 
  int (*b_prva)() = (int (*)()) vTable[0];
  int (*b_druga)(int) = (int (*)(int)) vTable[1];
  
  std::cout << "Pozivam virtualnu funkciju prva: " << b_prva() << std::endl;
  std::cout << "Pozivam virtualnu funkciju druga: " << b_druga(42) << std::endl;
}

int main()
{
  D *d = new D();
  printVtable(d); 
}