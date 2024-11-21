# método de Euler para descrever a dinâmica do movimento da ciclista, para assim calcular 
# a velocidade terminal, e estimar o instante de tempo

# a) velocidade terminal da ciclista 
# b) ao fim de quanto tempo atinge 90% da sua velocidade terminal?


import numpy as np
import matplotlib.pyplot as plt

t0 = 0.0 # condição inicial, tempo [s]
tf = 100.0 # limite do domínio, tempo final [s]
dt = 0.01 # passo [s]

r0 = 0.0 # condição inicial, posição inicial [m]
v0 = 1.0 # condição inicial, velocidade inicial [m/s]

g = 9.8 # aceleração gravítica [m/s^2]
P = 300.0 # Potência de propulsão [W]
mu = 0.004 # coeficiente de resistência do piso []
C_res = 0.9 # coeficiente de resistência do ar [s]
rho_ar = 1.225 # densidade do ar [kg/m3]
A = 0.3 # área frontal efetiva da ciclista [m2]
m = 65.0 # massa da ciclista (+ bicicleta) [kg]

# inicializar domínio temporal [s]
t = np.arange(t0, tf, dt)

# inicializar solução
a = np.zeros(np.size(t)) # aceleração [m/s2]
v = np.zeros(np.size(t)) # velocidade [m/s]
r = np.zeros(np.size(t)) # posição [m]
r[0] = r0
v[0] = v0

# método de Euler
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

v_filt = v[v < 0.9 * v_T]
i90 = np.size(v_filt)
t90 = t[i90]

print("Instante de tempo no qual a velocidade é 90% de v_T, t90 = {0:.2f} s".format(t90))
print("A velocidade correspondente a 90% de v_T é {0:.2f} s".format(0.9 * v_T))
print("A velocidade v(t90) é {0:.2f} m/s".format(v[i90]))  

