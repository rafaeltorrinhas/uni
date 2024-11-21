#include <stdio.h>


int main() {
  int fatoriais[10];
  int sum;
  int mult = 1;

  for (int k = 0; k < 10; k++) {
    if (k == 0 || k == 1) {
        fatoriais[k] = 1;
    } else {
        mult = 1;
        for (int j = 2; j <= k; j++) {
            mult = mult * j;
        }
        fatoriais[k] = mult;
    }
  }

  for (int i = 0; i <= 1000000; i++) {
     int tnum = i;
     sum = 0; 
     
    while (tnum > 0) {
      int num = tnum % 10;
      sum += fatoriais[num];
      tnum /= 10;
    }

    if (sum == i) {
      printf("%d\n", i);
    }

  }
  return 0; 
}

