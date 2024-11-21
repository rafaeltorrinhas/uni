# nmec 118956
import numpy as np
import matplotlib.pyplot as plt

t0 = 0.0
tf = 100.0
dt = 0.01

r0 = 0.0
v0 = 1.0

g = 9.8
P = 350.0
mu = 0.004
C_res = 0.9
rho_ar = 1.225
A = 0.35
m = 70.0

t = np.arange(t0, tf, dt)

a = np.zeros(np.size(t))
v = np.zeros(np.size(t))
r = np.zeros(np.size(t))
r[0] = r0
v[0] = v0

for i in range(np.size(t) - 1):
    a[i] = P / (m * v[i]) - C_res * A * rho_ar * v[i] ** 2 / (2 * m) - mu * g
    v[i + 1] = v[i] + a[i] * dt
    r[i + 1] = r[i] + v[i] * dt

plt.plot(t, v, 'b-')
plt.xlabel("Tempo decorrido, t [s]")
plt.ylabel("Velocidade, v [m/s]")
plt.show()

# a)

v_T = v[-1]
print("Velocidade terminal, v_T = {0:.4f} m/s".format(v_T))

# b)

x_k = r[r <= 500]
i_k = np.size(x_k)
t_k = t[i_k]
print(f"O tempo que leva a percorrer 500m é: {t_k:.2f} s")

# c)

x_k1 = r[r <= 200]
i_k1 = np.size(x_k1)
v_k1 = v[i_k]
perc = (v_k1/v_T) * 100
print(f"A velocidade quando atinge 200m é: {v_k1:.2f} m/s")
print(f"A percentagem da velocidade é: {perc:.2f} %")
