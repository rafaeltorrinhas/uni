#include <stdio.h>
#include <stdlib.h>

double sum_values(double n1, double n2);
double multiplication(double n1, double n2);
double division(double n1, double n2);
double subtraction(double n1, double n2);
double power(double n1, int n2);

int main(int argc, char *argv[]) {
    if (argc == 4) {
      
      double n1 = atof(argv[1]);
      char op = argv[2][0];     // está a ir ao primeiro caractere da string no segundo argumento
      double n2 = atof(argv[3]);
      
      switch (op)
      {
      case 'x':
        printf("%.2f\n", multiplication(n1, n2));
        return EXIT_SUCCESS;
      case '+':
        printf("%.2f\n", sum_values(n1, n2));
        return EXIT_SUCCESS;
      case '-':
        printf("%.2f\n", subtraction(n1, n2));
        return EXIT_SUCCESS;
      case '/':
        printf("%.2f\n", division(n1, n2));
        return EXIT_SUCCESS;
      case 'p':
        printf("%.2f\n", power(n1, (int)n2));
        return EXIT_SUCCESS;
      default:
        printf("Operação inválida. \n");
        return(EXIT_FAILURE);
      }
      
    } else {
      printf("Nº de argumentos inválido \n");
    }
    return EXIT_SUCCESS;
}

double sum_values(double n1, double n2) {
  return n1 + n2;
}

double multiplication(double n1, double n2) {
  return n1 * n2;
}

double division(double n1, double n2) {
  return n1 / n2;
}

double subtraction(double n1, double n2) {
  return n1 - n2;
}

double power(double n1, int n2) {
  double result = 1;
  for (int i = 0; i < n2; i++) {
    result *= n1;
  }
  return result;
}