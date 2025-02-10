
def readcsv(fname):
    with open(fname, 'r') as file:
        dicionario = {}
        for line in file:
            line = line.strip().split(";")
            if int(line[-1]) not in dicionario.keys():
                dicionario[int(line[-1])] = []
            dicionario[int(line[-1])].append(tuple(line[:-1]))
        return dicionario


def printVeichles(dicionario):
    dicionario = dict(sorted(dicionario.items()))
    for key, value in dicionario.items():
        value = sorted(value, key=lambda x: x[1])
        for i in range(len(value)):
            print(f"{key} : {value[i]}")


def printPlates(dicionario):
    for key, value in dicionario.items():
        lst = []
        value = sorted(value, key=lambda x: x[1])
        for i in range(len(value)):
            lst.append(value[i][0])
        print(f"{key} : {lst}")


def checkPlate(plate):
    if not plate[:2].isdigit() or not plate[3:5].isalpha() or not plate[-2:]:
        print("Matrícula inválida")
        return False
    elif not plate[2] == "-" or not plate[-3] == "-":
        print("Matrícula inválida")
        return False
    else:
        return True


def infoParking():
    while True:
        plate = str(input("\nMatrícula? "))
        if checkPlate(plate):
            break
    while True:
        duracao = input("\nDuração? ")

        try:
            duracao = int(duracao)
            if duracao < 0:
                print("Inválida")
                continue
            break
        except ValueError:
            print("Inválida.")
    return (plate, duracao)


def main():
    dicionario = readcsv("a1234/ep1.csv")
    printVeichles(dicionario)
    print("\n")
    printPlates(dicionario)
    # print(checkPlate())
    # print(infoParking())


main()
