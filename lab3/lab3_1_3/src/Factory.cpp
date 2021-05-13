#include "Factory.hpp"

#include <utility>
#include <iostream>

Factory::Factory() { }

// TODO(Dino): Fix destructor
Factory::~Factory() { }

Factory::Factory(const Factory &factory)
{
    factory.instance();
}

Factory &Factory::instance()
{
    static Factory theFactory;
    return theFactory;
}

int Factory::registerCreator(const std::string &id, pFunCreator pfn)
{
    std::pair<std::string, pFunCreator> tmp;
    tmp = std::make_pair(id, pfn);
    creators_.insert(tmp);
    return creators_.size();
}

void *Factory::create(const std::string &id, const std::string &arg)
{
    return creators_.at(id)(arg);
}

std::vector<std::string> Factory::getIds()
{
    std::vector<std::string> tmp;
    for (std::map<std::string, pFunCreator>::iterator it = creators_.begin(); it != creators_.end(); ++it)
    {
        tmp.push_back(it->first);
    }
    return tmp;
}