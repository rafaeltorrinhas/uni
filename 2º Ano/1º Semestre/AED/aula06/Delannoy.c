#include <stdio.h>
#define SIZE 100

int n_addsR = 0;
int n_addsD = 0;
int n_addsM = 0;
int n_callsR = 0;
int n_callsD = 0;
int n_callsM = 0;
 
int dellanoyR(int m, int n) {
  n_callsR++;
  if (m == 0 || n == 0) {
    return 1;
  } else {
    n_addsR += 2;
    return dellanoyR(m-1,n) + dellanoyR(m-1,n-1) + dellanoyR(m,n - 1);
  }
}


int dellanoyD(int m, int n) {
  n_callsD++;
  long unsigned int d[m + 1][n + 1]; 
  for (unsigned int i = 0; i <= m; i++) {
    for (unsigned int j = 0; j <= n; j++) {
      if (i == 0 || j == 0) {
        d[i][j] = 1;
      } else {
        n_addsD += 2;
        d[i][j] = d[i-1][j] + d[i-1][j-1] + d[i][j-1];
      }
    }
  }
  return d[m][n];
}

long int mcache[SIZE+1][SIZE+1] = {{0}};

int dellanoyM(int m, int n) {
  n_callsM++;
  size_t r = mcache[m][n];
  if (r == 0) {
    if (m == 0 || n == 0) {
      r = 1;
    } else {
      n_addsM += 2;
      r = dellanoyM(m-1,n) + dellanoyM(m-1,n-1) + dellanoyM(m,n - 1);
    }
  }
  mcache[m][n] = r;

  return r;
}


int main() {
  
  printf(" %-20s | %-21s | %-20s \n", "Recursiva", "Dinâmica", "Memoization");
  for (int i = 0; i < 10; i++) {
    for (int j = 0; j < 10; j++) {
      char baseStringR[50];
      char baseStringD[50];
      char baseStringM[50];
      sprintf(baseStringR, "(%d,%d)-> %d", i, j, dellanoyR(i, j));
      sprintf(baseStringD, "(%d,%d)-> %d", i, j, dellanoyD(i, j));
      sprintf(baseStringM, "(%d,%d)-> %d", i, j, dellanoyM(i, j));
      printf(" %-20s | %-20s | %-20s \n", baseStringR, baseStringD, baseStringM);
    }
  }
printf("\n\n      %-10s | %-10s \n", "Chamadas", "Adições");
printf("R     %-10d | %-10d  \n",n_callsR,n_addsR);
printf("D     %-10d | %-10d  \n",n_callsD,n_addsD);
printf("M     %-10d | %-10d  \n",n_callsM,n_addsM);
}
