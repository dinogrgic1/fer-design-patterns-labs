#include <iostream>
#include <vector>
#include <fstream>
#include <chrono>
#include <thread>

#include "Observer.hpp"
#include "ObserverLog.hpp"
#include "ObserverSum.hpp"
#include "ObserverAvg.hpp"
#include "ObserverMedian.hpp"

#include "SlijedBrojeva.hpp"
#include "IzvorTipkovnicki.hpp"

int main(void)
{
    SlijedBrojeva *sb = new SlijedBrojeva(new IzvorTipkovnicki());
    
    ObserverLog *ol = new ObserverLog("log.txt");
    ObserverSum *os = new ObserverSum();
    ObserverAvg *oa = new ObserverAvg();
    ObserverMedian *om = new ObserverMedian();
    
    sb->attach(ol); sb->attach(os); sb->attach(oa); sb->attach(om);
    sb->kreni();
}