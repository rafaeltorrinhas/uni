# 1
def recieve():
    filename = "Soccer_Football Clubs Ranking.csv"
    try:
        with open(filename, "r", encoding="utf-8") as file:
            lst = []
            for line in file:
                lst.append(tuple(line.strip().split(",")))
                lst2 = lst[1:]
            return (lst2)
    except FileNotFoundError:
        print("File not found.")
# 2


def isCountry():
    lst2 = recieve()
    country = input("Country: ")
    for i in lst2:
        if i[2].lower() == country.lower():
            print(f"{i[0]}, {i[1]}, {i[3]}")
    return country
# 3


def printReturn():
    file2name = "return.txt"
    lst2 = recieve()
    country = isCountry()
    try:
        with open(file2name, "w", encoding="utf-8") as file:
            for i in lst2:
                if i[2].lower() == country.lower():
                    file.write(f"{i[0]}, {i[1]}, {i[3]}\n")

    except FileNotFoundError:
        print("File not found.")
# 4


def dictCountry():
    lst2 = recieve()
    countries = {}
    for i in lst2:
        countries[i[2]] = countries.get(i[2], []) + [i[1]]

    return countries
# 5


def rankup():
    lst2 = recieve()
    lst = []
    for i in lst2:
        if i[-1] == "+":
            lst.append(i)
    slist = sorted(lst, key=lambda t: int(t[-3]), reverse=True)
    return slist[0]
# 6


def printClub():
    lst2 = recieve()
    clist = [i[1].lower() for i in lst2]
    while True:
        club = input("Club: ")
        if club.lower() in clist:
            for i in lst2:
                if club.lower() in i[1].lower():
                    print(i)
                    break
        else:
            print("Club not found.")
            continue
# 7 #8


def medRank():
    lst2 = recieve()
    countries = {}
    lst = []
    for i in lst2:
        countries[i[2]] = countries.get(i[2], []) + [i[0]]

    for i in countries:
        counter = 0
        total = 0
        for j in countries[i]:
            total += int(j)
            counter += 1
        lst.append([i, total/counter])

    sortedlist = sorted(lst, key=lambda t: t[1])
    for i in sortedlist:
        print(f"{i} \n")

# addon


def kill(item):
    print(item)
# 9


def main():
    print("\nOpções:\n1. Recolher os dados do ficheiro.\n2. Pesquisar pelo país.\n3. Exportar os dados pesquisados para csv\n4. Receber lista e criar um dicionário.\n5. Clube que mais subiu no ranking.\n6. Pesquisar por clube.\n7. Ranking médio de cada um dos países.\n")
    while True:
        option = input("Opção (0-9)?\n")
        if option == "0":
            exit()
        elif option == "1":
            recieve()
            break
        elif option == "2":
            isCountry()
            break
        elif option == "3":
            printReturn()
            break
        elif option == "4":
            dictCountry()
            break
        elif option == "5":
            rankup()
            break
        elif option == "6":
            printClub()
            break
        elif option == "7":
            medRank()
            break
        else:
            print("Opção inválida.")


if __name__ == "__main__":
    main()
