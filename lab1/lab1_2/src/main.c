#include <stdio.h>

typedef char const *(*PTRFUN)();

typedef struct Unary_Function_Vtable
{
    double *(*value_at);
    double *(*negative_valute_at);
    void *(*tabulate);
} Unary_Function_Vtable;

typedef struct Square_Function_Vtable
{
    double *(*value_at);
    double *(*negative_valute_at);
    void *(*tabulate);
} Square_Function_Vtable;

typedef struct Linear_Function_Vtable
{
    double *(*value_at);
    double *(*negative_valute_at);
    void *(*tabulate);
} Linear_Function_Vtable;

Unary_Function_Vtable* ufVtable = {unary_function_value_at, unary_function_negative_value_at, unary_function_tabulate};
Square_Function_Vtable* squareVtable = {};
Linear_Function_Vtable* linearVtable = {};

typedef struct Unary_Function
{
    PTRFUN* v_table;
    int lower_bound;
    int upper_bound;
} Unary_Function;

typedef struct Square
{
    PTRFUN* v_table;
    int lower_bound;
    int upper_bound;
} Square;

typedef struct Linear
{
    PTRFUN* v_table;
    int lower_bound;
    int upper_bound;
    int a;
    int b;
};

Unary_Function* make(int lb, int ub)
{
    Unary_Function* tmp;
    tmp->lower_bound = lb;
    tmp->upper_bound = ub;
    return tmp;
}

double unary_function_value_at(double x)
{
    return 0;
}

double unary_function_negative_value_at(double x)
{
    return -value_at(x);
}

void unary_function_tabulate(const Unary_Function* uf)
{
    for (int x = uf->lower_bound; x <= uf->upper_bound; x++)
    {
        printf("f(%d)=%lf\n", x, uf->value_at(x));
    }
}

// static
_Bool same_functions_for_ints( Unary_Function *f1, Unary_Function *f2, double tolerance)
{
    if (f1->lower_bound != f2->lower_bound)
        return 0;
    if (f1->upper_bound != f2->upper_bound)
        return 0;
    for (int x = f1->lower_bound; x <= f1->upper_bound; x++)
    {
        double delta = f1->value_at(x) - f2->value_at(x);
        if (delta < 0)
            delta = -delta;
        if (delta > tolerance)
            return 0;
    }
    return 1;
}

int main(void)
{
}