#include <iostream>
#include <vector>
#include <fstream>
#include <chrono>
#include <thread>

class Izvor
{
public:
    virtual int read() = 0;
};

class SlijedBrojeva
{
private:
    Izvor* izvor_;
    std::vector<int> nums_;
public:
    SlijedBrojeva(Izvor *izvor) : izvor_(izvor) {}
    void kreni() 
    {
        int r = 0;
        for(;;)
        {
            r = this->izvor_->read();

            if(r == -1)
                break;

            this->nums_.push_back(r);
            // observer notify
            std::this_thread::sleep_for(std::chrono::seconds(1));
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
    sb->kreni();
}