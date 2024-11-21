import numpy as np
import matplotlib.pyplot as plt

# 2. a)


def metEuler(v0, t0, tf, y0, dt):
    n = int((tf-t0) / dt + 0.1)

    t = np.zeros(n + 1)
    y = np.zeros(n + 1)
    vy = np.zeros(n + 1)
    ay = np.zeros(n + 1)

    vy[0] = v0
    t[0] = t0
    y[0] = y0

    for i in range(n):
        ay[i] = 9.8 - ((9.8/6.8*2) * vy[i] * np.abs(vy[i]))

        vy[i + 1] = vy[i] + ay[i] * dt
        y[i + 1] = y[i] + vy[i] * dt
        t[i + 1] = t[i] + dt

    return t, y, vy, ay


t, y, v, a = metEuler(50, 0, 5, 0, 5)

plt.plot(y, t)
plt.xlabel("Tempo (s)")
plt.ylabel("Altura (m)")
plt.show()

# 2. b)

t, y, v, a = metEuler(50, 0, 100, 0, 100)

count = 0
# Tentei ver quando a aceleração era 0, arranjar o y correspondente, mas não consegui.
for i in v:
    if i == 0:
        print(f"Altura máxima = {y[count]} m")
    else:
        count += 1
      # posso concluir que não haverá altura máxima

# 2. c)
print("O fogo de artifício explode antes de atingir a altura máxima. ")
