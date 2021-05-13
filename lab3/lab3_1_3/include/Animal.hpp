#include "IAnimal.hpp"

class Animal : public IAnimal
{
private:
    const char *name_;
    const char *greet_;
    const char *menu_;

public:
    virtual char const *name();
    virtual char const *greet();
    virtual char const *menu();

protected:
    Animal(const char *name, const char *greet, const char *menu);
};
