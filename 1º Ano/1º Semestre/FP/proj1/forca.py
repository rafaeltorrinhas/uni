# coding: utf-8
# Preencha a lista com os números mecanográficos dos autores.
AUTORES = [118956, 119500]

import unidecode
import random
import os
# Defunções aqui.
forca = [
    
'''
______
|     
|     
|     
|     
|_____''',
'''
______
|  |   
|  0  
|       
|     
|_____''',
'''
______
|  |   
|  0  
|  |    
|     
|_____''',
'''
______
|  |   
|  0  
| /|    
|     
|_____''',
'''
______
|  |   
|  0  
| /|\\   
|     
|_____''',
'''
______
|  |   
|  0  
| /|\\   
| /   
|_____''',

'''
______
|  |   
|  0  
| /|\\   
| / \\ 
|_____''']

def clear():
    os.system("cls" if os.name == "nt" else "clear")

  

        
def game(certo,secret,errado):
    if  len(certo) < len(secret) and len(errado) < 6:
        return 1 
    elif len(errado) == 6:
        return 2
    elif len(certo) == len(secret):
        return 3

    

def main():
    from wordlist import words1, words2
    
    # Descomente a linha que interessar para testar
    #words = words1              # palavras sem acentos nem cedilhas.
    #words = words2             # palavras com acentos ou cedilhas.
    words = words1 + words2    # palavras de ambos os tipos
   
    import sys                  # INCLUA estas 3 linhas para permitir
    if len(sys.argv) > 1:       # correr o programa com palavras dadas:
         words = sys.argv[1:]    #   python3 forca.py duas palavras

        
    # Escolhe palavra aleatoriamente
    secret = random.choice(words).upper()
    c_secret = unidecode.unidecode(secret).upper()
    # Complete o programa
    errado = ''
    certo = ''
    esp = '_' * len(secret)              # espaços da resposta
    tent = ''                            # n de tentativas
    #print(secret) 


    while game(certo, secret, errado) == 1:
        
        for x in range(len(secret)):
            if secret[x] in certo:
                esp = esp[:x] + secret[x] + esp[x + 1:]
        print()
        print(forca[len(errado)])
        print("Letras erradas ({}):".format(len(errado)), ' '.join(errado))
        print(esp)
        guess = str(input("Letra:"))
        guess = unidecode.unidecode(guess.upper())
        

        if len(guess) > 1:
            print("Não pode ter mais que 1 letra.")
        elif len(guess) < 1:
            print("Por favor introduz uma letra.")
        elif guess in errado or guess in certo:
            print("Esta letra já foi usada.")
        elif guess not in 'AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZzÁáÀàÃãÂâÉéÈèÊêÍíÌìÎîÓóÒòÔôÕõÚúÙùÛûÇç':
            print("Tem que ser uma letra!")
        else:
            if guess in c_secret:
                tent += ' '
                for i in range(len(c_secret)):
                    if c_secret[i] == guess:
                        certo += secret[i]
            else:
                tent += ' '
                errado = errado + guess.strip()
                
                            

    if game(certo,secret,errado) == 3:
        print()
        print(forca[len(errado)])
        print("Letras erradas ({}):".format(len(errado)), ' '.join(errado))
        print(secret) 
        print("Acertaste em {} tentativas! A palavra era {}!".format(len(tent),secret))
    
    elif game(certo,secret,errado) == 2:    
        print()
        print(forca[len(errado)])
        print("Letras erradas ({}):".format(len(errado)), ' '.join(errado))
        print(esp) 
        print("Não conseguiste acertar, a palavra era {}.".format(secret))
        print("Acertaste {} letras.".format(len(certo)))


if __name__ == "__main__":
    primeiro = True  # Na primeira tentativa pergunta se quer começar o jogo
    while True:
        if primeiro:
            start = str(input("Começar o jogo (s/n)? "))
            primeiro = False  # Qualquer tentativa depois da primeira pergunta se quer continuar
        else:
            start = str(input("Continuar o jogo (s/n)? ")) 

        if start == "s":
            main()
            continue
        elif start == "n":
            print("Obrigado por jogares!")
            break
        else:
            print("Opção inválida.")
            continue
    exit
