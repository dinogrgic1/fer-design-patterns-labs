#include "ObserverMedian.hpp"
#include <iostream>
#include <numeric>
#include <algorithm>

void ObserverMedian::update(std::vector<int> nums)
{
    int size = nums.size();

    std::sort(nums.begin(), nums.end());
    if (size % 2 == 0)
        std::cout << "median: " << (nums[size / 2. - 1] + nums[size / 2.]) / 2. << std::endl;
    else
        std::cout << "median: " << nums[size / 2.] << std::endl;
}
