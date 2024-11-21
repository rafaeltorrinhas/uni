#include <stdio.h>
#include <stdlib.h>

/* SUGESTÂO: utilize as páginas do manual para conhecer mais sobre as funções usadas:
 man qsort
*/
#define LIMITLINENUMBER 100
#define LIMITLINESIZE 80

int compareInts(const void *px1, const void *px2)
{
    int x1 = *((int *)px1);
    int x2 = *((int *)px2);
    return(x1 < x2 ? -1 : x1 == x2 ? 0 : 1);
}

int main(int argc, char *argv[])
{
    FILE *fp = NULL;
    int numbers[LIMITLINENUMBER];
    char line[LIMITLINESIZE];

    if (argc != 2) {
        printf("USAGE: %s fileName\n", argv[0]);
        return EXIT_FAILURE;
    }

    fp = fopen(argv[1], "r");

    if ( fp == NULL )
    {
        perror ("Error opening file!");
        return EXIT_FAILURE;
    }

    int i,numSize = 0;
    while( fgets(line, sizeof(line), fp) != NULL )
    { 
        numbers[i] = atoi(line);
        i++;
        numSize++;
    }

    // /* Storing the arguments in the "array" numbers */
    // for(i = 0 ; i < numSize ; i++)
    // {
    //     numbers[i] = atoi(argv[i+1]);
    // }

    /* void qsort(void *base, size_t nmemb, size_t size, int (*compar)(const void *, const void *)); 
         The qsort() function sorts an array with nmemb elements of size size.*/
    qsort(numbers, numSize, sizeof(int), compareInts);

    /* Printing the sorted numbers */
    printf("Sorted numbers: \n");
    for(int j = 0 ; j < numSize ; j++)
    {
        printf("%d\n", numbers[j]);
    }

    return EXIT_SUCCESS;
}
