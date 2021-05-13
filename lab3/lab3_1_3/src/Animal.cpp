#include "Animal.hpp"

Animal::Animal(const char* name, const char* menu, const char* greet)
{
    this->name_ = name;
    this->menu_ = menu;
    this->greet_ = greet;
}

const char *Animal::name()
{
    return this->name_;
}

const char *Animal::menu()
{
    return this->menu_;
}

const char *Animal::greet()
{
    return this->greet_;
}