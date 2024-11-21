# 1) Registar chamada
# 2) Ler ficheiros
# 3) Listar clientes
# 4) Fatura
# 5) Terminar

# 1
def regCall():
  while True:
    
    telO = (input("Telefone origem? "))

    print(telO[0])
    if telO.startswith and telO[1:].isdigit() or telO.isdigit():
      if len(telO) >= 3:
        break
      else:
        print("\nO número de telefone origem é inválido. Tente outra vez.\n")
        continue
    else:
        print("\nO número de telefone origem é inválido. Tente outra vez.\n")
        continue

  while True:

    telD = input("Telefone destino? ")
    
    if telD.startswith and telD[1:].isdigit() or telD.isdigit():
      if len(telD) >= 3 and telD.isdigit():
        break
      else:
        print("\nO número de telefone destino é inválido. Tente outra vez.\n")
        continue
    else:
      print("\nO número de telefone destino é inválido. Tente outra vez.\n")
      continue
  
  while True:

    dur = input("Duração (s)? ")
    if dur.isdigit():
      break
    else:
      print("Duração inválida. Tente outra vez.")
      continue

def fileRead():
  
  try:
    fileName = input("Indique o nome do ficheiro : ")
    with open(f"{fileName}", "r") as file:
      lines = file.readlines()
      numeros = [line.strip() for line in lines]
      numero = [i.split("\t") for i in numeros]
      for n in range(len(numero)):
        print(f"Telefone origem: {numero[n][0]}")
        print(f"Telefone destino: {numero[n][1]}")
        print(f"Duração (s): {numero[n][2]}\n")
  except FileNotFoundError:
    print("Ficheiro não encontrado")

def clientsList():
  try:
    fileName = input("Indique o nome do ficheiro : ")
    with open(f"{fileName}", "r") as file:
      lines = file.readlines()
      numeros = [line.strip() for line in lines]
      numero = [i.split("\t") for i in numeros]
      print("Clientes:")
      for n in range(len(numero)):
        print(numero[n][0])
  except FileNotFoundError:
    print("Ficheiro não encontrado")

def detailedInvoice():
  try:
    fileName = input("Indique o nome do ficheiro : ")
    with open(f"{fileName}", "r") as file:
      lines = file.readlines()
      numeros = [line.strip() for line in lines]
      numero = [i.split("\t") for i in numeros]
      
    client = input("Cliente?")
    print("Destino          Duração     Custo")
    for n in range(len(numero)):
      time = int(numero[n][2])/60
      if numero[n][0] == client:
        price = 0.1*time              #errado <----
        if numero[n][0][:2] == numero[n][1][:2]:
          price = 0.04*time
        elif numero[n][1][0] == "+":
          price = 0.8*time
        elif numero[n][1][0] == "2":
          price = 0.02*time
        print(f"{numero[n][1]}          {numero[n][2]}       {price}")
      else:
        print("Cliente não encontrado.")
  except FileNotFoundError:
    print("Ficheiro não encontrado")
  


def main():
  # Menu
  print("1) Registar chamada ")
  print("2) Ler ficheiros ")
  print("3) Listar clientes ")
  print("4) Fatura ")
  print("5) Terminar ")
  op = input("Opção?\n")
  while True:
    if op == "1":
      regCall()
      break
    elif op == "2":
      fileRead()
      break
    elif op == "3":
      clientsList()
      break
    elif op == "4":
      detailedInvoice()
      break
    elif op == "5":
      exit()
    else:
      print("Opção inválida")

if __name__ == '__main__':
  main()