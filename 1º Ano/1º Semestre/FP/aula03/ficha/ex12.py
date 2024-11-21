# Escreva uma função countdown(N) que imprima uma contagem decrescente a partir de
# um número positivo N. Note que pode imprimir N e depois chamar countdown(N-1).
# Teste a função com diversos valores de N.

N = int(input("N? "))
def countdown(N):
    if N >= 0:
        print(N)
        countdown(N-1)
countdown(N)
