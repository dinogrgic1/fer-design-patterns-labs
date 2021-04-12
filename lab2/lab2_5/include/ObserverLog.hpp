#include <fstream>

#include "Observer.hpp"

class ObserverLog : public Observer
{
private:
    std::ofstream file_;
public:
    ObserverLog(std::string filepath);
    virtual void update();
};