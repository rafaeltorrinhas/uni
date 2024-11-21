#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#define LIMITLINESIZE 80

int main(int argc, char **argv) {

  FILE *fp = NULL;
  char line[LIMITLINESIZE];
  fp = fopen(argv[1], "r");
  int lowerCount, upperCount, wordCount = 0;

  while (fgets(line, sizeof(line), fp) != NULL) {
    printf("%s", line);
    wordCount++;
    char *pline = line;
    while (*pline != '\0') {
      if (isupper(*pline)) {
        upperCount++;
      } else {
        lowerCount++;
      }
      pline++;
    }
  }
  printf("Words: %d, Lower: %d, Upper: %d",wordCount,lowerCount,upperCount);
}