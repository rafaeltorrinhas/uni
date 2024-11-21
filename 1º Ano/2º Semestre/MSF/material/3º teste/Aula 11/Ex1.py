# a) lei do movimento assumindo massa em repouso, grafico da posicao em funcao do tempo
#  Euler-Cromer (adequado para movimentos oscilatórios) para descrever a dinâmica do movimento da massa.

# b) maximos e minimos locais da posicao usando interpolacao pelo polinomio de lagrange

# c) plot do logaritmo das amplitudes obtidas em b), em função do tempo e ajuste linear
# qual e a dependencia entre amplitude e tempo? qual e o declive e seu erro? concorda com a teoria 


import numpy as np
import matplotlib.pyplot as plt

# a)

t0 = 0.0 # condição inicial, tempo [s]
tf = 20.0 # limite do domínio, tempo final [s]
dt = 0.001 # passo [s]
x0 = 0.4 # condição inicial, posição inicial [m]
v0 = 0.0 # condição inicial, velocidade inicial [m/s]

m = 0.25 # massa [kg]
k = 1.0 # constante da mola [N/m]
b = 0.1 # constante de amortecimento [kg/s]

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
    a[i] = - (k * x[i] + b * v[i]) / m
    v[i + 1] = v[i] + a[i] * dt
    x[i + 1] = x[i] + v[i + 1] * dt

plt.plot(t, x, 'b-')
plt.xlabel("Tempo decorrido, t [s]")
plt.ylabel("Posição, x [m]")
plt.show()

# b)

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

# arrays com valores máximos, mínimos e respetivos instantes de tempo
t_max = np.array([t0])
x_max = np.array([x0])
t_min = np.array([])
x_min = np.array([])

# Pesquisar pelo máximos e mínimos de x.
# Aqui definimos uma "janela corrida" no tempo em passos de 2, i.e, analisamos
# os máximos/mínimos que ocorrem entre t[i] e t[i+2], com i = 0, 2, 4, 6, etc.
# de forma a evitar encontros duplicados
for i in range(0, np.size(t) - 3, 2):
    # Percorrer domínio temporal em sequências de três:
    # x[i], x[i+1], x[i+2] e respetivos instantes de tempo para i = 0, ..., N-3
    tm, xm = maxminv(t[i], t[i+1], t[i+2], x[i], x[i+1], x[i+2])
    # verificar se max/min esta dentro da "janela corrida" (t[i] <-> t[i+2])
    if t[i] < tm and tm < t[i+2]:
    # verificar se é máximo
        if xm > np.maximum(x[i], x[i+2]):
            t_max = np.append(t_max, tm)
            x_max = np.append(x_max, xm)
        else:
            t_min = np.append(t_min, tm)
            x_min = np.append(x_min, xm)

plt.plot(t, x, 'b-')
plt.scatter(t_max, x_max, color='red')
plt.scatter(t_min, x_min, color='green')
plt.xlabel("Tempo decorrido, t [s]")
plt.ylabel("Posição, x [m]")
plt.show()


# c) 

# agregamos os instantes de tempo correspondentes aos "extremos" = max + min
t_ext = np.append(t_min, t_max)
# consideramos as amplitudes como valores positivos dos extremos
A_ext = np.abs(np.append(x_min, x_max))
plt.scatter(t_ext, np.log(A_ext), color='red')
plt.xlabel("Tempo decorrido, t [s]")
plt.ylabel("ln(A)")
plt.show()

# obter parámetros ajustados e respetivos erros
# declive: p[0] +/- sqrt(C[0,0])
# ordenada na orígem: p[1] +/- sqrt(C[1,1])
# C[i,j] matriz da covariância
p, C = np.polyfit(t_ext, np.log(A_ext), 1, cov='unscaled')
plt.plot(t, p[0] * t + p[1], 'b-')
plt.scatter(t_ext, np.log(A_ext), color='red')
plt.xlabel("Tempo decorrido, t [s]")
plt.ylabel("ln(A)")
plt.show()

# p[0] é o declive, p[1] é a ordenada na orígem
print("-b/2m = ", -b/(2*m))
print("p[0] = {0:.2f} ± {1:.2f}".format(p[0] , np.sqrt(C[0,0])))