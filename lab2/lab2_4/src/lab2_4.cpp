#include <iostream>
#include <vector>
#include <random>
#include <bits/stdc++.h>

class IGenerate
{
public:
    virtual ~IGenerate() {}
    virtual std::vector<int> generate() = 0;
};

class IPercentile
{
public:
    virtual ~IPercentile() {}
    virtual int percentile(std::vector<int>) = 0;
};

class DistributionTester
{
private:
    IGenerate *generate_;
    IPercentile *percentile_;

    std::vector<int> generate() { return this->generate_->generate(); }
    int percentile(std::vector<int> nums) { return this->percentile_->percentile(nums); }

public:
    DistributionTester(IGenerate *generate, IPercentile *percentile) : generate_(generate), percentile_(percentile) {}
    void test()
    {
        std::vector<int> nums = this->generate();
        std::cout << this->percentile(nums) << std::endl;
    }
};

class GenerateIterative : public IGenerate
{
private:
    int lower_;
    int upper_;
    int step_;

public:
    GenerateIterative(int step, int lower, int upper)
    {
        this->step_ = step;
        this->lower_ = lower;
        this->upper_ = upper;
    }

    virtual std::vector<int> generate()
    {
        std::vector<int> tmp = std::vector<int>();
        for (int i = this->lower_; i <= this->upper_; i += this->step_)
        {
            tmp.push_back(i);
        }
        return tmp;
    }
};

class GenerateRandom : public IGenerate
{
private:
    double mean_;
    double stddev_;
    int numbers_;

public:
    GenerateRandom(double mean, double stddev, int numbers)
    {
        this->mean_ = mean;
        this->stddev_ = stddev;
        this->numbers_ = numbers;
    }

    virtual std::vector<int> generate()
    {
        std::default_random_engine generator;
        std::normal_distribution<double> distribution(this->mean_, this->stddev_);

        std::vector<int> tmp = std::vector<int>();
        for (int i = 0; i < this->numbers_; i++)
        {
            tmp.push_back(distribution(generator));
        }
        return tmp;
    }
};

class GenerateFibbonaci : public IGenerate
{
private:
    int n_;

public:
    GenerateFibbonaci(int n)
    {
        this->n_ = n;
    }

    virtual std::vector<int> generate()
    {
        int t1 = 0, t2 = 1, next = 0;
        std::vector<int> tmp = std::vector<int>();
        for (int i = 0; i <= this->n_; i++)
        {
            if (i == 1)
                tmp.push_back(t1);

            if (i == 2)
                tmp.push_back(t2);

            next = t1 + t2;
            t1 = t2;
            t2 = next;
            tmp.push_back(next);
        }
        return tmp;
    }
};

class PercentileSorted : public IPercentile
{
private:
    int p_;

public:
    PercentileSorted(int p)
    {
        this->p_ = p;
    }

    virtual int percentile(std::vector<int> number)
    {
        sort(number.begin(), number.end());
        int pos = 0;
        const double n_p = this->p_ * number.size() / 100 + 0.5;
        double delta = abs(number[pos] - n_p);

        for (int i = 1; i < number.size(); i++)
        {
            if (abs(number[i] - n_p) < delta)
            {
                pos = i;
            }
        }
        return number[pos];
    }
};

class PercentileInterpolated : public IPercentile
{
private:
    int p_;

public:
    PercentileInterpolated(int p)
    {
        this->p_ = p;
    }

    virtual int percentile(std::vector<int> number)
    {
        int len = number.size();
        std::sort(number.begin(), number.end());

        if (this->p_ < 100 * (1 - 0.5) / len) 
                return number[0];
            
        if (this->p_ > 100 * (len - 0.5) / len)
            return number[len - 1];

        for (int i = 0; i < len; i++)
        {
            double p_v_i = 100 * (i + 1 - 0.5) / len;
            double p_v_i_1 = 100 * (i + 1 + 1 - 0.5) / len;
            if(this->p_ > p_v_i && this->p_ < p_v_i_1)
                return number[i] + len * (this->p_ - p_v_i) * ((number[i + 1] - number[i]) / 100);
        }
        return -1;
    }
};

int main(void)
{
    DistributionTester *d = new DistributionTester(new GenerateIterative(1, 10, 50), new PercentileSorted(80));
    d->test();

    d = new DistributionTester(new GenerateRandom(5.0, 2.0, 50), new PercentileSorted(30));
    d->test();

    d = new DistributionTester(new GenerateFibbonaci(15), new PercentileSorted(50));
    d->test();

    d = new DistributionTester(new GenerateIterative(1, 10, 50), new PercentileInterpolated(80));
    d->test();
}