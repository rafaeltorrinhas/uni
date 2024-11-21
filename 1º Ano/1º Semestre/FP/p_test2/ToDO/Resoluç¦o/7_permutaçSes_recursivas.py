"""
Crie uma função recursiva chamada permutacoes_recursivas que receba uma string 
e retorne todas as permutações possíveis dessa string. 
Uma permutação é um rearranjo das letras da string.                                                                                                                    Por exemplo, as permutações da string "abc" seriam "abc", "acb", "bac", "bca", "cab", "cba". A função deve retornar uma estrutura que não contenha elementos repetidos.
Se for testada a string "aab" apenas deve ser retornado "aab", "aba", "baa"
"""

def permutacoes_recursivas(s):
    """
    Gera todas as permutações possíveis de uma string de forma recursiva.
    Retorna um conjunto (set) de strings com as permutações, garantindo que não haja duplicatas.
    """
    if len(s) == 1:
        return {s}

    permutacoes = set()
    for i, letra in enumerate(s):
        #Todas as permutações da string sem a letra atual
        permutacoes_resto = permutacoes_recursivas(s[:i] + s[i+1:])

        #Adiciona a letra atual a cada permutação do resto
        for permutacao in permutacoes_resto:
            permutacoes.add(letra + permutacao)

    return permutacoes


def main():
    exemplo = "abc"
    print(permutacoes_recursivas(exemplo))

    exemplo = "aab"
    print(permutacoes_recursivas(exemplo))

    exemplo = "aaa"
    print(permutacoes_recursivas(exemplo))


if __name__ == '__main__':
    main()