import numpy as np
import matplotlib.pyplot as plt


x = np.array([222.0, 207.5, 194.0, 171.5, 153.0, 133.0, 113.0, 92.0])
y = np.array([2.3, 2.2, 2.0, 1.8, 1.6, 1.4, 1.2, 1.0])
N = len(x)
sum_x = np.sum(x)
sum_y = np.sum(y)
sum_xy = np.sum(x*y)
sum_xx = np.sum(x*x)
sum_yy = np.sum(y*y)
r2 = (N * sum_xy - sum_x * sum_y)**2 / ((N * sum_xx - sum_x**2) * (N * sum_yy - sum_y**2))
m = ((N * sum_xy - sum_x * sum_y)/(N*(sum_xx)-((sum_x)**2)))
b = (((sum_xx * sum_y)-sum_x * sum_xy)/(N*sum_xx-((sum_x)**2)))
dm = np.abs(m) * np.sqrt(((1/r2)-1)/(N-2)) 
db = dm * np.sqrt(sum_xx/N)



print(f"r² = {r2}\nb = {b}\ndb = {db}\nm = {m}\ndm = {dm}" )
