#  1 - movimento da bola usando o método de Euler a 3D. Considerando a força de gravidade e a resistência do ar.
#  2 - gráfico da trajetória da bola de ténis em 3D.  ponto a bola cai no solo. O serviço é válido, sim ou não?
#  3 - variação da energia mecânica de t0 = 0 até ao momento em que a bola bate no solo (ts = 0.41 s)
#  4 - trabalho realizado pela força de resistência do ar até às posições nos três instantes t0 = 0, t1 = 0.2 s e t2 = 0.4 s
#  5 - trabalho realizado pela força de resistência do ar entre t0 = 0 e t2 = 0.4 s usando a conservação de energia
 

import numpy as np
import matplotlib.pyplot as plt
  
# 1) 


t0 = 0.0 # condição inicial, tempo [s]
tf = 0.5 # limite do domínio, tempo final [s]
dt = 0.001 # passo [s]

r0 = np.array([0.0, 2.0, 3.0]) # condição inicial, posição inicial [m]
v0 = np.array([160.0, 20.0, -20.0]) * 1000 / 3600 # condição inicial, velocidade ini

g = 9.8 # aceleração gravítica [m/s^2]
v_T = np.linalg.norm(v0) # velocidade terminal [m/s]
D = g / v_T ** 2 # coeficiente de resistência do ar [m^-1]

# inicializar domínio [s]
N = int((tf - t0) / dt + 1)
t = np.linspace(t0, tf, num=N)

# inicializar solução, aceleração [m/s^2]
a = np.zeros([np.size(t), 3]) # aceleração resultante
a_res = np.zeros([np.size(t), 3]) # aceleração devido à resistência do ar
a_grv = np.zeros([np.size(t), 3]) # aceleração devido à gravidade

# inicializar solução, velocidade [m/s]
v = np.zeros([np.size(t), 3])
v[0, :] = v0

# inicializar solução, posição [m]
r = np.zeros([np.size(t), 3])
r[0, :] = r0
for i in range(np.size(t) - 1):

    # calcular aceleração  
    a_grv[i, :] = - g * np.array([0.0, 0.0, 1.0])
    a_res[i, :] = - D * np.linalg.norm(v[i, :]) * v[i, :]
    a[i, :] = a_grv[i, :] + a_res[i, :]
    v[i + 1, :] = v[i, :] + a[i, :] * dt
    r[i + 1, :] = r[i, :] + v[i, :] * dt


# 2) 

fig = plt.figure(figsize=(10, 10))
ax = plt.axes(projection='3d')

# Trajetória da bola
ax.plot3D(r[:, 0], r[:, 1], r[:, 2], 'b-')
ax.set_title('Trajetória da bola de ténis em 3D')
ax.set_box_aspect(aspect = (14, 8, 3))
plt.show()

# i-ésimo elemento do vetor r cuja componente z é superior a 0.
# É em t(i_ts) que a bola atinge o campo (z = 0).
i_ts = np.size(r[r[:,2] > 0], 0) - 1
ts = t[i_ts]
rs = r[i_ts, :]
print("Tempo no impacto com o campo, t_s = {0:.2f} s".format(ts))
print("Coordenada de impacto no campo, r(t = {0:.2f} s) = ({1:.2f}, {2:.2f}, {3:.2f}) m".format(ts, rs[0], rs[1], rs[2]))


# 3) 

M = 0.057 # massa da bola, [kg]
v_norm = np.linalg.norm(v, axis=1) # norma da velocidade, |v(t)|
E_p = M * g * r[0:i_ts, 2] # energia potencial, [J]
E_c = 0.5 * M * v_norm[0:i_ts] ** 2 # energia cinética, [J]
E_m = E_p + E_c # energia mecânica, [J]

# representação gráfica das energias
plt.plot(t[0:i_ts], E_p, 'r-', t[0:i_ts], E_c, 'g-', t[0:i_ts], E_m, 'b-')
plt.legend(['E_p', 'E_c', 'E_m'])
plt.xlabel("t [s]")
plt.ylabel("Energia [J]")
plt.title('Decomposição da energia da bola')
plt.show()


# 4)

def integral(f, D, a, b):

    dt = (D[1] - D[0]) / len(f)
    i_a = int((a - D[0]) / dt)
    i_b = int((b - D[0]) / dt)
    sum = 0.0

    for i in range(i_a, i_b):
        sum += (f[i] + f[i + 1]) / 2.0 * dt

    return sum

t1 = 0.2
t2 = 0.4
D = np.array([t0, tf])
F_res = M * a_res
F_dot_v = np.sum(F_res * v, axis = 1)
W0 = integral(F_dot_v, D, t0, t0)
W1 = integral(F_dot_v, D, t0, t1)
W2 = integral(F_dot_v, D, t0, t2)

print("W_res(t0 = 0.1 s) = {0:.2f} J".format(W0))
print("W_res(t1 = 0.2 s) = {0:.2f} J".format(W1))
print("W_res(t2 = 0.4 s) = {0:.2f} J".format(W2))


# 5)

i_t0 = int(t0 / dt)
i_t2 = int(t2 / dt)
print("A perda de energia mecânica e dE_m = {0:.2f} J".format(E_m[i_t2] - E_m[i_t0]))


# 6)

W_res_ref = -9.078705 # valor de referência para W_res, J
F = M * a_res
F_dot_v = np.sum(F * v, axis = 1)  
W_res_trab = integral(F_dot_v, D, t0, t2) # W_res pelo trabalho dissipado
W_res_emec = E_m[i_t2] - E_m[i_t0] # W_res pela perda de energia mecânica

print("W_res_trab = ({0:.6f} ± {1:.6f}) J".format(W_res_trab, np.abs(W_res_trab - W_res_ref)))
print("W_res_emec = ({0:.6f} ± {1:.6f}) J".format(W_res_emec, np.abs(W_res_emec - W_res_ref)))

dt_vec = np.array([0.1, 0.01, 0.001, 0.0001, 0.00001])
Erro_res_trab = np.array([2, 0.1, 0.02, 0.001, 0.000006])
Erro_res_emec = np.array([0.05, 0.004, 0.0005, 0.00004, 0.000001])

# representação gráfica do erro
plt.loglog(dt_vec, Erro_res_trab, 'ro')
plt.loglog(dt_vec, Erro_res_emec, 'bo')
plt.legend(['Erro_res_trab', 'Erro_res_emec'])
plt.xlabel("dt [s]")
plt.ylabel("Erro [J]")
plt.show()