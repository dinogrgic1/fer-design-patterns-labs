#include <map>
#include <vector>
#include <string>

class Factory
{
public:
    typedef void *(*pFunCreator)(const std::string &);
    typedef std::map<std::string, pFunCreator> MyMap;

public:
    static Factory &instance();

public:
    int registerCreator(const std::string &id, pFunCreator pfn);

public:
    void *create(const std::string &id, const std::string &arg);
    std::vector<std::string> getIds();

private:
    Factory();
    ~Factory();
    Factory(const Factory &);
    MyMap creators_;
};
