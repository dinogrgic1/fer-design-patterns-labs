#include "SlijedBrojeva.hpp"
#include "ObserverLog.hpp"

ObserverLog::ObserverLog(std::string filepath)
{
    this->file_.open(filepath);
}

void ObserverLog::update(std::vector<int> nums)
{
    file_ << nums[nums.size() - 1] << std::endl;
}
