#include "Parrot.hpp"

#include <iostream>

Parrot::Parrot(char const *name) : Animal(name, "sjemneke", "prrr!") {}

void* Parrot::myCreator(const std::string& arg)
{
    return new Parrot(arg.c_str());
}

int Parrot::hreg = Factory::instance().registerCreator("parrot", myCreator);
