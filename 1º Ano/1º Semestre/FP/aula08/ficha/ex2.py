# O ficheiro names.txt tem uma lista de nomes completos de pessoas, com um nome
# por linha. Escreva um programa que mostre, para cada apelido (último nome), o conjunto
# de primeiros nomes encontrados na lista, sem repetições. O excerto abaixo é um exemplo
# do resultado pretendido. 
# Sugestão: construa um dicionário com chave = último nome e
# vá acrescentando os primeiros nomes ao conjunto associado a cada chave. Este é um
# problema que não se consegue reduzir facilmente a uma definição por compreensão
from tkinter import filedialog
def main():
    nome = {}
  # funçao para ir buscar os nomes
    nomes = filedialog.askopenfilename(title="Choose File")
    # fazer um dicionario com os apelidos (ultimos nomes)
    try:
        with open(nomes,"r") as file:
            pos = []
            apelido = []
            dic = {}
            for line in file:
                div = str.split(line)
                pos = [len(div)]
                apelido = [div[pos[i]-1] for i in range(len(pos))]
                dic[div[0]].append(apelido)
            print(nome())
    except FileNotFoundError:
        print("Ficheiro inválido.")
    
    ap = int(input("Apelido: "))

    
if __name__ == '__main__':
  main()