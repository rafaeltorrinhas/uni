import numpy as np
import matplotlib.pyplot as plt


t0 = 0.0
tf = 3.0
dt = 0.001
v0 = 0.0
x0 = 0.0
y0 = 0.0
M = 0.5
g = 9.8


def dydx_func(x: float) -> float:
    return -1 if x < 10.0 else 0.0


t = np.arange(t0, tf, dt)

a = np.zeros(np.size(t))

v = np.zeros(np.size(t))
v[0] = v0
# inicializar solução, posição [m]
s = np.zeros(np.size(t))
s[0] = x0
x = np.zeros(np.size(t))
y = np.zeros(np.size(t))
x[0] = x0
y[0] = y0
theta = np.zeros(np.size(t))

for i in range(np.size(t) - 1):
    # ângulo θ
    theta[i] = -np.arctan(dydx_func(x[i]))
    # aceleração
    a[i] = g * np.sin(theta[i])
    # Método de Euler-Cromer
    v[i + 1] = v[i] + a[i] * dt
    s[i + 1] = s[i] + v[i + 1] * dt
    # posição carteziana
    x[i + 1] = x[i] + (s[i + 1] - s[i]) * np.cos(theta[i])
    y[i + 1] = y[i] - (s[i + 1] - s[i]) * np.sin(theta[i])

E_p = M * g * y

plt.plot(t, E_p, 'b-')
plt.xlabel("t [s]")
plt.ylabel("Ep [J]")
plt.show()
