#include <stdio.h>
#include <stdlib.h>

#pragma region Unary_Function
typedef struct Unary_Function_Vtable
{
    double (*value_at)();
    double (*negative_value_at)();
    void (*tabulate)();
} Unary_Function_Vtable;

typedef struct Unary_Function
{
    Unary_Function_Vtable *v_table;
    int lower_bound;
    int upper_bound;
} Unary_Function;


double unary_function_value_at(Unary_Function *uf, double x)
{
    return 0;
}

double unary_function_negative_value_at(Unary_Function *uf, double x)
{
    return -unary_function_value_at(uf, x);
}

void unary_function_tabulate(const Unary_Function* uf)
{
    for (int x = uf->lower_bound; x <= uf->upper_bound; x++)
    {
        printf("f(%d)=%lf\n", x, (uf->v_table)->value_at(uf, (double)x));
    }
}
Unary_Function_Vtable ufVtable = { unary_function_value_at, unary_function_negative_value_at, unary_function_tabulate };
void unary_function_constructor(Unary_Function *uf, int lb, int ub)
{
    uf->v_table = &ufVtable;
    uf->lower_bound = lb;
    uf->upper_bound = ub;
}

#pragma endregion Unary_Function

#pragma region Square
typedef struct Square_Vtable
{
    double (*value_at)();
    double (*negative_value_at)();
    void (*tabulate)();
} Square_Vtable;

typedef struct Square
{
    Square_Vtable *v_table;
    int lower_bound;
    int upper_bound;
} Square;

double square_value_at(double x)
{    
    return x * x;
}

Square_Vtable squareVtable = { square_value_at, unary_function_negative_value_at, unary_function_tabulate };
Square* square_constructor(int lb, int ub)
{
    Square *tmp = (Square*) malloc(sizeof(Square));
    unary_function_constructor((Unary_Function*) tmp, lb, ub);
    tmp->v_table = &squareVtable;
    return tmp;
}

#pragma endregion Square

#pragma region Linear
typedef struct Linear_Vtable
{
    double (*value_at)();
    double (*negative_value_at)();
    void (*tabulate)();
} Linear_Vtable;

typedef struct Linear
{
    Linear_Vtable *v_table;
    int lower_bound;
    int upper_bound;
    double a;
    double b;
} Linear;

double linear_value_at(Linear *l, double x)
{
    return l->a * x + l->b;
}

Linear_Vtable linearVtable = { linear_value_at, unary_function_value_at, unary_function_tabulate };
Linear *linear_constructor(int lb, int ub, double a_coef, double b_coef)
{
    Linear *tmp = (Linear*) malloc(sizeof(Linear));
    unary_function_constructor((Unary_Function*) tmp, lb, ub);
    tmp->v_table = &linearVtable;
    tmp->a = a_coef;
    tmp->b= b_coef;
    return tmp;
}
#pragma endregion Linear_Function

_Bool same_functions_for_ints(Unary_Function *f1, Unary_Function *f2, double tolerance)
{
    if (f1->lower_bound != f2->lower_bound)
        return 0;
    if (f1->upper_bound != f2->upper_bound)
        return 0;
 
    for (int x = f1->lower_bound; x <= f1->upper_bound; x++)
    {
        double delta = (f1->v_table)->value_at(x) - (f2->v_table)->value_at(x);   
        if (delta < 0)
            delta = -delta;
        if (delta > tolerance)
            return 0;
    }
    return 1;
}

int main(void)
{
    Square *f1 = square_constructor(-2, 2);
    (f1->v_table)->tabulate();
    Linear *f2 = linear_constructor(-2, 2, 5, -2);
    (f2->v_table)->tabulate();
    //printf("f1==f2: %s\n", same_functions_for_ints((Unary_Function*) f1, (Unary_Function*) f2, 1E-6) ? "DA" : "NE");
    printf("neg_val f2(1) = %lf\n", (f2->v_table)->negative_value_at(1.0));
    return 0;
}