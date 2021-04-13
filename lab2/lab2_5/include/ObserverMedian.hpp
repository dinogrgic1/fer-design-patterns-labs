#ifndef OBSERVER_MEDIAN_HPP
#define OBSERVER_MEDIAN_HPP

#include "Observer.hpp"
#include <vector>

class ObserverMedian : public Observer
{
public:
    virtual void update(std::vector<int>);
};

#endif