import numpy as np
import matplotlib.pyplot as plt


m = np.array([.15, .20, .16, .11, .25, .32, .40, .45, .50, .55])
t = np.array([1.21, 1.4, 1.26, 1.05, 1.60, 1.78, 2, 2.11, 2.22, 2.33])

k = 4 * np.pi()*np.pi() * m/(t*t)


plt.loglog(m, t*t, "o-")
# plt.plot(np.log(m), np.log(t*t), "o-")
plt.show()

print(k)
