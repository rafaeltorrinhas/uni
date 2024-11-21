#include <stdio.h>


int main() {

  int potencias[10];
  int num1, num2, num3, sum;
  for (int k = 0; k < 10; k++){
    potencias[k] = k*k*k;
  }

  for (int i = 100; i <= 999; i++) {
    num1 = i / 100;
    num2 = (i / 10) % 10;
    num3 = i % 10;

    sum = potencias[num1] + potencias[num2] + potencias[num3] ;
    
    if (sum == i) {
      printf("%d\n", i);
    }

  }
  return 0;
}
