#include <stdio.h>
#include <assert.h>

int geoCheck(int seq[], int n) {
  assert(n>2);  
  int *array = seq;
  int count = 0;
  int count_d = 0;
  int count_m = 0; 
  int r = array[1] / array[0]; 
  count_d++;

  for (int i = 2; i < n; i++) {
    count++;
    count_m++;
    if (!(array[i] == r * array[i-1])) {
      printf("Não se trata de uma progressão geométrica, %d multiplicações, %d divisões.\n", count_m, count_d);
      return 0;
    } 

  }
  printf("Trata-se de uma progressão geométrica, %d multiplicações, %d divisões.\n", count_m, count_d);
  return 1;
}

int main() {
  int seq[10] = {1,2,3,4,5,6,7,8,9,10};
  int seq1[10] = {1,2,4,4,5,6,7,8,9,10};
  int seq2[10] = {1,2,4,8,5,6,7,8,9,10};
  int seq3[10] = {1,2,4,8,16,6,7,8,9,10};
  int seq4[10] = {1,2,4,8,16,32,7,8,9,10};
  int seq5[10] = {1,2,4,8,16,32,64,8,9,10};
  int seq6[10] = {1,2,4,8,16,32,64,128,9,10};
  int seq7[10] = {1,2,4,8,16,32,64,128,256,10};
  int seq8[10] = {1,2,4,8,16,32,64,128,256,512};

  geoCheck(seq, sizeof(seq)/sizeof(int));
  geoCheck(seq1, sizeof(seq1)/sizeof(int));
  geoCheck(seq2, sizeof(seq2)/sizeof(int));
  geoCheck(seq3, sizeof(seq3)/sizeof(int));
  geoCheck(seq4, sizeof(seq4)/sizeof(int));
  geoCheck(seq5, sizeof(seq5)/sizeof(int));
  geoCheck(seq6, sizeof(seq6)/sizeof(int));
  geoCheck(seq7, sizeof(seq7)/sizeof(int));
  geoCheck(seq8, sizeof(seq8)/sizeof(int));

}