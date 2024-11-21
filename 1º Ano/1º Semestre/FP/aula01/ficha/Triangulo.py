import math

# 1. Atribuir valor aos catetos A e B

a = float(input("Comprimento A: "))
b = float(input("Comprimento B: "))

# 2. Determinar hipotenusa

c = math.hypot(a,b) 


# 3. Determinar o valor do ângulo entre A e a hipotenusa

d = math.degrees(math.asin(a/c))

# 4. Print dos valores

print("Hipotenusa: {} e ângulo {}º".format(c,d))