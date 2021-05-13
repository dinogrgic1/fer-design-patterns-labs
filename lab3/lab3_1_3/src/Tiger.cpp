#include "Tiger.hpp"

#include <iostream>

Tiger::Tiger(char const *name) : Animal(name, "meso", "raaaawr!") {}

void* Tiger::myCreator(const std::string& arg)
{
    return new Tiger(arg.c_str());
}

int Tiger::hreg = Factory::instance().registerCreator("tiger", myCreator);