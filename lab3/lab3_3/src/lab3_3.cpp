#include <iostream>
#include <iomanip>
#include <memory>

void test_unique_ptr()
{
  std::cout << "==============Test unique_ptr started...==============" << std::endl;
  //  std::unique_ptr<int> p1 = std::unique_ptr<int>(new int(5)); //  C++11
  std::unique_ptr<int> p1 = std::make_unique<int>(5); // C++14
  //  compiler error: nije moguće preinicijalizirati unǉiue pointer na p2
  //  std::unique_ptr<int> p2 = p1;

  //  korištenjem std::move p1 se prebacuje na p2, p1 postaje nullptr
  std::unique_ptr<int> p2 = std::move(p1);

  //  ispisuje se p2 = 5
  std::cout << "Dereferencing p2 -- value is: " << *p2 << std::endl;

  //  dereferenciranje nullptr -- segfault
  //  std::cout << "Dereferencing p1 -- value is: " << *p1 << std::endl;
  //  na kraju bloka otpušta se memorija za unique_ptr, nije potrebno pisati free
}

void test_shared_ptr()
{
  std::cout << "==============Test shared_ptr and unique_ptr started...==============" << std::endl;
  //  std::shared_ptr<int> p1 = std::shared_ptr<int>(new int(5)); //  C++11
  std::shared_ptr<int> p1 = std::make_shared<int>(5); //  C++14
  std::shared_ptr<int> p2 = p1;

  std::cout << "Dereferencing p1 -- value is: " << *p1 << std::endl;
  std::cout << "Dereferencing p2 -- value is: " << *p2 << std::endl; // za razliku od unique_ptr vise pointera moze pokazivati istu memoriju

  std::weak_ptr<int> wp1;
  {
    std::shared_ptr<int> p3 = std::make_shared<int>(6);
    wp1 = std::weak_ptr<int>(p3);              //  kako bi se weak_ptr koristio mora se pretvoriti u shared pointer
    if (std::shared_ptr<int> spt = wp1.lock()) //  ako uz pomocu lock() funkcije ne mozemo stvoriti shared_ptr
      std::cout << "Dereferencing wp1 -- value is: " << *spt << std::endl;
    else
      std::cout << "Dereferencing wp1 -- wp1 has expired" << std::endl; //  pointer je istekao (tj. njegovi resursi su pusteni)
  }

  if (std::shared_ptr<int> spt = wp1.lock())
    std::cout << "Dereferencing wp1 -- value is: " << *spt << std::endl;
  else
    std::cout << "Dereferencing wp1 -- wp1 has expired" << std::endl; // zbog toga sto je p3 izvan bloka i otpusten je i weak_pointer je istekao
}

int main()
{
  test_unique_ptr();
  test_shared_ptr();
  return 0;
}