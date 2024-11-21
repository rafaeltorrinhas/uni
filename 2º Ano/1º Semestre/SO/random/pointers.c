#include <stdio.h>

int main(int argc, char **argv){
    
    int x = 5;
    int* ptr = &x;//tou a dzr q ptr é o endereço d x e *int é o conteudo de x
    int** pptr = &ptr;//tou a dzr q pptr é o endereço de ptr e *pptr é o endereço de x, **pptr é conteudo de x
    printf("x = %d\n",x);
    printf("x = %d\n", *ptr);
    printf("x = %d\n", **pptr);
    printf("&x = %p\n", &x);
    printf("&x = %p\n", ptr);
    printf("&x = %p\n", *pptr);
    printf("&ptr = %p\n", &ptr);
    printf("&ptr = %p\n", pptr);
}