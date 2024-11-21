# cobra 0.12€ / min a partir do 1º
# 1º min custa .12
# a partir do 1º min são .0.002€ por segundo/ 0.01€ a cada 5s
# programa que calcule o custo da chamada pelo tempo

# 1. Ler dados

sec = float(input("Segundos? "))

# 2. Calcular preço pelo tempo

if sec <= 60: 
    price = .12
else: price = .12 + (sec-60)*0.002
# 3. Dar o preço

print("Preço:", round(price,2), "€")