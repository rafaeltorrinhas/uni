//
// TO DO : desenvolva um algoritmo para verificar se um numero inteiro positivo
//         e uma capicua
//         Exemplos: 12321 e uma capiacua, mas 123456 nao e
//         USE uma PILHA DE INTEIROS (STACK) e uma FILA DE INTEIROS (QUEUE)
//
// TO DO : design an algorithm to check if the digits of a positive decimal
//         integer number constitue a palindrome
//         Examples: 12321 is a palindrome, but 123456 is not
//         USE a STACK of integers and a QUEUE of integers
//

#include <stdio.h>
#include <string.h>
#include "IntegersQueue.h"
#include "IntegersStack.h"


#define true (1==1)
#define false (!true)

int main(int argc, char *argv[]) {
  for (int l = 1; l < argc; l++) {
    int n = atoi(argv[l]);
    int number = n;
    int size = strlen(argv[l]);
    int numbers[size];
    int i = 0;
    
    while(n > 0) {
      int mod = n % 10;  
      numbers[size - i - 1] = mod;
      i++;
      n = n / 10;
    }

    Stack* s = StackCreate(size);
    Queue* q = QueueCreate(size);
    
    for (int j = 0; j < size; j++) {
      StackPush(s,numbers[j]);
      QueueEnqueue(q,numbers[j]);
    }

   int result = true;

    while(!QueueIsEmpty(q) && !StackIsEmpty(s)){
      int digit_stack = 0, digit_queue = 0;

      digit_stack = StackPop(s);
      digit_queue = QueueDequeue(q);

      if(digit_queue != digit_stack) {
            result = false;
            break;
       }
    }

    if (result) {
            printf("%d = True\n", number);
        } else {
            printf("%d = False\n", number);
        }

    StackDestroy(&s);
    QueueDestroy(&q);
    
  }

return 0;
}
