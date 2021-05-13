#include <iostream>
#include <vector>
#include <sstream>

#include "Animal.hpp"
#include "Factory.hpp"

void printGreeting(Animal obj)
{
  printf("%s pozdravlja: %s\n", obj.name(), obj.greet());
}

void printMenu(Animal obj)
{
  printf("%s voli %s\n", obj.name(), obj.menu());
}

int main(void)
{
  Factory &fact(Factory::instance());
  std::vector<std::string> vecIds = fact.getIds();
  for (int i = 0; i < vecIds.size(); ++i)
  {
    std::ostringstream oss;
    oss << "Ljubimac " << i;
    Animal *pa = (Animal *)fact.create(vecIds[i], oss.str());
    printGreeting(*pa);
    printMenu(*pa);
    delete pa;
  }
}