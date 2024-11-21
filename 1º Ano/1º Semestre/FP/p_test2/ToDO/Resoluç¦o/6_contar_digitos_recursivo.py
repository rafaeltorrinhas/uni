"""
Desenvolva uma função recursiva chamada contar_digitos_recursivo() que receba 
um número inteiro positivo e retorne a quantidade de dígitos que esse número possui.    
Por exemplo, para o número 12345, a função deve retornar 5. Se o número for negativo, 
a função deve tratar como se fosse positivo (ignorando o sinal).
"""

def contar_digitos_recursivo(n):
    """
    Conta o número de dígitos em um número inteiro positivo de forma recursiva.
    Se o número for negativo, ele é tratado como positivo.
    """
    n = abs(n)  # Tratar números negativos como positivos
    if n < 10:
        return 1
    else:
        return 1 + contar_digitos_recursivo(n // 10)

def main():
    testes_digitos = [12345, 7, 100000, -54321]
    resultados_digitos = {n: contar_digitos_recursivo(n) for n in testes_digitos}
    print(resultados_digitos) # Deve printar {12345: 5, 7: 1, 100000: 6, -54321: 5}

if __name__ == '__main__':
    main()