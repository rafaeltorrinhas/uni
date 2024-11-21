# nmec 118956
import numpy as np
import matplotlib.pyplot as plt


# a)


t0 = 0.0
tf = 300.0
dt = 0.001

x0 = 0.2
v0 = 0.0

m = 2.0
k = .5
b = 0.2
F_0 = 0
w_f = 0


t = np.arange(t0, tf, dt)


a = np.zeros(np.size(t))
v = np.zeros(np.size(t))
x = np.zeros(np.size(t))
x[0] = x0
v[0] = v0

for i in range(np.size(t) - 1):
    a[i] = - (k * x[i] + b * v[i] - F_0 * np.cos(w_f * t[i])) / m
    v[i + 1] = v[i] + a[i] * dt
    x[i + 1] = x[i] + v[i+1] * dt

plt.plot(t, x, 'b-')
plt.xlabel("Tempo decorrido, t [s]")
plt.ylabel("Posição, x [m]")
plt.show()

plt.plot(t, v, 'r-')
plt.xlabel("Tempo decorrido, t [s]")
plt.ylabel("Velocidade, v [m/s]")
plt.show()


# b)

w_f = 1
t1 = np.arange(t0, tf, dt)

a = np.zeros(np.size(t))
v = np.zeros(np.size(t))
x = np.zeros(np.size(t))
x[0] = x0
v[0] = v0


for i in range(np.size(t) - 1):
    F_0 = 5 * np.cos(w_f * t[i])
    a[i] = - (k * x[i] + b * v[i] - F_0 * np.cos(w_f * t1[i])) / m
    v[i + 1] = v[i] + a[i] * dt
    x[i + 1] = x[i] + v[i+1] * dt


t_max = np.array([])
x_max = np.array([])


def maxminv(x0, x1, x2, y0, y1, y2):
    xab = x0 - x1
    xac = x0 - x2
    xbc = x1 - x2
    a = y0 / (xab * xac)
    b = -y1 / (xab * xbc)
    c = y2 / (xac * xbc)
    xmla = (b + c) * x0 + (a + c) * x1 + (a + b) * x2
    xm = 0.5 * xmla / (a + b + c)
    xta = xm - x0
    xtb = xm - x1
    xtc = xm - x2
    ymax = a * xtb * xtc + b * xta * xtc + c * xta * xtb
    return xm, ymax


for i in range(0, np.size(t) - 3, 2):

    tm, xm = maxminv(t[i], t[i+1], t[i+2], x[i], x[i+1], x[i+2])

    if t[i] < tm and tm < t[i+2]:

        if xm > np.maximum(x[i], x[i+2]):
            t_max = np.append(t_max, tm)
            x_max = np.append(x_max, xm)


fig, ax1 = plt.subplots()
ax1.set_xlabel('Tempo decorrido, t [s]')
ax1.set_ylabel('Amplitude, x_max [m]', color='blue')
ax1.tick_params(axis='y', labelcolor='blue')
ax1.plot(t_max, x_max, 'p-')
plt.show()

print(
    "A amplitude em regime estacionário é x_max = {0:.2f} m".format(x_max[-1]))


# c)

w_f = 0.5

t1 = np.arange(t0, tf, dt)

a = np.zeros(np.size(t))
v = np.zeros(np.size(t))
x = np.zeros(np.size(t))
x[0] = x0
v[0] = v0


for i in range(np.size(t) - 1):

    F_0 = 5*(np.cos(w_f * t[i]))
    a[i] = - (k * x[i] + b * v[i] - F_0 * np.cos(w_f * t1[i])) / m
    v[i + 1] = v[i] + a[i] * dt
    x[i + 1] = x[i] + v[i+1] * dt


t_max = np.array([])
x_max = np.array([])


def maxminv(x0, x1, x2, y0, y1, y2):
    xab = x0 - x1
    xac = x0 - x2
    xbc = x1 - x2
    a = y0 / (xab * xac)
    b = -y1 / (xab * xbc)
    c = y2 / (xac * xbc)
    xmla = (b + c) * x0 + (a + c) * x1 + (a + b) * x2
    xm = 0.5 * xmla / (a + b + c)
    xta = xm - x0
    xtb = xm - x1
    xtc = xm - x2
    ymax = a * xtb * xtc + b * xta * xtc + c * xta * xtb
    return xm, ymax


for i in range(0, np.size(t) - 3, 2):

    tm, xm = maxminv(t[i], t[i+1], t[i+2], x[i], x[i+1], x[i+2])

    if t[i] < tm and tm < t[i+2]:

        if xm > np.maximum(x[i], x[i+2]):
            t_max = np.append(t_max, tm)
            x_max = np.append(x_max, xm)

fig, ax1 = plt.subplots()
ax1.set_xlabel('Tempo decorrido, t [s]')
ax1.set_ylabel('Amplitude, x_max [m]', color='blue')
ax1.tick_params(axis='y', labelcolor='blue')
ax1.plot(t_max, x_max, 'g-')
plt.show()

print(
    "A amplitude em regime estacionário é x_max = {0:.2f} m".format(x_max[-1]))
