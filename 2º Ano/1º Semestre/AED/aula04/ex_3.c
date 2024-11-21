#include <stdio.h>
#include <assert.h>

int checkSum(int seq[], int n) {
  assert(n>2);
  
  int *array = seq;
  int count = 0;
  
  for (int i = 2; i < n; i++) {
    for (int j = 1; j < n; j++) {
      if (j < i) {
        for (int k = 0; k < n; k++) {
          if (k < j) {
            if (array[i] == array[k] + array[j]) {
              count++;
            }
          }
        }
      }
    }
    }
    printf("\n Resultado:  %d ", count);
    return 0;
}


int main() {

  int seq[10] = {1,2,3,4,5,6,7,8,9,10};
  int seq2[10] = {1,2,1,4,5,6,7,8,9,10};
  int seq3[10] = {1,2,1,3,2,6,7,8,9,10};
  int seq4[10] = {0,2,2,0,3,3,0,4,4,0};
  int seq5[10] = {0,0,0,0,0,0,0,0,0,0};
  checkSum(seq, sizeof(seq)/sizeof(int));
  checkSum(seq2, sizeof(seq2)/sizeof(int));
  checkSum(seq3, sizeof(seq3)/sizeof(int));
  checkSum(seq4, sizeof(seq4)/sizeof(int));
  checkSum(seq5, sizeof(seq5)/sizeof(int));
  return 0;
}
