#  Simule o movimento do pêndulo usando o método de Euler-Cromer durante 10 s. A massa inicia
#  com ângulo θ = 10∘ e com velocidade nula.

# repita a comparação com ângulos iniciais de 20° e 30°. As soluções numéricas e teóricas são diferentes?

import numpy as np
import matplotlib.pyplot as plt

t0 = 0.0 # condição inicial, tempo [s]

tf = 10.0 # limite do domínio, tempo final [s]
dt = 0.001 # passo [s]

θ0 = 10.0 * np.pi / 180 # condição inicial, ângulo inicial [rad]
ω0 = 0.0 # condição inicial, velocidade angular inicial [rad/

L = 1.0 # comprimento do fio [m]
g = 9.8
# inicializar domínio temporal [s]
t = np.arange(t0, tf, dt)

# inicializar solução
γ = np.zeros(np.size(t)) # aceleração angular [rad/s2]
ω = np.zeros(np.size(t)) # velocidade angular [rad/s]
θ = np.zeros(np.size(t)) # ângulo [rad]
θ[0] = θ0
ω[0] = ω0

# método de Euler
for i in range(np.size(t) - 1):
    γ[i] = - g / L * np.sin(θ[i])
    ω[i + 1] = ω[i] + γ[i] * dt
    θ[i + 1] = θ[i] + ω[i + 1] * dt

plt.plot(t, θ * 180 / np.pi, 'b-')
plt.xlabel("Tempo decorrido, t [s]")
plt.ylabel("Ângulo, θ [°]")
plt.show()
 
T = 2 * np.pi * np.sqrt(L / g)
print("Período de oscilação, T = {0:.2f} s".format(T))

# Solução analítica
A = 10 * np.pi / 180 # amplitude [rad]
φ = 0.0 # constante de fase [rad]
θ_a = A * np.cos(np.sqrt(g / L) * t + φ) # equação do movimento [rad]

plt.plot(t, θ * 180 / np.pi, 'b-', t, θ_a * 180 / np.pi, 'r-')
plt.xlabel("Tempo decorrido, t [s]")
plt.ylabel("Ângulo, θ [°]")
plt.legend(['Solução numérica', 'Solução analítica'])
plt.show()



