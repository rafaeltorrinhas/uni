import matplotlib.pyplot as plt
import numpy as np

tf = 1
t0 = 0
dt = 0.001
g = 9.8
vT = 20
D = g / vT**2

n = int((tf-t0) / dt + 0.1)

shape = (n + 1, 3)

t = np.zeros(n + 1)

# passam para 2D
x = np.zeros(shape)
v = np.zeros(shape)
a = np.zeros(shape)

x[0] = np.array([0, 3, 0])
v[0] = np.array([30, 0, 0])
a[0] = np.array([0, -g, 0])
t[0] = t0

tRes = np.zeros(n + 1)
xRes = np.zeros(shape)
vRes = np.zeros(shape)
aRes = np.zeros(shape)

aRes[0] = np.array([0, -g, 0])
vRes[0] = np.array([30, 0, 0])
tRes[0] = t0
xRes[0] = np.array([0, 3, 0])


for i in range(n):

    a[i + 1] = np.array([0, -g, 0])
    v[i + 1] = v[i] + a[i] * dt
    x[i + 1] = x[i] + v[i] * dt
    t[i + 1] = t[i] + dt

    vNorm = np.linalg.norm(vRes[i])
    # Cálculo da aceleração da resistência do ar
    aXRes = -D * vRes[i][0] * vNorm
    aYRes = -D * vRes[i][1] * vNorm
    aZRes = -D * vRes[i][2] * vNorm

    aRes[i + 1] = np.array([aXRes, -g + aYRes, aZRes])
    vRes[i + 1] = vRes[i] + aRes[i] * dt
    xRes[i + 1] = xRes[i] + vRes[i + 1] * dt
    tRes[i + 1] = tRes[i] + dt

plt.plot(xRes[:, 0], xRes[:, 1], label="Com resistência")
plt.xlabel("x(t) (m)")
plt.ylabel("y(t) (m)")
plt.legend(loc="upper left")
plt.title("Trajetória")
plt.show()

for i in range(n):
    if xRes[i, 1] == 0 or xRes[i, 1] * xRes[i + 1, 1] < 0:
        idx = i
        break


print("Chega ao chão na posição: {:.2f}".format(xRes[idx, 0]))

if 12 <= xRes[idx, 0] <= 18.4:
    print("Serviço válido.")
else:
    print("Serviço inválido.")
