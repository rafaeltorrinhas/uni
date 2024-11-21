#include <stdio.h>
#include <assert.h>

int function(int seq[], int n) {

  assert(n>2);

  int count_c = 0;
  int count = 0; 
  int *array =  seq;

  for (int i = 1; i < (n - 1); i++) {
    if ( array[i] == array[i-1] + array[i+1] ) {
      printf("%d, ", array[i]);
      count++;
      count_c++;
    } else {
    count_c++;
    }
  }
  
  printf("\n");
  printf("Foram feitas %d comparações, das quais %d verificam a propriedade.\n",count_c,count);
  return 0;
}

int main() {

  int seq[10] = {1,2,3,4,5,6,7,8,9,10};
  function(seq, sizeof(seq)/sizeof(int));
  int seq2[10] = {1,2,1,4,5,6,7,8,9,10};
  function(seq2, sizeof(seq2)/sizeof(int));
  int seq3[10] = {1,2,1,3,2,6,7,8,9,10};
  function(seq3, sizeof(seq3)/sizeof(int));
  int seq4[10] = {0,2,2,0,3,3,0,4,4,0};
  function(seq4, sizeof(seq4)/sizeof(int));
  int seq5[10] = {0,0,0,0,0,0,0,0,0,0};
  function(seq5, sizeof(seq5)/sizeof(int));
  return 0;
}