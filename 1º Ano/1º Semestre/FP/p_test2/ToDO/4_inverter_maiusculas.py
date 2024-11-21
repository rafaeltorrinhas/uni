"""
Escreva uma expressão que utilize uma função lambda para realizar a seguinte tarefa: 
dada uma lista de strings, retorne uma nova lista com cada string revertida e convertida para maiúsculas, 
mas apenas para aquelas strings que tenham um número ímpar de caracteres. 
As strings com um número par de caracteres devem permanecer inalteradas.
"""

# Lista de strings
lista_strings = ["Python", "is", "fun", "cool", "awesome"]
# se len lista_strings[i] // 2 != 0, inverter e por maiúscula
transform = lambda s: s[::-1].upper() if len(s) % 2 != 0 else s


for i in range(len(lista_strings)):
    lista_strings[i] = transform(lista_strings[i])

print(lista_strings)
# Deve printar ['Python', 'is', 'NUF', 'cool', 'EMOSEWA']