#include <stdio.h> 
 
int main( void ) 
{ 
  char firstName[30];
  char lastName[30];

  printf("Enter your first name: ");
  scanf("%29s", firstName);

  printf("Enter your last name: ");
  scanf("%29s", lastName);

  printf("Hello %s %s!\n", firstName, lastName);
 return 0; 
} 