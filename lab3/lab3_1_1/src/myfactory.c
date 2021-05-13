#include "myfactory.h"
#include <stdio.h>
#include <stdlib.h>
#include <dlfcn.h>
#include <string.h>

#define MAX_LINUX_FILENAME 255

typedef void *(*PTRFUN)();

void *myfactory(char const *libname, char const *ctorarg, _Bool heap)
{
    char filename[MAX_LINUX_FILENAME + 1] = "./";
    strcat(filename, libname);
    strcat(filename, ".so");

    void *handle = dlopen(filename, RTLD_LAZY);
    if (!handle)
    {
        printf("File not found.\n");
        exit(1);
    }

    if (heap)
    {
        PTRFUN create_fun = (PTRFUN)dlsym(handle, "create");
        return create_fun(ctorarg);
    }
    else
    {
        PTRFUN construct_fun = (PTRFUN)dlsym(handle, "construct");
        PTRFUN sizeof_fun = (PTRFUN)dlsym(handle, "size");
        void *space = alloca((size_t)sizeof_fun());
        return construct_fun(ctorarg, space);
    }
}