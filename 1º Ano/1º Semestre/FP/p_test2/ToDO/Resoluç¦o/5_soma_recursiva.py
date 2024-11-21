"""Escreva uma função recursiva em Python chamada soma_recursiva 
que calcule a soma de todos os números inteiros de 1 até n, 
onde n é um parâmetro da função. 
Se n for menor ou igual a 0, a função deve retornar 0."""

def soma_recursiva(n):
    """
    Calcula a soma de todos os números inteiros de 1 até n de maneira recursiva.
    Se n for menor ou igual a 0, retorna 0.
    """
    if n <= 0:
        return 0
    else:
        return n + soma_recursiva(n - 1)

def main():
    testes = [5, 10, 0, -3, 1]
    resultados = {n: soma_recursiva(n) for n in testes}
    print(resultados)

if __name__ == '__main__':
    main()

