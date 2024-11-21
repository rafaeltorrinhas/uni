import numpy as np
import matplotlib.pyplot as plt


# 2. Um volante de badmington é batido à altura de 3 m (a partir do chão), com velocidade
# 200 km/h e a fazer um ângulo de 10º com a horizontal. Considerando que a velocidade
# terminal é 6.80 m/s,
# a) Faça o gráfico da trajetória (altura em função da distância percorrida na horizontal).
# b) Em ponto cai no chão e quanto demorou?


# t0 = 0.0
# tf = 2
# v0 = 55.6
# g = 9.8
# dt = 0.001
# theta0 = 10
# v_T = 6.8
# D = g/v_T ** 2
# t = np.arange(t0, tf, dt)

# v = np.zeros([2, np.size(t)])
# a = np.zeros([2, np.size(t)])
# r = np.zeros([2, np.size(t)])

# v[0] = v0


# v[:, 0] = v0 * np.array([np.cos(theta0), np.sin(theta0)])
# r[:, 0] = np.array([0.0, 3.0])
# a[1, :] = -g

# for i in range(np.size(t)-1):
#     a[0, i] = -D * np.linalg.norm(v) * v[0, i]
#     a[1, i] = -g - D * np.linalg.norm(v[:, i]) * v[1, i]
#     v[:, i + 1] = v[:, i] + a[:, i] * dt
#     r[:, i + 1] = v[:, i] + a[:, i] * dt


# plt.plot(r[0, :], r[1, :])
# plt.show()


import numpy as np
import matplotlib.pyplot as plt

g = 9.8
dt = 0.001
t0 = 0
tf = 1.5

vNorm = 200 * (1000 / 3600)  # de k/h para m/s
angle = 10 / 180 * np.pi  # de graus para radianos
vT = 6.80
D = g / vT**2

vXinitial = np.cos(angle) * vNorm
vYinitial = np.sin(angle) * vNorm

x0 = np.array([0, 3])
v0 = np.array([vXinitial, vYinitial])

n = int((tf-t0) / dt + 0.1)

shape = (n + 1, 2)

t = np.zeros(n + 1)

# passam para 2D
x = np.zeros(shape)
v = np.zeros(shape)
a = np.zeros(shape)
tRes = np.zeros(n + 1)
xRes = np.zeros(shape)
vRes = np.zeros(shape)
aRes = np.zeros(shape)

a[0] = np.array([0, -g])
v[0] = v0
t[0] = t0
x[0] = x0
aRes[0] = np.array([0, -g])
vRes[0] = v0
tRes[0] = t0
xRes[0] = x0

for i in range(n):

    a[i + 1] = np.array([0, -g])
    v[i + 1] = v[i] + a[i] * dt
    x[i + 1] = x[i] + v[i] * dt
    t[i + 1] = t[i] + dt

    vNorm = np.linalg.norm(vRes[i])
    # Cálculo da aceleração da resistência do ar
    aXRes = -D * vRes[i][0] * vNorm
    aYRes = -D * vRes[i][1] * vNorm

    aRes[i + 1] = np.array([aXRes, -g + aYRes])
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
    if xRes[i, 1] * xRes[i + 1, 1] < 0:
        idx = i
        break

xRange = xRes[idx, 0]
tRange = t[idx]

print(xRange)
print(tRange)
