"""
Crie uma função chamada elementos_unicos() que receba uma lista de listas e retorne um conjunto 
que contém todos os elementos que aparecem exatamente uma vez em todas as listas combinadas. 
Se um elemento aparecer mais de uma vez ao longo de todas as listas, ele não deve ser incluído no conjunto retornado.
Por exemplo, dado [[1, 2, 3], [3, 4, 5], [5, 6, 7]], 
a função deve retornar {1, 2, 4, 6, 7}, pois os números 3 e 5 aparecem mais de uma vez.

"""

def elementos_unicos(lista_de_listas):
    """
    Retorna um conjunto de elementos que aparecem exatamente uma vez em todas as listas combinadas.
    """
    contador_elementos = {}
    
    # Conta a frequência de cada elemento em todas as listas
    for lista in lista_de_listas:
        for elemento in lista:
            contador_elementos[elemento] = contador_elementos.get(elemento, 0) + 1

    # Seleciona elementos que aparecem apenas uma vez
    elementos_unicos = set()
    for key_elemento, value_frequencia in contador_elementos.items():
        if value_frequencia == 1:
            elementos_unicos.add(key_elemento)

    # Usando list comprehension
    # elementos_unicos = {key_elemento for key_elemento, value_frequencia in contador_elementos.items() if value_frequencia == 1}

    return elementos_unicos

def main():
    listas_teste = [[1, 2, 3], [3, 4, 5], [5, 6, 7]]
    print(elementos_unicos(listas_teste)) # Deve printar {1, 2, 4, 6, 7}

    listas_teste = [[1, 2, 3], [3, 4, 5], [5, 6, 7], [1, 2, 7]]
    print(elementos_unicos(listas_teste)) # Deve printar {4, 6}

if __name__ == '__main__':
    main()