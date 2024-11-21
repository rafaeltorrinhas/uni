#include <stdio.h>
#include <string.h>
#include <ctype.h>

int main(int argc, char **argv) {
  char string[100] = ""; 
  for (int i = 1; i < argc; i++) {
    if (isalpha(argv[i][0])) {
      strcat(string, argv[i]);  
    }
  }

  printf("%s\n",string);
}
