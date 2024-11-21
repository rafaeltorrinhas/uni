
print("Indique uma sequência de números reais:")

def seq():
  s = []
  x = str(input("nº:"))
  while x != "":
    s = s + [float(x)]
    seq()
    if False:
      break

    media = sum(s)/len(s)
  print("A média é:", media)
  

seq()



