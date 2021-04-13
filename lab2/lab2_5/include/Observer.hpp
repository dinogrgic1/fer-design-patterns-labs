#ifndef OBSERVER_HPP
#define OBSERVER_HPP

#include <vector>

class Observer
{
public:
    virtual void update(std::vector<int>) = 0;
};
#endif