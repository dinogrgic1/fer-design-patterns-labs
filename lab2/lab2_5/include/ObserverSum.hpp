#ifndef OBSERVER_SUM_HPP
#define OBSERVER_SUM_HPP

#include "Observer.hpp"
#include <vector>

class ObserverSum : public Observer
{
public:
    virtual void update(std::vector<int>);
};

#endif