# Frequencia da ocorrência de cada letra no documento pg3333.py
# Nome do ficheiro sys.argv




def main(file):


  try:
    with open(file, encoding="utf-8") as text:
      
      letters = {}

      for char in text.read():
        # se for letra, torna-a minuscula e adiciona á contagem 
        if char.isalpha():
          char = char.lower()
          letters[char] = letters.get(char, 0) + 1

      # Mete por ordem alfabética   
      
      letters_o = sorted(letters.items(), key=lambda t: t[1], reverse=True)
      # print das letras e do nº de letras do mesmo tipo no ficheiro
      for letter, count in letters_o:
        print(f"{letter}: {count}")


  except FileNotFoundError:
    print(f"Ficheiro {file} não encontrado")   

if __name__ == "__main__":  
  import sys
  if len(sys.argv) == 2:
    file = sys.argv[1]
    main(file)

  

