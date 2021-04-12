#include <vector>
#include <thread>
#include <chrono>

#include "Izvor.hpp"
#include "Observer.hpp"

class SlijedBrojeva
{
private:
    Izvor* izvor_;
    std::vector<Observer *> observers_;
public:
    std::vector<int> nums;
    SlijedBrojeva(Izvor *izvor) : izvor_(izvor) {}
    void kreni() 
    {
        int r = 0;
        for(;;)
        {
            r = this->izvor_->read();

            if(r == -1)
                break;

            this->nums.push_back(r);
            notify();
            std::this_thread::sleep_for(std::chrono::seconds(1));
        }
    }

    void attach(Observer *obs)
    {
        observers_.push_back(obs);
    }

    void notify()
    {
        for(int i = 0; i < observers_.size(); i++)
        {
            observers_[i]->update();
        }
    }

    void dettach(Observer *obs)
    {
        for(int i = 0; i < observers_.size(); i++)
        {
            if(observers_[i] == obs)
            {
                observers_.erase(observers_.begin() + i);
                break;
            }
        }
    }
};
