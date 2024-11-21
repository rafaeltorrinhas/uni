import numpy as np
import matplotlib.pyplot as plt

t0 = 0
tf = 1
v = 100 / 3.6
theta = 10
dt = 0.001
g = 9.8


x0 = np.array([0, 0])
v0x = v * np.cos(10)
v0y = v * np.sin(10)
v0 = np.array([v0x, v0y])

n = int((tf-t0) / dt + 0.1)

shape = (n + 1, 2)

t = np.zeros(n + 1)
x = np.zeros(shape)
v = np.zeros(shape)
a = np.zeros(shape)

a[0] = np.array([0, -g])
v[0] = v0
t[0] = t0
x[0] = x0

for i in range(n):

    a[i + 1] = np.array([0, -g])
    v[i + 1] = np.array([v0x, v[i, 1] - g * dt])
    x[i + 1] = x[i] + v[i] * dt
    t[i + 1] = t[i] + dt


plt.plot(x[:, 0], x[:, 1])
plt.xlabel("x(t) (m)")
plt.ylabel("y(t) (m)")
plt.legend(loc="upper left")
plt.title("Trajetória")
plt.show()
