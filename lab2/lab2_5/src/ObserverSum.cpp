#include <iostream>
#include <numeric>
#include "ObserverSum.hpp"

void ObserverSum::update(std::vector<int> nums)
{
    std::cout << "sum: " << std::accumulate(nums.begin(), nums.end(), 0) << std::endl;
}
