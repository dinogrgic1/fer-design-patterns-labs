#include <stdlib.h>
#include <stdio.h>

typedef char const *(*PTRFUN)();

#pragma region Animal
typedef struct Animal
{
    PTRFUN *pfun;
    char const *name;
} Animal;

#pragma endregion Animal

#pragma region Parrot
char const *name(Animal *obj)
{
    return obj->name;
}

char const *greet(void)
{
    return "prrr!";
}

char const *menu(void)
{
    return "sjemeneke";
}

size_t size()
{
    return sizeof(Animal);
}

PTRFUN vtableParrot[3] = {name, greet, menu};
Animal *constructParrot(Animal *obj, const char *name)
{
    obj->name = name;
    obj->pfun = vtableParrot;
    return obj;
}

Animal *create(const char *name)
{   
    Animal *obj = (Animal *)malloc(sizeof(Animal));
    return constructParrot(obj, name);
}

Animal *construct(const char *name, Animal* obj)
{
    return constructParrot(obj, name);
}
#pragma endregion Parrot