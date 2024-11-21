
n = int(input("Termos: "))
def leibnizPi4(n):
  soma = 0
  for i in range(n):
    valor = ((-1)**i)/(2*i+1)
    soma += valor
  return soma
print(leibnizPi4(n))
