import numpy as np
import matplotlib.pyplot as plt

# 1

t0 = 0
tf = 0.5
dt = 0.001

r0 = np.array([0.0, 2.0, 3.0])
v0 = np.array([160, 20, -20])

g = 9.8
v_T = np.linalg.norm(v0)
D = g/v_T ** 2

N = int((tf-t0) / dt + 1)
t = np.linspace(t0, tf, num=N)

a = np.zeros([np.size(t), 3])
a_res = np.zeros([np.size(t), 3])
a_grv = np.zeros([np.size(t), 3])

v = np.zeros([np.size(t), 3])
v[0, :] = v0

r = np.zeros([np.size(t), 3])
r[0, :] = r0

for i in range(np.size(t)-1):
    a_grv[i, :] = -g * np.array([0, 0, 1])
    a_res[i, :] = -D * np.linalg.norm(v[i, :]) * v[i, :]
    a[i, :] = a_grv[i, :] + a_res[i, :]
    v[i+1, :] = v[i, :] + a[i, :] * dt
    r[i+1, :] = r[i, :] + v[i, :] * dt

# 2
fig = plt.figure(figsize=(10, 10))
# ax = plt.axes(projection="3d")

x0 = 0
x1 = 18.3-11.9
x2 = 11.9
x3 = 18.3
x4 = 2 * 11.9
y0 = 0
y1 = 4.1
y2 = 8.2
z0 = 0.0
z1 = 1.0

i_ts = np.size(r[r[:, 2] > 0], 0) - 1
ts = t[i_ts]
rs = r[i_ts, :]


# 3


M = 0.057
v_norm = np.linalg.norm(v, axis=1)
E_p = M * g * r[0:i_ts, 2]
E_c = .5 * M * v_norm[0:i_ts] ** 2
E_m = E_p + E_c
plt.plot(t[0:i_ts], E_p, "r-", t[0:i_ts], E_c, "g-", t[0:i_ts], E_m, "b")
plt.legend(["E_p", "E_c", "E_m"])
plt.xlabel("t [s]")
plt.ylabel("Energia [J]")
plt.show()


def integral(f, D, a, b):
    dt = (D[1] - D[0]) / len(f)
    i_a = int((a-D[0]) / dt)
    i_b = int((b-D[0]) / dt)
    sum = 0.0

    for i in range(i_a, i_b):
        sum += (f[i] + f[i+1]) / 2 * dt
    return sum


t1 = 0.2
t2 = 0.4
D = np.array([t0, tf])
F_res = M * a_res
f_dot_v = np.sum(F_res * v, axis=1)
w0 = integral(f_dot_v, D, t0, t0)
w1 = integral(f_dot_v, D, t0, t1)
w2 = integral(f_dot_v, D, t0, t2)


print("Wres(t0 = 0.1s) = {0:.2f} J".format(w0))
print("Wres(t0 = 0.2s) = {0:.2f} J".format(w1))
print("Wres(t0 = 0.4s) = {0:.2f} J".format(w2))
