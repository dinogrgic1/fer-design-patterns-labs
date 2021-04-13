#ifndef OBSERVER_AVG_HPP
#define OBSERVER_AVG_HPP

#include "Observer.hpp"
#include <vector>

class ObserverAvg : public Observer
{
public:
    virtual void update(std::vector<int>);
};

#endif