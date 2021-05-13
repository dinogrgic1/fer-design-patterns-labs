#include <string>

#include "Animal.hpp"
#include "Factory.hpp"

class Tiger : public Animal
{
private:
    const char* name_;
    static int hreg;
public:
    Tiger(char const *name);

    static void* myCreator(const std::string& arg);
};
