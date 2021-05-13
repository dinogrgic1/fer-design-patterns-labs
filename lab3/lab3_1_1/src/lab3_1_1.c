#include "myfactory.h"

#include <stdio.h>
#include <stdlib.h>

typedef char const *(*PTRFUN)();

typedef struct Animal
{
  PTRFUN *vtable;
  // vtable entries:
  // 0: char const* name(void* this);
  // 1: char const* greet();
  // 2: char const* menu();
} Animal;

// parrots and tigers defined in respective dynamic libraries

void animalPrintGreeting(Animal *obj)
{
  printf("%s pozdravlja: %s\n", obj->vtable[0](), obj->vtable[1]());
}

void animalPrintMenu(Animal *obj)
{
  printf("%s voli %s\n", obj->vtable[0](), obj->vtable[2]());
}

int main(int argc, char *argv[])
{
  printf("Alociranje na gomili...\n");
  for (int i = 1; i < argc; ++i)
  {
    Animal *p = (Animal *)myfactory(argv[i], "Modrobradi", 1);
    if (!p)
    {
      printf("Creation of plug-in object %s failed.\n", argv[i]);
      continue;
    }
    animalPrintGreeting(p);
    animalPrintMenu(p);
    free(p);
  }

  printf("Alociranje memorije na stogu...\n");
  for (int i = 1; i < argc; ++i)
  {
    Animal *p = (Animal *)myfactory(argv[i], "Tamnobradi", 0);
    if (!p)
    {
      printf("Creation of plug-in object %s failed.\n", argv[i]);
      continue;
    }
    animalPrintGreeting(p);
    animalPrintMenu(p);
  }
}