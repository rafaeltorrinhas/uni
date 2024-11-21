import numpy as np
import matplotlib.pyplot as plt

L = np.array([222.0, 207.5, 194.0, 171.5, 153.0, 133.0, 113.0, 92.0])
X = np.array([2.3, 2.2, 2.0, 1.8, 1.6, 1.4, 1.2, 1.0])

sum_x = np.sum(L)
sum_y = np.sum(X)
sum_xy = np.sum(L*X)
sum_xx = np.sum(L ** 2)
sum_yy = np.sum(X ** 2)

N = len(L)

m = ((N * sum_xy - sum_x * sum_y)/(N*(sum_xx)-((sum_x)**2)))
b = (((sum_xx * sum_y)-sum_x * sum_xy)/(N*sum_xx-((sum_x)**2)))
r2 = (N * sum_xy - sum_x * sum_y)**2 / \
    ((N * sum_xx - sum_x**2) * (N * sum_yy - sum_y**2))
dm = np.absolute(m) * np.sqrt((1/r2)-1)/((N-2))
db = dm * np.sqrt(sum_xx/N)
L1 = np.array([L.min(), L.max()])
X1 = m*L1 + b


def graph():
    plt.title("Graph")
    plt.xlabel("Distância da fenda ao alvo: L")
    plt.ylabel("Distância entre máximos: X")
    plt.scatter(L, X).set_color("red")
    # Gráfico 2
    plt.plot(L1, X1)
    plt.show()


def main():

    print(f"sum of x: {sum_x}")
    print(f"sum of y: {sum_y}")
    print(f"sum of x*y: {sum_xy}")
    print(f"sum of x^2: {sum_xx}")
    print(f"sum of y^2: {sum_yy}")
    print(f"m: {m:.8f}")
    print(f"b: {b:.8f}")
    print(f"r²: {r2:.8f}")
    print(f"dm: {dm:.8f}")
    print(f"db: {db:.8f}")
    graph()


main()
