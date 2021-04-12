#include <iostream>
#include <vector>
#include <fstream>

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
        int r = this->izvor_->read();
        while(r != -1)
        {
            this->nums_.push_back(r);
            r = this->izvor_->read();
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