#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <stdlib.h>
#include <time.h>

int main(int argc, char *argv[]) {
  
  int number = rand();
  srand(time(NULL));
  number = (rand() % 100) + 1;
  int right = 0;
  int nGuesses = 5;

  while (right == 0 && nGuesses != 0) {
    int guess;

    printf("Guess: \n");
    scanf("%d",&guess);

    if (guess == number) {
      right = 1;
      nGuesses--;
      printf("Right guess! You used %d/5 guesses\n",5-nGuesses);
      break;
    } else if (guess < number) {
      nGuesses--;
      printf("Higher. You have %d guesses left\n",nGuesses);
    } else {
      nGuesses--;
      printf("Lower. You have %d guesses left\n",nGuesses);
    }
    if (nGuesses == 0) {
      printf("The number was %d\n", number);
    }
  } 
  exit;
}