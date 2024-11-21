"""
Escreva uma expressão que utilize uma função lambda para realizar a seguinte tarefa: 
dada uma lista de strings, retorne uma nova lista com cada string revertida e convertida para maiúsculas, 
mas apenas para aquelas strings que tenham um número ímpar de caracteres. 
As strings com um número par de caracteres devem permanecer inalteradas.
"""

# Lista de strings
lista_strings = ["Python", "is", "fun", "cool", "awesome"]

# Expressão lambda para transformar strings com número ímpar de caracteres
transformar_strings = lambda s: s[::-1].upper() if len(s) % 2 != 0 else s

# Aplicando a expressão lambda à lista

for i in range(len(lista_strings)):
    lista_strings[i] = transformar_strings(lista_strings[i])
#ou
"""
for i in lista_strings:
    lista_strings[lista_strings.index(i)] = transformar_strings(i)

#ou ainda
for i, s in enumerate(lista_strings):
    lista_strings[i] = transformar_strings(s)

"""

print(lista_strings)

# Deve printar ['Python', 'is', 'NUF', 'cool', 'EMOSEWA']


