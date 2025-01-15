#include <stdio.h>

void SelectionSort (int* a, unsigned int n) {
  
  int j = 0;
  
  for (int i = 0; i < n-1; i++) {
   
    int temp = a[i];
    int idx = i;
   
    for (j = i + 1; j < n; j++){
    
      if (a[j] < a[idx]) {
       
        idx = j;
    
      }
    
    }

 
      a[i] = a[idx];
      a[idx] = temp;

  }
  
  
  for(int loop = 0; loop < n; loop++)
    printf("%d ", a[loop]);

}

void BubbleSort(int* a, unsigned int n){

  int swap = 1;
  
  while (swap) {
    
    swap = 0;

    for (int i = 0; i < n-1; i++) {
  
      int temp = a[i];
      
      if (a[i] > a[i+1]) {
        
        a[i] = a[i+1];
        a[i+1] = temp;
        swap = 1;    
      
      }
      
    }
  
  }

   
  for(int loop = 0; loop < n; loop++)
    printf("%d ", a[loop]);

}

void InsertionSort(int* a, unsigned int n) {

  for (int i = 1; i < n; i++) {

    for (int j = i; j > 0; j--) {

      if (a[j-1] > a[j]) {
        
        int aux = a[j-1];
        a[j-1] = a[j];
        a[j] = aux;
        continue;
      
      }

    }

  }

  for(int loop = 0; loop < n; loop++)
    printf("%d ", a[loop]);

}

void main(void) {
  
  int array[] = {4,8,1,15,2,36,97,3,6,70,9};
  InsertionSort(array,11);

}