#include <stdio.h>

double T(int n) {
    if (n == 1) {
        return 1;
    } else {
        return T(n / 2) + n; 
    }
}

double T2(int n) {
    if (n == 1) {
        return 1;  
    } else {
        return T2(n / 2) + T2((n + 1) / 2) + n; 
    }
}

double T3(int n) {
    if (n == 1) {
        return 1;  
    } else if (n % 2 != 0) {
        return T3(n / 2) + T3((n + 1) / 2) + n;  
    } else {
        return 2 * T3(n / 2) + n;
    }
}

int main() {
  for (int i = 1; i <= 128; i++) {
    printf("%.2f %.2f %.2f\n",T(i),T2(i),T3(i));
  }
}