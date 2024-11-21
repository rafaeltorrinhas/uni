import numpy as np
import sympy
import matplotlib.pyplot as plt

# 2.2

t = np.linspace(0.0, 4.0, 100)
v_T = 6.80  # m/s
g = 9.80665  # m/s²

y = (v_T ** 2 / g) * np.log(np.cosh(g * t / v_T))

# plt.plot(t, y)
# plt.xlabel("Tempo decorrido, t (s)")
# plt.ylabel("Posição , y (m)")
# plt.scatter(t, y)
# plt.show()

t, v_T, g = sympy.symbols("t, v_T, g")
y = (v_T ** 2 / g) * sympy.log(sympy.cosh(g*t / v_T))
v = sympy.diff(y, t)

v_lam = sympy.lambdify(t, v.subs({v_T: 6.80, g: 9.80665}), "numpy")

t_array = np.linspace(0.0, 4.0, 100)

# plt.plot(t_array, v_lam(t_array))
# plt.xlabel("Tempo decorrido, t_array (t)")
# plt.ylabel("Velocidade, v_lam (m/s)")
# plt.show()

a = sympy.diff(v, t)
print("a(t) =", a)

a_lam = sympy.lambdify(t, a.subs({v_T: 6.80, g: 9.80665}), "numpy")
plt.plot(t_array, a_lam(t_array))
plt.xlabel("Tempo decorrido, t_array (t)")
plt.ylabel("Aceleração")
plt.show()
