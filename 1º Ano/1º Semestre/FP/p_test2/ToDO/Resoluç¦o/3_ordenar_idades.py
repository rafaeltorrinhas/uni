"""
Escreva uma única expressão que use uma função lambda 
para ordenar uma lista de tuplos.
Cada tuplo contém dois elementos: um nome (string) e uma idade (inteiro). 
A lista deve ser ordenada pela idade, do mais jovem para o mais velho.
Por exemplo, dada a lista [("João", 25), ("Ana", 20), ("Miguel", 30)], 
a expressão deve retornar [("Ana", 20), ("João", 25), ("Miguel ", 30)].
"""

# Lista de tuplos com nome e idade
lista_pessoas = [("João", 25), ("Ana", 20), ("Carlos", 30)]

# Usa uma expressão lambda para ordenar pela idade
lista_ordenada = sorted(lista_pessoas, key=lambda x: x[1]) # x[1] é a idade

print(lista_ordenada) # Deve printar [('Ana', 20), ('João', 25), ('Carlos', 30)]