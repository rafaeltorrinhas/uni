
# O algoritmo de Euclides para determinar o máximo divisor comum de dois números naturais
#baseia-se na igualdade seguinte: mdc(a,b) = b se r=0 ou mdc(b,r) se r>0
# onde é o resto da divisão de por . Escreva uma função para calcular o m.d.c. e teste-a com𝑟𝑎𝑏
# diversos pares de valores.

a = float(input("Número 1: "))
b = float(input("Número 2: "))

def mdc(a,b):
    if a % b == 0:
        return b
    elif a % b > 0:
        return(mdc(b, a % b))
    
def main():
    if mdc(a,b) == b:
        print(b)
    else:
        print(mdc(b, a % b))

if __name__ == "__main__":
    main()

    

    

    



