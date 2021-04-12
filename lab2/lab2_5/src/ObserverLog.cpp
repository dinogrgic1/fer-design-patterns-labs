#include "ObserverLog.hpp"

ObserverLog::ObserverLog(std::string filepath)
{
    this->file_.open(filepath);
}

void ObserverLog::update()
{
    file_ << std::endl;
}
