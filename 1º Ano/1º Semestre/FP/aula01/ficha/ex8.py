
#
import math

# 0. Ler dados

andar = int(input("Nº de andares: "))
moradores = int(input("Nº de moradores por andar: "))

# 1. fazer a soma de uma progressão aritmética em que o primeiro termo é 3 e a razão é 3

n = andar
razao = 3

u = 3 + (n - 1) * razao

soma = (3 + u) * n / 2

# 2. calcular a distância percorrida em um ano pelos moradores em metros
# (cada morador sobe e desce 2 vezes por dia)

distanciam = soma * moradores * 2 * 2                                                                                                                       

# 3. calcular o tempo que demora em segundos

tempos = distanciam

# 4. converter para km e horas

d = (distanciam / 1000) * 365 
t = (tempos / 3600) * 365

print("Distância percorrida em um ano: ", d , "km")
print("Tempo gasto em um ano: ", t , "horas")










