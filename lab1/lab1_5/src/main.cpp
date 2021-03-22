#include <iostream>

class B
{
public:
  virtual int prva() = 0;
  virtual int druga(int) = 0;
};

class D : public B
{
public:
  virtual int prva() { return 42; }
  virtual int druga(int x) {  return prva() + x; }
};

void printVtable(B *pb)
{
  //int *vTable = *(int**)pb;
  //int *vTable = ((int**) pb)[0];
  using fun_ptr = int(*)(B*);
  using fun_ptr2 = int(*)(B*, int);

  fun_ptr *vTable = (fun_ptr*) ((fun_ptr*) pb)[0];
  fun_ptr2 *vTable2 = (fun_ptr2*) ((fun_ptr2*) pb)[0];
 
  int (*b_prva)(B*) = (fun_ptr) vTable[0];
  int (*b_druga)(B*, int) = (fun_ptr2) vTable2[1];
  
  std::cout << "Pozivam virtualnu funkciju prva: " << b_prva(pb) << std::endl;
  std::cout << "Pozivam virtualnu funkciju druga: " << b_druga(pb, 42) << std::endl;
}

int main()
{
  D *d = new D();
  printVtable(d); 
}