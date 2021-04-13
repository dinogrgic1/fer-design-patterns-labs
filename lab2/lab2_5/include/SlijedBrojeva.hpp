#include <vector>
#include <thread>
#include <chrono>

#ifndef SLIJED_BROJEVA_HPP
#define SLIJED_BROJEVA_HPP

#include "Observer.hpp"
#include "Izvor.hpp"

class SlijedBrojeva
{
private:
    Izvor *izvor_;
    std::vector<Observer *> observers_;

public:
    std::vector<int> nums;
    SlijedBrojeva(Izvor *izvor) : izvor_(izvor) {}
    void kreni();

    void attach(Observer *obs);
    void notify();
    void dettach(Observer *obs);
};

#endif