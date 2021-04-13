#include "ObserverAvg.hpp"
#include <iostream>
#include <numeric>

void ObserverAvg::update(std::vector<int> nums)
{
    std::cout << "avg: " << std::accumulate(nums.begin(), nums.end(), 0.0) / nums.size() << std::endl;
}
