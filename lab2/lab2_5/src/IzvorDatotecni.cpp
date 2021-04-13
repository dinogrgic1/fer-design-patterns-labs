#include "IzvorDatotecni.hpp"

IzvorDatotecni::~IzvorDatotecni()
{
    file_.close();
}
IzvorDatotecni::IzvorDatotecni(std::string filepath)
{
    file_.open(filepath);
}

int IzvorDatotecni::read()
{
    std::string s;
    file_ >> s;
    return stoi(s);
}
