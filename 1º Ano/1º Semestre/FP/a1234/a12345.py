def readfile():
  try:
    with open("ep1.csv", "r", encoding="utf-8") as file:
      lst = []
      cars = {}

      for i in file: 
        a = i.strip().split(";")
        lst.append(a)
        # print(lst)
      for j in lst:
        if j[2] not in cars:
          cars[j[2]] = []
        cars[j[2]].append((j[:-1]))
        # print( cars)
      return cars
    
  except FileNotFoundError:
    print("File not found.")

def printCars():
    cars = readfile()
    a = sorted(cars, key= lambda t: int(t))
    b = sorted(cars.values(), key= lambda t: t[0])
    count = 0
    for i in a:
        print(f"{i} : {b[count]}") 
        count += 1
    # print(b)

def printPlates():
  cars = readfile()
  a = sorted(cars, key= lambda t: int(t))
  b = sorted(cars.values(), key= lambda t: t[0])
  
  lst = []

  # por cada matricula das key numa lista em outra lista
  #   - acessar b e contar os objetos em b[i]
  #   - usar o primeiro objeto de cada b[i]
  print(b)  


# readfile()
# printCars()
printPlates()