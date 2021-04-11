#include <iostream>
#include <vector>
#include <set>
#include <string>
#include <string.h>

template <typename Iterator>
Iterator mymax(Iterator first, Iterator last)
{
    Iterator max = first;
    ++first;

    while (first != last) 
    {
        if (*first > *max) 
        {
            max = first;
        }
        ++first;
    }
    return max;
}

int main()
{
    int arr_int[] = {1, 3, 5, 7, 4, 6, 9, 2, 0};
    char arr_char[] = "Suncana strana ulice";
    const char *arr_str[] = 
    {
        "Gle", "malu", "vocku", "poslije", "kise",
        "Puna", "je", "kapi", "pa", "ih", "njise"
    };

    std::vector<std::string> vec = std::vector<std::string>();
    vec.push_back(std::string("abc"));
    vec.push_back(std::string("bcd"));
    vec.push_back(std::string("xyz"));
    vec.push_back(std::string("efg"));

    std::set<int> set = std::set<int>();
    set.insert(1);
    set.insert(3);
    set.insert(9);
    set.insert(3);

    const int *maxint = mymax(&arr_int[0], &arr_int[sizeof(arr_int) / sizeof(*arr_int)]);
    std::cout << *maxint << "\n";

    const char *maxchar = mymax(&arr_char[0], &arr_char[sizeof(arr_char) / sizeof(*arr_char)]);
    std::cout << *maxchar << "\n";

    const char **maxstr = mymax(&arr_str[0], &arr_str[sizeof(arr_str) / sizeof(*arr_str)]);
    std::cout << *maxstr << "\n";

    std::vector<std::string>::iterator maxvec = mymax(vec.begin(), vec.end());
    std::cout << *maxvec << "\n";

    std::set<int>::iterator maxset = mymax(set.begin(), set.end());
    std::cout << *maxset << "\n";
}