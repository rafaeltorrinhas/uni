import numpy as np
import matplotlib.pyplot as plt

t0 = 0.0 # condição inicial, tempo [s]
tf = 100.0 # limite do domínio, tempo final [s]
dt = 0.001 # passo [s]
x0 = 1.0001 # condição inicial, posição inicial [m]
v0 = 0.0

# condição inicial, velocidade inicial [m/s]
# inicializar domínio temporal [s]
t = np.arange(t0, tf, dt)

# inicializar solução
a = np.zeros(np.size(t)) # aceleração [m/s2]

v = np.zeros(np.size(t))
x = np.zeros(np.size(t))
x[0] = x0 # velocidade [m/s]
v[0] = v0 # posição [m]


def a_res(t, x, v):
    """
    Aceleração resultante (total) em função do tempo e velocidade
    input: t = instante de tempo [escalar]
    x = posição instantânea [escalar]
    v = velocidade instantânea [escalar]
    output: aceleração instantânea resultante [escalar]
    """
    m = 1.0 # massa [kg]
    
    α = 1.0 # coef. potencial quártico [N/m3]
    k = 0.2 # constante da mola [N/m]
    b = 0.01 # constante de amortecimento [kg/s]
    F_0 = 5.0 # amplitude da força externa [N]
    ω_f = 0.6 # frequencia angular da força externa [rad/s]

    return - (k * x + 4 * α * x ** 3 + b * v - F_0 * np.cos(ω_f * t)) / m

def rk4_x_v(t, x, v, a, dt):
    """
    Integração numérica das equações diferenciais:
    dx/dt
    = v(t,x)
    d2x/dt2 = a(t,x)
    Erro global: proporcional a dt**4
    input: t = instante de tempo
    x(t) = posição
    v(t) = velocidade
    a = dv/dt = Força(t,x,v) / massa : é uma FUNÇÃO
    dt = passo temporal
    output: xp = x(t+dt)
    vp = v(t+dt)
    """
    # cálculo dos declives
    k1v = a(t, x, v)
    k1x = v
    k2v = a(t + dt / 2.0, x + k1x * dt / 2.0, v + k1v * dt/ 2.0)
    k2x = (v + k1v * dt / 2.0)
    k3v = a(t + dt / 2.0, x + k2x * dt / 2.0, v + k2v * dt / 2.0)
    k3x = (v + k2v * dt / 2.0)
    k4v = a(t + dt, x + k3x * dt, v + k3v * dt)
    k4x = (v + k3v * dt)

    # cálculo da posição e velocidade
    xp = x + (k1x + 2.0 * k2x + 2.0 * k3x + k4x) / 6.0 * dt
    vp = v + (k1v + 2.0 * k2v + 2.0 * k3v + k4v) / 6.0 * dt
    return xp, vp


# percorrer o domínio temporal e resolver a equação
# de movimento usando o método RK4
for i in range(np.size(t) - 1):
    x[i + 1], v[i + 1] = rk4_x_v(t[i], x[i] ,v[i] ,a_res , dt)
plt.plot(t, x, 'r-')
plt.xlabel("Tempo decorrido, t [s]")
plt.ylabel("Posição, x [m]")
plt.show()
# Guardamos a velocidade e a posição para mais tarde
vB = v
xB = x

plt.plot(xB, vB, 'r-')
plt.xlabel("Posição, x [m]")
plt.ylabel("Velocidade, v [m/s]")
plt.show()