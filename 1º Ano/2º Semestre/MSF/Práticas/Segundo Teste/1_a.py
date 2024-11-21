import numpy as np
import matplotlib.pyplot as plt

v = 100 / 3.6
ang = np.radians(16)
t0 = 0.0
tf = 1.6
g = 9.8
dt = 0.001

x0 = np.array([0, 0, 0])
v0x = v * np.cos(ang)
v0y = v * np.sin(ang)
v0z = 0
v0 = np.array([v0x, v0y, v0z])

n = int((tf-t0) / dt + 0.1)

shape = (n + 1, 3)

t = np.zeros(n + 1)

x = np.zeros(shape)
v = np.zeros(shape)
a = np.zeros(shape)

x[0] = np.array([0, 0, 0])
v[0] = np.array([v0x, v0y, 0])
a[0] = np.array([0, -g, 0])
t[0] = t0


for i in range(n):

    a[i + 1] = np.array([0, -g, 0])
    v[i + 1] = v[i] + a[i] * dt
    x[i + 1] = x[i] + v[i] * dt
    t[i + 1] = t[i] + dt

plt.plot(x[:, 0], x[:, 1])
plt.xlabel("x(t) (m)")
plt.ylabel("y(t) (m)")
plt.legend(loc="upper left")
plt.title("Trajetória")
plt.show()


for i in range(n):
    if x[i, 0] == 20 or (x[i, 0] - 20) * (x[i + 1, 0] - 20) < 0:
        idx = i
        break

height = x[idx, 1]

print("Passa a baliza na altura: {:.2f} m".format(height))

if 0 <= height <= 2.4:
    print("É golo.")
else:
    print("Não é golo.")
