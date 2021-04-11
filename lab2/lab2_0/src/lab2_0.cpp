#include <iostream>
#include <list>

struct Point
{
    int x = 0;
    int y = 0;
};

class Shape
{
    Point center_;
public:
    virtual void draw() = 0;
    virtual void move(int x, int y)
    {
        this->center_.x += x;
        this->center_.y += y;
    }
    virtual int getX()
    {
        return this->center_.x;
    }
    virtual int getY()
    {
        return this->center_.y;
    }
};

class Circle : Shape
{
private:
    double radius_;
public:
    virtual void draw()
    {
        std::cout << "in circle (x:" << this->getX() << ",y:" << this->getY() << ")" << std::endl;
    }
};

class Square : Shape
{
private:
    double side_;
public:
    virtual void draw()
    {
        std::cout << "in square (x:" << this->getX() << ",y:" << this->getY() << ")" << std::endl;
    }
};

class Rhomb : Shape
{
private:
    double side_;
public:
    virtual void draw()
    {
        std::cout << "in rhomb (x:" << this->getX() << ",y:" << this->getY() << ")" << std::endl;
    }
};

void drawShapes(const std::list<Shape *> &shapes)
{
    std::list<Shape *>::const_iterator it;
    for (it = shapes.begin(); it != shapes.end(); ++it)
    {
        (*it)->draw();
    }
}
void moveShapes(std::list<Shape *> &shapes, int x, int y)
{
    std::list<Shape *>::const_iterator it;
    for (it = shapes.begin(); it != shapes.end(); ++it)
    {
        (*it)->move(x, y);
    }
}
int main()
{
    std::list<Shape *> shapes = std::list<Shape *>();

    shapes.push_back((Shape *)new Circle);
    shapes.push_back((Shape *)new Square);
    shapes.push_back((Shape *)new Square);
    shapes.push_back((Shape *)new Circle);
    shapes.push_back((Shape *)new Rhomb);

    drawShapes(shapes);
    moveShapes(shapes, 2, 3);
    drawShapes(shapes);
}