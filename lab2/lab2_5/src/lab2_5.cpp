#include <iostream>
#include <vector>
#include <fstream>
#include <chrono>
#include <thread>

#include "Observer.hpp"
#include "ObserverLog.hpp"

class Izvor
{
public:
    virtual int read() = 0;
};

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


class TipkovnickiIzvor : public Izvor
{
public:
    virtual int read()
    {
        std::string s;
        std::cin >> s;
        return stoi(s);
    }
};

class DatotecniIzvor : public Izvor
{
private:
    std::ifstream file_;
public:
    ~DatotecniIzvor() 
    {
        file_.close();
    }
    DatotecniIzvor(std::string filepath) : file_(filepath) { }
    virtual int read()
    {
        std::string s;
        file_ >> s;
        return stoi(s);
    }
};

int main(void)
{
    SlijedBrojeva *sb = new SlijedBrojeva(new TipkovnickiIzvor());
    ObserverLog *ob = new ObserverLog("log.txt");
    
    sb->attach(ob);
    sb->kreni();
}