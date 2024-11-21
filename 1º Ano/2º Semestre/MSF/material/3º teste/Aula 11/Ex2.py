# a) euler cromer - lei do movimento, assumindo a velocidade inicial nula e posicao inicial 4m

# b) amplitude do movimento e o seu periodo no regime estacionario usando resultados numericos

# c) repeticao do ex para os valores de wf entre 0.2 e 2 rad/s. grafico da amplitude em regime estacionario 
# em funcao de wf. Qual é a freq angular wf que corresponde á maior amplitude


import numpy as np
import matplotlib.pyplot as plt


# a)


t0 = 0.0 # condição inicial, tempo [s]
tf = 300.0 # limite do domínio, tempo final [s]
dt = 0.001 # passo [s]

x0 = 4.0 # condição inicial, posição inicial [m]
v0 = 0.0 # condição inicial, velocidade inicial [m/s]

m = 1.0 # massa [kg]
k = 1.0 # constante da mola [N/m]
b = 0.05 # constante de amortecimento [kg/s]
F_0 = 7.5 # amplitude da força externa [N]
ω_f = 0.5 # frequência angular da força externa [rad/s]

# inicializar domínio temporal [s]
t = np.arange(t0, tf, dt)

# inicializar solução
a = np.zeros(np.size(t)) # aceleração [m/s2]
v = np.zeros(np.size(t)) # velocidade [m/s]
x = np.zeros(np.size(t)) # posição [m]
x[0] = x0
v[0] = v0

# método de Euler-Cromer
for i in range(np.size(t) - 1):
    a[i] = - (k * x[i] + b * v[i] - F_0 * np.cos(ω_f * t[i])) / m
    v[i + 1] = v[i] + a[i] * dt
    x[i + 1] = x[i] + v[i+1] * dt

plt.plot(t, x, 'b-')
plt.xlabel("Tempo decorrido, t [s]")
plt.ylabel("Posição, x [m]")
plt.show()


# b)

# arrays com valores máximos, respetivos instantes de tempo, e o período

t_max = np.array([]) # instante de tempo nos máximos
x_max = np.array([]) # máximos de amplitude
T = np.array([]) # período entre máximos

# Pesquisar pelo máximos de x.
# Aqui definimos uma "janela corrida" no tempo em passos de 2, i.e, analisamos
# os máximos que ocorrem entre t[i] e t[i+2], com i = 0, 2, 4, 6, etc.
# de forma a evitar encontros duplicados

def maxminv(x0,x1,x2,y0,y1,y2):
    # Máximo ou mínimo usando o polinómio de Lagrange
    # Dados (input): (x0,y0), (x1,y1) e (x2,y2)
    # Resultados (output): xm, ymax
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
    # Percorrer domínio temporal em sequências de três:
    # x[i], x[i+1], x[i+2] e respetivos instantes de tempo para i = 0, ..., N-3
    tm, xm = maxminv(t[i], t[i+1], t[i+2], x[i], x[i+1], x[i+2])
    # verificar se extremo está dentro da "janela corrida" (t[i] <-> t[i+2])
    if t[i] < tm and tm < t[i+2]:
    # verificar se é máximo e adicionar a lista se esse for o caso
        if xm > np.maximum(x[i], x[i+2]):
            t_max = np.append(t_max, tm)
            x_max = np.append(x_max, xm)

            # calcular diferenca entre os dois ultimos instantes de tempo
            # e adicionar ao array dos periodos
            T = np.append(T, t_max[np.size(t_max) - 1] - t_max[np.size(t_max) - 2])

fig, ax1 = plt.subplots()
ax1.set_xlabel('Tempo decorrido, t [s]')
ax1.set_ylabel('Amplitude, x_max [m]', color='blue')
ax1.tick_params(axis='y', labelcolor='blue')
ax1.plot(t_max, x_max, 'b-')

ax2 = ax1.twinx() # criar segundo sistema de eixos com o mesmo eixo Ox
ax2.set_ylabel('Período, T [s]', color='red')
ax2.plot(t_max, T, 'r-')
ax2.tick_params(axis='y', labelcolor='red')

plt.show()

print("O período em regime estacionário é T = {0:.2f} s".format(T[-1]))
print("A amplitude em regime estacionário é x_max = {0:.2f} m".format(x_max[-1]))

# c)

ω_fs = np.array([0.2, 0.4, 0.6, 0.8, 1.0, 1.2, 1.4, 1.6, 1.8, 2.0])
x_maxs = np.array([7.81, 8.93, 11.71, 20.71, 149.91, 16.9, 7.79, 4.80, 3.34, 2.50])

plt.plot(ω_fs, x_maxs, 'b-')
plt.xlabel("Frequencia angular, ω_fs [rad/s]")
plt.ylabel("Amplitude, x_maxs [m]")
plt.show()