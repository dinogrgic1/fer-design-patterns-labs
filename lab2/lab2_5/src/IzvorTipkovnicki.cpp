#include <fstream>
#include <iostream>

#include "IzvorTipkovnicki.hpp"

int IzvorTipkovnicki::read()
{
    std::string s;
    std::cin >> s;
    return stoi(s);
}
