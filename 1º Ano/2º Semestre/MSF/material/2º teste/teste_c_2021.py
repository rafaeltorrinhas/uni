
import numpy as np
import matplotlib.pyplot as plt


t0 = 0.0
tf = 12
step = 0.001
g = 9.8
m = 0.057
w_res_ar = 0


g_vect = np.array([0, -g])

n_steps = int((tf - t0) / step + 1)


vt = 100 * 1000 / 3600

D = g / vt ** 2

v0_norm = 140 * 1000 / 3600

t = np.linspace(t0, tf, n_steps)
p = np.zeros((n_steps, 2))
v = np.zeros((n_steps, 2))
a = np.zeros((n_steps, 2))
f_res_ar = np.zeros((n_steps, 2))
count = 0


p[0] = np.array([0, 0])
v[0] = np.array([np.cos(np.radians(7)) * v0_norm,
                np.sin(np.radians(7)) * v0_norm])
a[0] = np.array([0, -g])


while p[count, 1] >= 0 and count < n_steps-1:

    v_norm = np.linalg.norm(v[count])

    f_res_ar[count] = -D * v_norm * v[count] * m

    acel_resist = -D * v_norm * v[count]
    a[count + 1] = acel_resist + g_vect

    p[count + 1] = p[count] + v[count] * step
    v[count + 1] = v[count] + a[count] * step

    w_res_ar += (np.dot(f_res_ar[count], v[count]) +
                 np.dot(f_res_ar[count+1], v[count+1]) / 2) * step

    count += 1


# sum([(np.dot(f[i], v[i]) + np.dot(f[i+1], v[i+1]))/2 * dt for i in range(len(v)-1)])


print(f"Chão em x = {p[count, 0]:.2f} m, t = {t[count]:.2f} s")
print(f"Trabalho da Força de Resistência do Ar: {w_res_ar}")
-1
plt.plot(p[:count, 0], p[:count, 1])
plt.show()


for i in range(n_steps):
    if p[i, 1] * p[i + 1, 1] < 0:
        idx = i
        break

xRange = p[idx, 0]
tRange = t[idx]

print(xRange)
print(tRange)

# import numpy as np
# import matplotlib.pyplot as plt

# g = 9.8
# dt = 0.001
# t0 = 0
# tf = 1.5

# vNorm = 140 * (1000 / 3600)  # de k/h para m/s
# angle = np.radians(7)
# vT = 6.80
# D = g / vT**2

# vXinitial = np.cos(angle) * vNorm
# vYinitial = np.sin(angle) * vNorm

# x0 = np.array([0, 0])
# v0 = np.array([vXinitial, vYinitial])

# n = int((tf-t0) / dt + 0.1)

# shape = (n + 1, 2)

# t = np.zeros(n + 1)

# # passam para 2D
# x = np.zeros(shape)
# v = np.zeros(shape)
# a = np.zeros(shape)
# tRes = np.zeros(n + 1)
# xRes = np.zeros(shape)
# vRes = np.zeros(shape)
# aRes = np.zeros(shape)

# a[0] = np.array([0, -g])
# v[0] = v0
# t[0] = t0
# x[0] = x0
# aRes[0] = np.array([0, -g])
# vRes[0] = v0
# tRes[0] = t0
# xRes[0] = x0

# for i in range(n):

#     a[i + 1] = np.array([0, -g])
#     v[i + 1] = v[i] + a[i] * dt
#     x[i + 1] = x[i] + v[i] * dt
#     t[i + 1] = t[i] + dt

#     vNorm = np.linalg.norm(vRes[i])
#     # Cálculo da aceleração da resistência do ar
#     aXRes = -D * vRes[i][0] * vNorm
#     aYRes = -D * vRes[i][1] * vNorm

#     aRes[i + 1] = np.array([aXRes, -g + aYRes])
#     vRes[i + 1] = vRes[i] + aRes[i] * dt
#     xRes[i + 1] = xRes[i] + vRes[i + 1] * dt
#     tRes[i + 1] = tRes[i] + dt


# plt.plot(xRes[:, 0], xRes[:, 1], label="Com resistência")
# plt.xlabel("x(t) (m)")
# plt.ylabel("y(t) (m)")
# plt.legend(loc="upper left")
# plt.title("Trajetória")
# plt.show()


# for i in range(n):
#     if xRes[i, 1] * xRes[i + 1, 1] < 0:
#         idx = i
#         break

# xRange = xRes[idx, 0]
# tRange = t[idx]

# print(xRange)
# print(tRange)
