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

#pragma region Tiger
char const *name(Animal *obj)
{
    return obj->name;
}

char const *greet(void)
{
    return "raawrrr!";
}

char const *menu(void)
{
    return "meso";
}

size_t size()
{
    return sizeof(Animal);
}

PTRFUN vtableTiger[3] = {name, greet, menu};
Animal *constructTiger(Animal *obj, const char *name)
{
    obj->name = name;
    obj->pfun = vtableTiger;
    return obj;
}

Animal *create(const char *name)
{   
    Animal *obj = (Animal *)malloc(sizeof(Animal));
    return constructTiger(obj, name);
}

Animal *construct(const char *name, Animal* obj)
{
    return constructTiger(obj, name);
}
#pragma endregion Tiger