# Função que faça o max entre 2 numeros sem usar componente max


def max2(x, y):
    if x > y:
        return x
    else:
        return y


# Give the max between 3 numbers without max, if, and conditional expressions using only max2
def max3(x, y, z):
    return max2(x, max2(y, z))


def main():
    x = float(input("1º Número? "))
    y = float(input("2º Número? "))
    z = float(input("3º Número? "))

    # print(max2(x, y))
    print(max3(x, y, z))


if __name__ == "__main__":
    main()

# main()
