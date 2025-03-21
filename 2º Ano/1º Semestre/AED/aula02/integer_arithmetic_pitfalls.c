//
// Tomás Oliveira e Silva, AED, October 2021
//
// explain the program output
//
// try also compiling the program with the -Wsign-compare compilation flag
//

#include <stdio.h>
#include <limits.h>


int main(void)
{
  printf("Máximo int = %d\n", INT_MAX);
  printf("Mínimo int = %d\n",INT_MIN);
  
  
  unsigned int i = 1;
  int j = -1;
  int k = -2147483648;

  printf("original i = %u\n",i);  // 1
  printf("original j = %d\n",j);  // -1
  printf("original k = %d\n",k);  // -2147483648
  // compare i with j
  if(i > j)
    printf("i > j is true\n"); // X
  else
    printf("i > j is false\n"); // <---
  // replace k by its absolute value and print the result
  if(k < 0)
    k = -k;
  printf("absolute value of k = %d\n",k); // 2147483648 (-2147483648)
  return 0;


}
