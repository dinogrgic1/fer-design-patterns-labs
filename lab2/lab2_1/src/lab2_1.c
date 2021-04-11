#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int gt_int(const void *first, const void *second)
{
    return *((int*)first) > *((int*)second);
}

int gt_char(const void *first, const void *second)
{
    return *((char*)first) > *((char*)second);;
}

int gt_string(const void *first, const void *second)
{
    return strcmp(*((const char**)first), *((const char**)second)) > 0 ? 1 : 0;
}

const void* mymax(const void *base, size_t nmemb, size_t size, int (*compar)(const void *, const void *))
{
    void *max = (void*) base;
    void *it = (void*) base;
    for(size_t i = 1; i < nmemb; i++)
    {
        it += size;
        if(compar(it, max))
        {
            max = it;
        }
    }
    return max;
}

int main(void)
{
    int arr_int[] = { 1, 3, 5, 7, 4, 6, 9, 2, 0 };
    char arr_char[] = "Suncana strana ulice";
    const char *arr_str[] = 
    {
        "Gle", "malu", "vocku", "poslije", "kise",
        "Puna", "je", "kapi", "pa", "ih", "njise"
    };

    const void* int_max = mymax(arr_int, sizeof(arr_int) / sizeof(arr_int[0]), sizeof(arr_int[0]), gt_int);
    printf("%d\n", *((const int *)int_max));

    const void *char_max = mymax(arr_char, sizeof(arr_char) / sizeof(arr_char[0]), sizeof(arr_char[0]), gt_char);
    printf("%c\n", *((const char *)char_max));

    const void *str_max = mymax(arr_str, sizeof(arr_str) / sizeof(arr_str[0]), sizeof(arr_str[0]), gt_string);
    printf("%s\n", *((const char **)str_max));
}