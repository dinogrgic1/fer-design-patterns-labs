#include <stdlib.h>
#include <stdio.h>

#define ANIMAL_GREET 0
#define ANIMAL_MENU 1

typedef char const *(*PTRFUN)();

#pragma region Animal
typedef struct Animal
{
    char const *name;
    PTRFUN *pfun;
} Animal;

void animalPrintGreeting(Animal *obj)
{
    printf("%s pozdravlja: %s\n", obj->name, obj->pfun[ANIMAL_GREET]());
}

void animalPrintMenu(Animal *obj)
{
    printf("%s voli %s\n", obj->name, obj->pfun[ANIMAL_MENU]());
}
#pragma endregion Animal

#pragma region Dog
char const *dogGreet(void)
{
    return "vau!";
}

char const *dogMenu(void)
{
    return "kuhanu govedinu";
}

PTRFUN vtableDog[2] = {dogGreet, dogMenu};
Animal *constructDog(Animal *obj, const char *name)
{
    obj->name = name;
    obj->pfun = vtableDog;
    return obj;
}

Animal *createDog(const char *name)
{   
    Animal *obj = (Animal *)malloc(sizeof(Animal));
    return constructDog(obj, name);
}

Animal **createDogs(int n)
{
    Animal **obj = malloc(n * sizeof(Animal));
    for(int i = 0; i < n; i++)
    {
        obj[i] = createDog("Dog");
    }
    return obj;
}
#pragma endregion Dog

#pragma region Cat
char const *catGreet(void)
{
    return "mijau!";
}

char const *catMenu(void)
{
    return "konzerviranu tunjevinu";
}

PTRFUN vtableCat[2] = {catGreet, catMenu};
Animal *constructCat(Animal *obj, const char *name)
{
    obj->name = name;
    obj->pfun = vtableCat;
    return obj;
}

Animal *createCat(const char *name)
{
    Animal *obj = (Animal *)malloc(sizeof(Animal));
    return constructCat(obj, name);
}
#pragma endregion Cat

void testAnimals(void)
{
    Animal *p1 = createDog("Hamlet");
    Animal *p2 = createCat("Ofelija");
    Animal *p3 = createDog("Polonije");

    animalPrintGreeting(p1);
    animalPrintGreeting(p2);
    animalPrintGreeting(p3);

    animalPrintMenu(p1);
    animalPrintMenu(p2);
    animalPrintMenu(p3);

    free(p1);   free(p2);   free(p3);
}

int main(void)
{
    testAnimals();

    Animal *cat;
    cat = createCat("Cat");
    animalPrintGreeting(cat);

    Animal **dogs = createDogs(10);
    for(int i = 0; i < 10; i++)
    {
        animalPrintGreeting(dogs[i]);
        free(dogs[i]);
    }
    free(dogs);
}