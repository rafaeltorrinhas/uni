def inputFloatList():
    number = ""
    lst = []

    while True:
        number = input("Number:")
        if number == "":
            break
        lst.append(float(number))

    return lst


a = inputFloatList()


def countLower(lst, v):
    count = 0
    for i in lst:
        if i < v:
            count += 1
    return count


b = countLower(a, 10)
print(b)


def minmax(lst):
    min = lst[0]
    max = lst[0]
    for i in lst:
        if i < min:
            min = i
        elif i > max:
            max = i
    return f"{min} / {max}"


print(minmax(a))
