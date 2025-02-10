import csv


def openFile(fname):
    with open(fname, 'r') as file:
        next(file)
        f = csv.reader(file)
        lst = []
        for line in f:
            lst.append(tuple(line))
    return lst


def getCountry(country, lst):
    for i in lst:
        if i[2].lower() == country.lower():
            print(f"{i[1]:<30}{i[0]:^10}{i[3]:>10}")
    return (country, lst)


def writeFile(fname, country, lst):
    with open(fname, 'w') as file:
        for i in lst:
            if i[2].lower() == country.lower():
                file.write(f"{i[1]:<30}{i[0]:^10}{i[3]:>10}\n")


def dictCreate(lst):
    dict = {}
    for i in lst:
        if i[2] in dict.keys():
            dict[i[2]].append(i[1])
        else:
            dict[i[2]] = [i[1]]
    return dict


def getBiggest(lst):
    lst = sorted(lst, key=lambda x: (x[-1] != '+', -int(x[-3])))
    # print(lst)
    return lst[0]


def getClub(club, lst):
    isPart = False
    for i in lst:
        if i[1] == club:
            print(i)
            isPart = True
    if not isPart:
        print("ERRO: Equipa não encontrada.")


def getRanking(lst):
    sumval = 0
    dict1 = dictCreate(lst)
    teamlist = []
    for country in dict1.keys():
        teams = dict1[country]
        for i in teams:
            for j in lst:
                if j[1] == i:
                    sumval += int(j[3])

        teamlist.append([sumval/len(teams), country])

    print(teamlist)


def main():
    lst = openFile("Soccer_Football_Clubs_Ranking.csv")
    getCountry("Switzerland", lst)
    writeFile("results.txt", "Switzerland", lst)
    dictCreate(lst)
    print(getBiggest(lst))
    getClub("Casa Pia", lst)
    print(getRanking("England", lst))


main()
