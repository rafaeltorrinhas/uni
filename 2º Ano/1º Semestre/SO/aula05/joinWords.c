#include <stdio.h>
#include <string.h>

int main(int argc, char **argv) {
  char string[100] = ""; 
  for (int i = 1; i < argc; i++) {
    strcat(string, argv[i]);  
  }

  printf("%s\n",string);
}