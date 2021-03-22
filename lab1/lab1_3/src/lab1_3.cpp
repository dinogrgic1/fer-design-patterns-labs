#include <iostream>

class CoolClass
{
public:
    virtual void set(int x) { x_ = x; };
    virtual int get() { return x_; };
private:
    int x_;
};

class PlainOldClass
{
public:
    void set(int x) { x_ = x; };
    int get() { return x_; };

private:
    int x_;
};

int main()
{
    std::cout << "CoolClass size: " << sizeof(CoolClass) << " bytes" << std::endl;
    std::cout << "PlainOldClass size: " << sizeof(PlainOldClass) << " bytes" << std::endl;
}