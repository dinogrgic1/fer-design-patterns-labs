#include <fstream>

#ifndef IZVOR_DATOTETCNI_HPP
#define IZVOR_DATOTETCNI_HPP

#include "Izvor.hpp"

class IzvorDatotecni : public Izvor
{
private:
    std::ifstream file_;

public:
    ~IzvorDatotecni();
    IzvorDatotecni(std::string filepath);
    virtual int read();
};

#endif