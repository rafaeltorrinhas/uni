#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{
    int i;
    if (argc == 3) {
      for(i = 0 ; i < argc ; i++) {
        printf("Argument %02d: \"%s\"\n", i, argv[i]);        
      }
    } else {
      printf("This program only accepts 2 arguments. \n");
    }
    return EXIT_SUCCESS;
}
