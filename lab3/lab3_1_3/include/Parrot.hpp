#include <string>

#include "Animal.hpp"
#include "Factory.hpp"

class Parrot : public Animal
{
private:
    const char* name_;
    static int hreg;
public:
    Parrot(char const *name);

    static void* myCreator(const std::string& arg);
};
