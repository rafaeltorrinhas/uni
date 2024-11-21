# 1. Pedir o tempo em segundos

segundos = int(input("Segundos? "))

# 2. Converter para horas, minutos e segundos

h = int(segundos // 3600)
m = int((segundos % 3600) // 60)
s = int((segundos % 3600) % 60)

# 3. Apresentar o resultado no formato hh:mm:ss

print("{:02d}:{:02d}:{:02d}".format(h, m, s))
