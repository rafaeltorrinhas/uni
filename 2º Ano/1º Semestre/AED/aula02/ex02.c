#include <stdio.h>
#include <string.h>


int my_isalpha(char str) {
  return ((str >= 'A' && str <= 'Z') || (str >= 'a' && str <= 'z'));
}

int my_isupper(char str) {
  return (str >= 'A' && str <= 'Z');
}

char my_tolower(char char1) {
  char lower[] = "abcdefghijklmnopqrstuvwxyzç";
  char upper[] = "ABCDEFGHIJKLMNOPQRSTUVWXYZÇ";

  for (long unsigned int i = 0; i < strlen(upper); i++) {
    if (char1 == upper[i]) {
      return lower[i];
    }
  }
  return char1;
}

void sortString(char* str) {
  for (unsigned int i = 0; i < strlen(str) - 1; i++){
    for (unsigned int j = 0; j < strlen(str) - i - 1; j++) {
      if (str[j] > str[j + 1]) {
        char temp = str[j];
        str[j] = str[j + 1];
        str[j + 1] = temp;
      }
    }
  }
}

int main(void){ 

  char str[60];
  char str2[30];
  char str3[30] = {0};
  char str4[30] = {0};

  scanf("%s", str);
  scanf("%s", str2);
  
  char str_backup[60];
  char str2_backup[30];
  strcpy(str_backup, str); 
  strcpy(str2_backup, str2);

  int count = 0;
  int count2 = 0;
  
  for (unsigned int i = 0; i < strlen(str); i++) {
    if (my_isalpha(str[i])) {
      count++;    
    }
    if (my_isupper(str[i])){
      str3[i] = my_tolower(str[i]);
    } else { 
      str3[i] = str[i];
    }
  }
  

  str3[strlen(str)] = '\0';

  printf("Nº de caracteres que são letras na 1ª string: %d\n", count);

  for (long unsigned int j = 0; j < strlen(str2); j++) {
    if (my_isupper(str2[j])){
      count2++;
    }
    
    if (my_isupper(str2[j])) {
      str4[j] = my_tolower(str2[j]);
    } else { 
      str4[j] = str2[j];
    }
  }

  str4[strlen(str2)] = '\0';

  printf("Nº de caracteres que são letras maiúsculas na 2ª string: %d\n", count2);
  
  printf("String 1 em lowercase: %s\n", str3);
  printf("String 2 em lowercase: %s\n", str4);
  
  if (strcmp(str,str2) == 0){
    printf("As strings em lower case são iguais.");
  } else { 
    sortString(str);
    sortString(str2);
    printf("String 1 ordem lexicográfica: %s\n", str);
    printf("String 2 ordem lexicográfica: %s\n", str2);
  }

  char str2_copy[30];
  strcpy(str2_copy,str2_backup);
  printf("Cópia da string 2: %s\n",str2_copy);
  
  strcat(str2_backup,str2_copy);
  printf("String concatenada: %s\n",str_backup);
}