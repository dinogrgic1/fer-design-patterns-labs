#include <fstream>

#ifndef OBSERVER_LOG_HPP
#define OBSERVER_LOG_HPP

#include "Observer.hpp"
#include "SlijedBrojeva.hpp"

class ObserverLog : public Observer
{
private:
    std::ofstream file_;
public:
    ObserverLog(std::string);
    virtual void update(std::vector<int>);
};

#endif