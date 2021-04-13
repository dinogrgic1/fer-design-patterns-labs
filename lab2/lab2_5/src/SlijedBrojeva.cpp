#include "SlijedBrojeva.hpp"

void SlijedBrojeva::kreni()
{
    int r = 0;
    for (;;)
    {
        r = this->izvor_->read();

        if (r == -1)
            break;

        this->nums.push_back(r);
        this->notify();
        std::this_thread::sleep_for(std::chrono::seconds(1));
    }
}

void SlijedBrojeva::attach(Observer *obs)
{
    this->observers_.push_back(obs);
}
void SlijedBrojeva::notify()
{
    for (int i = 0; i < this->observers_.size(); i++)
    {
        this->observers_[i]->update(this->nums);
    }
}
void SlijedBrojeva::dettach(Observer *obs)
{
    for (int i = 0; i < observers_.size(); i++)
    {
        if (observers_[i] == obs)
        {
            this->observers_.erase(observers_.begin() + i);
            break;
        }
    }
}